package com.farehawker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.farehawker.Adaptors.Fareoneway_adaptr;
import com.farehawker.Adaptors.OnewaytermsAdaptr;
import com.farehawker.Model.OnewayFare_model;
import com.farehawker.Model.Oneway_Farerulesmodel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class OnewayFareruleaActivity extends AppCompatActivity
{
  String orign,dest,endip,token,resultind,traceidone,adultone,childone,infantsone;
  String flightPrice,flightDepartureTime,flightCode,origin,destination;
  String countryFrom,countryTo;

    int base_o_oneway, tex_o_oneway,otherc_oneway,total_o_oneway;
    public static final String FARE_URL = "http://api.tektravels.com/BookingEngineService_Air/AirService.svc/rest/Farequote/";
    public static final String RULE_URL="http://api.tektravels.com/BookingEngineService_Air/AirService.svc/rest/FareRule/";
    private RecyclerView recyclerview_oneway;
    private Fareoneway_adaptr onewayAdaptr;
    ListView oneway_listview;
    private RecyclerView.LayoutManager onewaylayoutmanager;
    List<OnewayFare_model> onewaylist;
    OnewaytermsAdaptr dialogadaptr;
    List<Oneway_Farerulesmodel> onewayruleslist = new ArrayList<>();
    TextView basefare_oneway,texas_oneway,other_oneway,publish_oneway;
    CheckBox oneway_checkbox;
    TextView term_condition;
    TextView text_onward,text_dest;
    Button continue_booking;
    String airlineCode,airlineName,flightArrivalTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oneway_farerulea);
        Intent intent= getIntent();
        airlineName=intent.getStringExtra("flightName");
        airlineCode=intent.getStringExtra("airlineCode");
        endip = intent.getStringExtra("enduserip");
        token = intent.getStringExtra("tokenid");
        resultind=intent.getStringExtra("resultindex");
        traceidone=intent.getStringExtra("traceid");
        adultone=intent.getStringExtra("adultone");
        childone=intent.getStringExtra("childone");
        infantsone=intent.getStringExtra("infantsone");
        flightPrice=intent.getStringExtra("flightPrice");
        flightDepartureTime=intent.getStringExtra("flightDepartureTime");
        flightArrivalTime=intent.getStringExtra("arrivalTime");
        flightCode=intent.getStringExtra("flightCode");
        origin=intent.getStringExtra("origin");
        destination=intent.getStringExtra("destination");
        countryFrom=intent.getStringExtra("countryFrom");
        countryTo=intent.getStringExtra("countryTo");
        text_onward=(TextView)findViewById(R.id.onewayname);
        text_dest=(TextView)findViewById(R.id.onewaydestname);
        text_onward.setText(origin);
        text_dest.setText(destination);
        Toast.makeText(OnewayFareruleaActivity.this, "mag" + orign+"\n" + dest+"\n" + endip +"\n"+ token+"\n"+resultind+"\n"+traceidone+"\n"+adultone+"\n"+childone+"\n"+infantsone, Toast.LENGTH_LONG).show();
        makevolleyoneway();
        basefare_oneway=(TextView)findViewById(R.id.oneway_basefare);
        texas_oneway=(TextView)findViewById(R.id.oneway_texas);
        other_oneway=(TextView)findViewById(R.id.oneway_othercharge);
        publish_oneway=(TextView)findViewById(R.id.oneway_publisfare);
        term_condition=(TextView)findViewById(R.id.oneway_term_condi);
        continue_booking=(Button)findViewById(R.id.oneway_continuebooking);
        oneway_checkbox=(CheckBox)findViewById(R.id.oneway_chkWindows);
        recyclerview_oneway = (RecyclerView) findViewById(R.id.oneway_recyclerview);
        recyclerview_oneway.setHasFixedSize(true);
        onewaylayoutmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerview_oneway.setLayoutManager(onewaylayoutmanager);
        onewaylist = new ArrayList<>();
        term_condition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View view = getLayoutInflater().inflate(R.layout.terms_onewaylayout, null);
                oneway_listview = (ListView) view.findViewById(R.id.oneway_listview);

                final Dialog mBottomSheetDialog = new Dialog(OnewayFareruleaActivity.this, R.style.MaterialDialogSheet);
                mBottomSheetDialog.setContentView(view);
                mBottomSheetDialog.setCancelable(true);
                mBottomSheetDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                mBottomSheetDialog.getWindow().setGravity(Gravity.CENTER);
                mBottomSheetDialog.show();
                termonewayApi();
            }
        });
  continue_booking.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(!oneway_checkbox.isChecked())
        {
            Toast.makeText(OnewayFareruleaActivity.this,"Please accept Terms and Conditions",Toast.LENGTH_LONG).show();
        }
        else
        {
            Intent inn=new Intent(OnewayFareruleaActivity.this,PassengerDetails.class);
            inn.putExtra("airlineCode",airlineCode);
            inn.putExtra("origin",origin);
            inn.putExtra("destination",destination);
            inn.putExtra("enduserip",endip);
            inn.putExtra("tokenid",token);
            inn.putExtra("resultindex",resultind);
            inn.putExtra("traceid",traceidone);
            inn.putExtra("adultone",adultone);
            inn.putExtra("childone",childone);
            inn.putExtra("infantsone",infantsone);
            inn.putExtra("airlineName",airlineName);
            inn.putExtra("flightCode",flightCode);
            inn.putExtra("arrivalTime",flightArrivalTime);
            inn.putExtra("flightDepartureTime",flightDepartureTime);
            inn.putExtra("flightName",airlineName);
            inn.putExtra("totalFare",publish_oneway.getText().toString());//"totalFare",publish_oneway
            inn.putExtra("countryTo",countryTo);
            inn.putExtra("countryFrom",countryFrom);
            startActivity(inn);

        }
          }
          });
     }

    private void termonewayApi() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading please wait ...");
        progressDialog.show();
        try {
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            JSONObject objfareF = new JSONObject();
            objfareF.put("EndUserIp", endip);
            objfareF.put("TokenId", token);
            objfareF.put("TraceId", traceidone);
            objfareF.put("ResultIndex", resultind);
            final String results = objfareF.toString();
            Log.wtf("relusty",results);
            JsonObjectRequest jsonFareobj = new JsonObjectRequest(Request.Method.POST, RULE_URL,objfareF, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    progressDialog.dismiss();
                    Log.wtf("volley response",response.toString());
                    try {
                        JSONObject firstobjsservo = response.getJSONObject("Response");
                        String responsstatus = firstobjsservo.getString("ResponseStatus");

                        if (!responsstatus.equals("1")) {
                            new AlertDialog.Builder(OnewayFareruleaActivity.this)
                                    .setMessage("Your session is expired please press ok")
                                    //.setPositiveButton("Yes",null)
                                    .setNeutralButton("                               OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent intent = new Intent(OnewayFareruleaActivity.this, FlightbookingActivity.class);
                                            startActivity(intent);
                                        }
                                    })
                                    .show();
                        }
                        JSONArray fareruleservo = firstobjsservo.getJSONArray("FareRules");
                        for (int r = 0; r < fareruleservo.length(); r++) {
                            JSONObject serobjo = fareruleservo.getJSONObject(r);
                            Oneway_Farerulesmodel oneway_farerules = new Oneway_Farerulesmodel();
                            oneway_farerules.setSairline_oneway(serobjo.getString("Airline"));
                            oneway_farerules.setSorigin_oneway(serobjo.getString("Origin"));
                            oneway_farerules.setSdestination_oneway(serobjo.getString("Destination"));
                            oneway_farerules.setSdetails_oneway(serobjo.getString("FareRuleDetail"));
                            onewayruleslist.add(oneway_farerules);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    dialogadaptr = new OnewaytermsAdaptr(OnewayFareruleaActivity.this, onewayruleslist);
                    oneway_listview.setAdapter(dialogadaptr);
                    dialogadaptr.notifyDataSetChanged();
                }
            },new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("LOG_VOLLEY", error.toString());
                    progressDialog.dismiss();
                }
            }){
                    @Override
                    public String getBodyContentType() {
                        return "application/json; charset=utf-8";
                    }
                };
            int socketTimeout = 50000; // 30 seconds. You can change it
            RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            jsonFareobj.setRetryPolicy(policy);
            requestQueue.add(jsonFareobj);
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void makevolleyoneway()
    {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading please wait ...");
        progressDialog.show();
        try {
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            JSONObject objfare = new JSONObject();
            objfare.put("EndUserIp",endip);
            objfare.put("TokenId",token);
            objfare.put("TraceId",traceidone);
            objfare.put("ResultIndex",resultind);
            final String results=objfare.toString();
            Log.wtf("relusty",results);
            JsonObjectRequest jsonFareobj = new JsonObjectRequest(Request.Method.POST, FARE_URL,objfare, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    progressDialog.dismiss();
                    Log.wtf("volley response",response.toString());
                    try {
                        JSONObject firstobjs = response.getJSONObject("Response");
                        String responsstatus = firstobjs.getString("ResponseStatus");
                        Log.wtf("resstatus", responsstatus);
                        //Here check the response status if it is not one.
                        //Then that means session has expired
                        //restart OnewayFareruleaActivity through intent
                        if (!responsstatus.equals("1")) {
                            new AlertDialog.Builder(OnewayFareruleaActivity.this)
                                    .setMessage("Your session is expired please press ok")
                                    .setNeutralButton("                               OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent intent = new Intent(OnewayFareruleaActivity.this, FlightbookingActivity.class);
                                            startActivity(intent);
                                        }
                                    })
                                    .show();
                        }

                        JSONObject resultobject = firstobjs.getJSONObject("Results");
                        JSONObject Faresr = resultobject.getJSONObject("Fare");
                        //basefare
                        Double base = Double.valueOf(Faresr.getString("BaseFare"));
                         base_o_oneway = base.intValue();
                         Log.wtf("valuea", String.valueOf(base_o_oneway));
                        int bs = base_o_oneway;
                         basefare_oneway.setText(String.valueOf(bs));

                         //taxes
                       Double tex = Double.valueOf(Faresr.getString("Tax"));
                         tex_o_oneway = tex.intValue();
                         Log.wtf("valuev", String.valueOf(tex_o_oneway));
                         int tx = tex_o_oneway;
                        texas_oneway.setText(String.valueOf(tx));

                        //othercharne
                        Double otherch = Double.valueOf(Faresr.getString("OtherCharges"));
                        otherc_oneway= otherch.intValue();
                        int othr = otherc_oneway ;
                        Log.wtf("values", String.valueOf(otherc_oneway));
                        other_oneway.setText(String.valueOf(othr));

                        //total fare
                        Double total = Double.valueOf(Faresr.getString("PublishedFare"));
                        total_o_oneway= total.intValue();
                        int pub = total_o_oneway +1;
                         Log.wtf("values", String.valueOf(total_o_oneway));
                        publish_oneway.setText(String.valueOf(pub));


                        JSONArray sagmentarr = resultobject.getJSONArray("Segments");
                        JSONArray sagmentinnner = sagmentarr.getJSONArray(0);
                        for (int i = 0; i < sagmentinnner.length(); i++) {
                             OnewayFare_model onewaydata = new OnewayFare_model();
                            JSONObject jobjet = sagmentinnner.getJSONObject(i);
                            onewaydata.setCheckin_origin_oneway(jobjet.getString("Baggage"));
                            onewaydata.setCabin_origin_oneway(jobjet.getString("CabinBaggage"));
                            onewaydata.setOrigin_dura_oneway(jobjet.getString("Duration") + "m");

                            JSONObject airline = jobjet.getJSONObject("Airline");
                            onewaydata.setOfcode1_oneway(airline.getString("AirlineCode"));
                            onewaydata.setO_fname1_oneway(airline.getString("AirlineName"));
                            onewaydata.setOfnumber1_oneway(airline.getString("FlightNumber"));

                            JSONObject origin = jobjet.getJSONObject("Origin");
                            onewaydata.setOtime1_oneway(origin.getString("DepTime"));
                            String splitdest = origin.getString("DepTime");
                            String[] textslitdest = splitdest.split("T");
                            String newsplitdest1 = textslitdest[0];
                            String newsplitdest2 = textslitdest[1];
                            String textdepar = newsplitdest2;
                            String sub_textdepa = textdepar.substring(0, newsplitdest2.length() - 3);
                            //this is wrong because i made mistake in xml
                            onewaydata.setOtime1_oneway(sub_textdepa);
                            JSONObject oriairport = origin.getJSONObject("Airport");
                            onewaydata.setOcity1_oneway(oriairport.getString("CityName"));
                            onewaydata.setOcode1_oneway(oriairport.getString("AirportCode"));
                            onewaydata.setOterm_oneway(oriairport.getString("Terminal"));

                            JSONObject destination = jobjet.getJSONObject("Destination");
                            onewaydata.setAtime1_oneway(destination.getString("ArrTime"));
                            String splitarive = destination.getString("ArrTime");
                            String[] textslitarivtim = splitarive.split("T");
                            String newsplitarriv = textslitarivtim[0];
                            String newsplitarriv2 = textslitarivtim[1];
                            //substring value
                            String textsub = newsplitarriv2;
                            String sub_text = textsub.substring(0, newsplitarriv2.length() - 3);

                            //this is wrong because i made mistake in xml
                            onewaydata.setAtime1_oneway(sub_text);
                            JSONObject desairport = destination.getJSONObject("Airport");
                            onewaydata.setAcity1_oneway(desairport.getString("CityName"));
                            onewaydata.setAcode1_oneway(desairport.getString("AirportCode"));
                            onewaydata.setAterm_oneway(desairport.getString("Terminal"));
                            onewaylist.add(onewaydata);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                onewayAdaptr = new Fareoneway_adaptr(OnewayFareruleaActivity.this, onewaylist);
                recyclerview_oneway.setAdapter(onewayAdaptr);
                    onewayAdaptr.notifyDataSetChanged();
                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("LOG_VOLLEY", error.toString());
                    progressDialog.dismiss();
                }
            }){
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }
            };
            int socketTimeout = 50000; // 30 seconds. You can change it
            RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            jsonFareobj.setRetryPolicy(policy);
            requestQueue.add(jsonFareobj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}//OnewayFareruleaActivity class
