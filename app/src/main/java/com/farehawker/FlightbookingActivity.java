package com.farehawker;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FlightbookingActivity extends AppCompatActivity
{
    //Tag used in Log
    String TAG="FlightbookingActivity";
    LinearLayout linear_departure, linear_return;
    TextView text_departure, text_return;
    TextView text_onewaytrip,text_roundtrip;
    TextView text_fromlocation,text_fromcountrycity,text_fromcountry, text_tolocation,text_tocountrycity,text_tocountry;

    private int mday, yday;
    private int mmonth, ymonth;
    private int myear, yyear,n,c,i;
    Spinner spinner;
    String items;
    int spn_count=1;
    ImageView swap_image;
    static final int DATE_PICKER_ID = 1111;
    static final int Dialog_id = 111;
    //for count
    int count=1;
    int count_child=0;
    int count_infants=0;
    String adult,child,infants;
    ImageView Adults_btnminus,Adult_btnplus,child_btnminus,child_btnplus,infants_btnminus,infants_btnplus;
    TextView text_Adult,text_Child,text_infant;
    Button search_flightbtn;
    String AirportcodeTO,citynameTO,countryTO,AirportcodeFROM,citynameFROM,countrynameFROm;
    int returwrong,departurewron;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flightbooking);

        text_onewaytrip=(TextView)findViewById(R.id.oneway_triptxt);
        text_roundtrip=(TextView)findViewById(R.id.round_triptxt);

        linear_departure = (LinearLayout) findViewById(R.id.linearlayout_departure);
        linear_departure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_PICKER_ID);
            }
        });
        linear_return = (LinearLayout) findViewById(R.id.linearlayout_return);
        linear_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(Dialog_id);
            }
        });

        //get intent values
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        //this is for date picker
        text_departure = (TextView) findViewById(R.id.txt_departureday);
        text_return = (TextView) findViewById(R.id.txt_returnday);
        Calendar cc = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(cc.getTime());

        // System.out.println("Currrent Date Time : "+formattedDate);
        text_departure.setText(formattedDate);
        Log.i(TAG,"Date in return"+formattedDate);
        text_return.setText(formattedDate);
        //this is for location pickup
        text_fromlocation = (TextView) findViewById(R.id.text_fromid);
        text_tolocation = (TextView) findViewById(R.id.tex_toid);
        text_fromcountrycity=(TextView)findViewById(R.id.fromcityname);
        text_tocountrycity=(TextView)findViewById(R.id.text_tocountrycityname);
        text_fromcountry=(TextView)findViewById(R.id.text_fromcountryname);
        text_tocountry=(TextView)findViewById(R.id.text_tocountry);

        //get intent from DestinationsearchActivity
        AirportcodeTO = getIntent().getStringExtra("airport_codedestination");
        citynameTO = getIntent().getStringExtra("citynamedestination");
        countryTO=getIntent().getStringExtra("Countrydes");
        //get intent from Searchactivity
        AirportcodeFROM = getIntent().getStringExtra("airport_code");
        citynameFROM = getIntent().getStringExtra("cityname");
        countrynameFROm=getIntent().getStringExtra("countryname");

        //set the total intent
        text_tolocation.setText(AirportcodeTO);
        text_tocountrycity.setText(citynameTO);
        text_tocountry.setText(countryTO);
        text_fromlocation.setText(AirportcodeFROM);
        text_fromcountrycity.setText(citynameFROM);
        text_fromcountry.setText(countrynameFROm);
        //Receive  the intent to the searchactivity
            String returnair=getIntent().getStringExtra("duprair");
            String returncity=getIntent().getStringExtra("duprcity");
            String returncountry=getIntent().getStringExtra("dupcountry");
            //receive the Intent to the Destinationactivity
            String descode=getIntent().getStringExtra("accdescode");
            String descity=getIntent().getStringExtra("accdescity");
            String descountry=getIntent().getStringExtra("accdescountry");
           // convert into all String
            String rA=returnair;
            String rB=returncity;
            String rC=descode;
            String rD=descity;
            String rF =returncountry;
            String rE=descountry;

        //Convert all original intent
            String a=AirportcodeTO;
            String b=citynameTO;
            String f=countryTO;
            String c=AirportcodeFROM;
            String d=citynameFROM;
            String e=countrynameFROm;
        if (a==null){
            text_tolocation.setText(rA);
        }if (b==null){
            text_tocountrycity.setText(rB);
        }
        if (f==null){
            text_tocountry.setText(rF);
        }
      if (c==null){
            text_fromlocation.setText(rC);
        }if (d==null){
            text_fromcountrycity.setText(rD);
        }
        if (e==null){
            text_fromcountry.setText(rE);
        }

        LinearLayout linearLayout_from=(LinearLayout)findViewById(R.id.linearlayout_from);
        LinearLayout linearLayout_to=(LinearLayout)findViewById(R.id.linearlayout_to);
        linearLayout_from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii=new Intent(FlightbookingActivity.this,SearchviewActivity.class);
                     ii.putExtra("dupair",AirportcodeTO);
                     ii.putExtra("dupcity",citynameTO);
                     ii.putExtra("dupcountrydest",countryTO);
                      startActivity(ii);
            }
        });
        linearLayout_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent iii = new Intent(FlightbookingActivity.this, DestinationSearchActivity.class);

                   iii.putExtra("orair",AirportcodeFROM);
                   iii.putExtra("orcity",citynameFROM);
                   iii.putExtra("oricountry",countrynameFROm);
                    startActivity(iii);
            }
        });



        text_onewaytrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_onewaytrip.setBackgroundColor(Color.BLUE);
                text_roundtrip.setBackgroundColor(Color.RED);
                linear_return.setVisibility(View.INVISIBLE);
            }
        });
        text_roundtrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_roundtrip.setBackgroundColor(Color.BLUE);
                text_onewaytrip.setBackgroundColor(Color.RED);
                linear_return.setVisibility(View.VISIBLE);
            }
        });
        swap_image=(ImageView)findViewById(R.id.image_swape);
        swap_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String text_swapfrom = text_fromlocation.getText().toString();
               String text_swapto = text_tolocation.getText().toString();
                //for country name exchange
                String text_swapfromcity = text_fromcountrycity.getText().toString();
                String text_swaptocity = text_tocountrycity.getText().toString();
                //for city name exchange
                String text_swapfromcountry  = text_fromcountry.getText().toString();
                String text_swaptocountry= text_tocountry.getText().toString();
                text_fromlocation.setText(text_swapto);
                text_tolocation.setText(text_swapfrom);
                text_fromcountrycity.setText(text_swaptocity);
                text_tocountrycity.setText(text_swapfromcity);
                text_fromcountry.setText(text_swaptocountry);
                text_tocountry.setText(text_swapfromcountry);
            }
        });
        spinner = (Spinner) findViewById(R.id.spinerforclass);
        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("All");
        categories.add("Economy");
        categories.add("Premium Economy");
        categories.add("Business");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                items = parent.getItemAtPosition(position).toString();
                if (items.equals("All")){
                    spn_count=1;
                }else if (items.equals("Economy")){
                    spn_count=2;
                }else if (items.equals("Premium Economy")){
                    spn_count=3;
                }else {
                    spn_count=4;}
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //for count
        text_Adult=(TextView)findViewById(R.id.text_adults);
        text_Child=(TextView)findViewById(R.id.text_child);
        text_infant=(TextView)findViewById(R.id.text_infants);
        Adults_btnminus=(ImageView) findViewById(R.id.image_adultminus);
        Adult_btnplus=(ImageView) findViewById(R.id.image_adultplus);
        child_btnminus=(ImageView) findViewById(R.id.image_childminus);
        child_btnplus=(ImageView) findViewById(R.id.image_childplus);
        infants_btnminus=(ImageView) findViewById(R.id.image_infantsminus);
        infants_btnplus=(ImageView) findViewById(R.id.image_infantsplus);
        Adult_btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((count <9)&&(count+count_child<9))
                {
                    count = count +1;
                    adult = String.valueOf(count);
                    text_Adult.setText(adult);
                }
                else if(count==9)
                {
                    Toast.makeText(FlightbookingActivity.this,"Adults cannot be more than 9",Toast.LENGTH_LONG).show();
                }
            }
        });
        Adults_btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((count >1)&&(count>count_infants) ) {
                    count = count -1;

                    adult = String.valueOf(count);
                    text_Adult.setText(adult);

                }
                else if(count==count_infants && (count>1))
                {
                    count=count-1;
                    count_infants=count_infants-1;
                    text_Adult.setText(Integer.toString(count));
                    text_infant.setText(Integer.toString(count_infants));
                }
            }
        });

        child_btnplus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if ((count_child < 9)&&(count_child+count<9))
                {
                    count_child = count_child + 1;
                    child = String.valueOf(count_child);
                    text_Child.setText(child);
                }
                else if((count_child+count)>=8)
                {
                    Toast.makeText(FlightbookingActivity.this,"Adult and Children cannot be more than 9.",Toast.LENGTH_LONG).show();
                }

            }
        });
        child_btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count_child >0) {
                    count_child = count_child - 1;
                    child = String.valueOf(count_child);
                    text_Child.setText(child);
                }}
        });
        infants_btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((count_infants<9)&&(count_infants<count)){
                    count_infants = count_infants +1;
                    infants = String.valueOf(count_infants);
                    text_infant.setText(infants);
                }
                else if(count==count_infants)
                {
                    Toast.makeText(FlightbookingActivity.this,"Infants cannot be more than Adults",Toast.LENGTH_LONG).show();
                }
            }
        });
        infants_btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count_infants >0) {
                    count_infants = count_infants - 1;
                    infants = String.valueOf(count_infants);
                    text_infant.setText(infants);
                }
            }
        });
        if (TextUtils.isEmpty(text_fromlocation.getText().toString())){
            text_fromlocation.setText("DEL");
            text_fromcountrycity.setText("New Delhi");
            text_fromcountry.setText("India");
        }
        if (TextUtils.isEmpty(text_tolocation.getText().toString())){
            text_tolocation.setText("BOM");
            text_tocountrycity.setText("Mumbai");
            text_tocountry.setText("India");
        }
        search_flightbtn=(Button)findViewById(R.id.button_searchflight);
        search_flightbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((text_fromlocation.getText().toString().equals(text_tolocation.getText().toString()))){
                        new AlertDialog.Builder(FlightbookingActivity.this)
                            .setMessage("Please select Origin or Destination ")
                            //.setPositiveButton("Yes",null)
                                .setNeutralButton("                             OK",null)
                            .show();

                        Toast.makeText(FlightbookingActivity.this, "Please fill Requered fields", Toast.LENGTH_LONG).show();

                } else {
                    String fromc = text_fromlocation.getText().toString();
                    String toc = text_tolocation.getText().toString();
                    String adultc = text_Adult.getText().toString();
                    String childc = text_Child.getText().toString();
                    String infacntc = text_infant.getText().toString();
                    String infantc=infacntc;
                    String depadate = text_departure.getText().toString();
                    String retunrdate = text_return.getText().toString();
                    String cabinclas = String.valueOf(spn_count);
                    if ((linear_return.isShown()) && ((!text_fromcountry.getText().toString().equals("India")) || (!text_tocountry.getText().toString().equals("India"))))
                    {
                        Toast.makeText(getApplicationContext(), "this is third segment ", Toast.LENGTH_SHORT).show();
                        Intent in =new Intent(FlightbookingActivity.this,International_Roundtrip.class);

                        in.putExtra("origin",fromc);
                        in.putExtra("destination",toc);
                        in.putExtra("adultCount",adultc);
                        in.putExtra("childCount",childc);
                        in.putExtra("infantCount",infantc);
                        in.putExtra("departureDate",depadate);
                        in.putExtra("returnDate",retunrdate);
                        in.putExtra("cabinClass",cabinclas);

                        startActivity(in);
                    }
                    else
                        {
                        if (linear_return.isShown())
                        {
                            if (TextUtils.isEmpty(text_return.getText().toString()) || (returwrong < departurewron)) {
                                //new AlertDialog.Builder(FlightbookingActivity.this)
                                AlertDialog.Builder builder = new AlertDialog.Builder(FlightbookingActivity.this);
                                builder.setMessage("Please select Return Date");
                                builder.setPositiveButton("OK", null);
                                AlertDialog dialog = builder.show();

                                // Must call show() prior to fetching text view
                                TextView messageView = (TextView)dialog.findViewById(android.R.id.message);
                                messageView.setGravity(Gravity.CENTER);
                            }
                            //Executed when
                            else
                                {
                                Intent in = new Intent(FlightbookingActivity.this, RoundTripActivity.class);
                                in.putExtra("originround", fromc);
                                in.putExtra("destinationround", toc);
                                in.putExtra("departureround", depadate);
                                in.putExtra("returnround", retunrdate);
                                in.putExtra("adultround", adultc);
                                in.putExtra("childround", childc);
                                in.putExtra("infantsround", infacntc);
                                in.putExtra("cabinclass", cabinclas);
                                startActivity(in);
                            }
                        } else
                            {
                            Intent inr = new Intent(FlightbookingActivity.this, OnewayActivityresult.class);
                            inr.putExtra("originround", fromc);
                            inr.putExtra("destinationround", toc);
                            inr.putExtra("departureround", depadate);
                            inr.putExtra("adultround", adultc);
                            inr.putExtra("childround", childc);
                            inr.putExtra("infantsround", infacntc);
                            inr.putExtra("cabinclass", cabinclas);
                            startActivity(inr);
                        }
                    }
                }
            }
        });

    }
    //For date calender show
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            //dialog for one way
            case DATE_PICKER_ID:
//                 create a new DatePickerDialog with values you want to show
                DatePickerDialog datePickerDialog = new DatePickerDialog(this,android.R.style.Theme_Holo_Dialog,datePickerListener, yyear, ymonth, yday);
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DATE, 0); // Add 0 days to Calendar
                Date newDate = calendar.getTime();
                Log.i(TAG,"newDate"+newDate);
                datePickerDialog.getDatePicker().setMinDate(newDate.getTime() - (newDate.getTime() % (24 * 60 * 60 * 1000)));
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                return datePickerDialog;
//             create dialog for return Trip
            case Dialog_id:
                DatePickerDialog date = new DatePickerDialog(this,android.R.style.Theme_Holo_Dialog, datePickerListener2, myear,mmonth,mday){
                    //calendar.add(Calendar.DATE, 0); // Add 0 days to Calendar


                    // Compare the date selected in picker with the One way date.
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth)
                    {

                        if (year < myear) {
                            Log.i(TAG,"day"+mday);
                            view.updateDate(myear, mmonth, mday);
                        }else if (monthOfYear < mmonth && year == myear) {
                            Log.i(TAG,"day"+mday);
                            view.updateDate(myear, mmonth, mday);
                        }
                        else if (dayOfMonth < mday && year == myear && monthOfYear == mmonth)
                        {
                            Log.i(TAG,"day"+mday);
                            view.updateDate(myear, mmonth, mday);
                        }
                    }

                };
                //return trip Date
                Log.i(TAG,"Here");
                Calendar calendar_ = Calendar.getInstance();
                Date newDate_ = calendar_.getTime();
                date.getDatePicker().setMinDate(newDate_.getTime() - (newDate_.getTime() % (24 * 60 * 60 * 1000)));
                date.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);

                return date;
        }
        return null;
    }
    //for one way date
    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
            mday = selectedDay;
            mmonth = selectedMonth;
            myear = selectedYear;
            String fm=""+selectedMonth;
            String fd=""+selectedDay;
            if((selectedMonth+1)<10){
                fm ="0"+(selectedMonth+1);
            }else {
                fm= String.valueOf((selectedMonth+1));
            }
            if (selectedDay<10) {
                fd = "0" +selectedDay;
            }
            departurewron= Integer.parseInt(fd);
            String departure_data= String.valueOf(new StringBuilder().append(selectedYear).append("-").append((fm)).append("-").append(fd));

            text_departure.setText(new StringBuilder().append(selectedYear).append("-").append((fm)).append("-").append(fd));
        }
    };
    //for return trip date
    private DatePickerDialog.OnDateSetListener datePickerListener2 = new DatePickerDialog.OnDateSetListener()
    {
        public void onDateSet(DatePicker viewv, int xselectedYear, int xselectedMonth, int xselectedDay)
        {
            returwrong=xselectedDay;
            String rfm=""+xselectedMonth;
            String rfd=""+xselectedDay;
            if((xselectedMonth+1)<10){
                rfm ="0"+(xselectedMonth+1);
            }else {
                rfm= String.valueOf((xselectedMonth+1));
            }
            if (xselectedDay<10) {
                rfd = "0" +xselectedDay;
            }
            returwrong= Integer.parseInt(rfd);
            text_return.setText(new StringBuilder().append(xselectedYear).append("-").append((rfm)).append("-").append(rfd));
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home);
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        super.onBackPressed();
        startActivity(new Intent(FlightbookingActivity.this, MainActivity.class));
        finish();
    }
}


