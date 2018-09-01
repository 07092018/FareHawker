package com.farehawker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class Reviewdetails extends AppCompatActivity {

    ImageView airlineImage;
    TextView flightNameT, flightNameRT, arrivalTimeT, arrivalTimeRT, departureT, departureRT, flightCodeT, flightCodeRT, destinationT, destinationRT, originT, originRT;
    String TAG = "Reviewdetails";
    LinearLayout adult1, adult2, adult3, adult4, adult5, adult6, adult7, adult8, adult9;
    LinearLayout child1, child2, child3, child4, child5, child6, child7, child8;
    LinearLayout infant1, infant2, infant3, infant4, infant5, infant6, infant7, infant8, infant9;

    TextView adultOneFirstName, adultTwoFirstName, adultThirdFirstName, adultFourthFirstName, adultFifthFirstName, adultSixthFirstName, adultSeventhFirstName, adultEighthFirstName, adultNinethFirstName;
    TextView adultOneLastName, adultTwoLastName, adultThirdLastName, adultFourthLastName, adultFifthLastName, adultSixthLastName, adultSeventhLastName, adultEighthLastName, adultNinethLastName;
    TextView childOneFirstName, childTwoFirstName, childThirdFirstName, childFourthFirstName, childFifthFirstName, childSixthFirstName, childSeventhFirstName, childEighthFirstName;
    TextView childOneLastName, childSecondLastName, childThirdLastName, childFourthLastName, childFifthLastName, childSixthLastName, childSeventhLastName, childEighthLastName;

    TextView aPassportNo1, aPassportNo2, aPassportNo3, aPassportNo4, aPassportNo5, aPassportNo6, aPassportNo7,
            aPassportNo8, aPassportNo9, cPassportNo8, cPassportNo1, cPassportNo2, cPassportNo3, cPassportNo4,
            cPassportNo5, cPassportNo6, cPassportNo7, iPassportNo1, iPassportNo2, iPassportNo3, iPassportNo4,
            iPassportNo5, iPassportNo6, iPassportNo7, iPassportNo8, iPassportNo9, aPassportExp1, aPassportExp2,
            aPassportExp3, aPassportExp4, aPassportExp5, aPassportExp6, aPassportExp7, aPassportExp8, aPassportExp9,
            iPassportExp1, iPassportExp2, iPassportExp3, iPassportExp4, iPassportExp5, iPassportExp6, iPassportExp7,
            iPassportExp8, iPassportExp9, cPassportExp1, cPassportExp2, cPassportExp3, cPassportExp4, cPassportExp5,
            cPassportExp6, cPassportExp7, cPassportExp8;
    TextView infantOneFirstName, infantTwoFirstName, infantThirdFirstName, infantFourthFirstName, infantFifthFirstName, infantSixthFirstName, infantSeventhFirstName, infantEighthFirstName, infantNinethFirstName;
    TextView infantOneLastName, infantTwoLastName, infantThirdLastName, infantFourthLastName, infantFifthLastName, infantSixthLastName, infantSeventhLastName, infantEighthLastName, infantNinethLastName;

    Intent intent;
    TextView adultreview;

    String adultCount;
    String childCount;
    String infantCount;
    String flightPrice, flightDepartureTime, flightArrivalTime, flightCode, flightName, flightNumber, flightPriceR, flightArrivalTimeR, flightCodeR, flightNameR, flightNumberR, originR, destinationR, flightDepartureTimeR,origin,destination,airlineCode;
    RelativeLayout flightDetailsR;
    String id;
    Button makePayment;
    RelativeLayout flightDetailsR_RelativeLayout;
    LinearLayout flightRLinearLayout;
    TextView destination1;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviewdetails);
        //Adult Passport numbers and their Passport Expiry dates
//        aPassportNo1 = findViewById(R.id.aPassportNo1);
//        aPassportNo2 = findViewById(R.id.aPassportNo2);
//        aPassportNo3 = findViewById(R.id.aPassportNo3);
//        aPassportNo4 = findViewById(R.id.aPassportNo4);
//        aPassportNo5 = findViewById(R.id.aPassportNo5);
//        aPassportNo6 = findViewById(R.id.aPassportNo6);
//        aPassportNo7 = findViewById(R.id.aPassportNo7);
//        aPassportNo8 = findViewById(R.id.aPassportNo8);
//        aPassportNo9 = findViewById(R.id.aPassportNo9);
//
//        aPassportExp1 = findViewById(R.id.aPassportEx1);
//        aPassportExp2 = findViewById(R.id.aPassportEx2);
//        aPassportExp3 = findViewById(R.id.aPassportEx3);
//        aPassportExp4 = findViewById(R.id.aPassportEx4);
//        aPassportExp5 = findViewById(R.id.aPassportEx5);
//        aPassportExp6 = findViewById(R.id.aPassportEx6);
//        aPassportExp7 = findViewById(R.id.aPassportEx7);
//        aPassportExp8 = findViewById(R.id.aPassportEx8);
//        aPassportExp9 = findViewById(R.id.aPassportEx9);
//
//        //Children Passport numbers and their Passport Expiry dates
//        cPassportNo1 = findViewById(R.id.cPassportNo1);
//        cPassportNo2 = findViewById(R.id.cPassportNo2);
//        cPassportNo3 = findViewById(R.id.cPassportNo3);
//        cPassportNo4 = findViewById(R.id.cPassportNo4);
//        cPassportNo5 = findViewById(R.id.cPassportNo5);
//        cPassportNo6 = findViewById(R.id.cPassportNo6);
//        cPassportNo7 = findViewById(R.id.cPassportNo7);
//        cPassportNo8 = findViewById(R.id.cPassportNo8);
//
//        cPassportExp1 = findViewById(R.id.cPassportExp1);
//        cPassportExp2 = findViewById(R.id.cPassportExp2);
//        cPassportExp3 = findViewById(R.id.cPassportExp3);
//        cPassportExp4 = findViewById(R.id.cPassportExp4);
//        cPassportExp5 = findViewById(R.id.cPassportExp5);
//        cPassportExp6 = findViewById(R.id.cPassportExp6);
//        cPassportExp7 = findViewById(R.id.cPassportExp7);
//        cPassportExp8 = findViewById(R.id.cPassportExp8);
//
//        //Infants passports and date of expiry details
//        iPassportNo1 = findViewById(R.id.iPassportNo1);
//        iPassportNo2 = findViewById(R.id.iPassportNo2);
//        iPassportNo3 = findViewById(R.id.iPassportNo3);
//        iPassportNo4 = findViewById(R.id.iPassportNo4);
//        iPassportNo5 = findViewById(R.id.iPassportNo5);
//        iPassportNo6 = findViewById(R.id.iPassportNo6);
//        iPassportNo7 = findViewById(R.id.iPassportNo7);
//        iPassportNo8 = findViewById(R.id.iPassportNo8);
//        iPassportNo9 = findViewById(R.id.iPassportNo9);
//
//        iPassportExp1 = findViewById(R.id.iPassportExp1);
//        iPassportExp2 = findViewById(R.id.iPassportExp2);
//        iPassportExp3 = findViewById(R.id.iPassportExp3);
//        iPassportExp4 = findViewById(R.id.iPassportExp4);
//        iPassportExp5 = findViewById(R.id.iPassportExp5);
//        iPassportExp6 = findViewById(R.id.iPassportExp6);
//        iPassportExp7 = findViewById(R.id.iPassportExp7);
//        iPassportExp8 = findViewById(R.id.iPassportExp8);
//        iPassportExp9 = findViewById(R.id.iPassportExp9);
        airlineImage=findViewById(R.id.airlineImage);
        intent = getIntent();
        //Get Passport details from intent
        intent.getStringExtra("aPassportNo1");
        intent.getStringExtra("aPassportExp1");
        intent.getStringExtra("aPassportNo2");
        intent.getStringExtra("aPassportExp2");
        intent.getStringExtra("aPassportNo3");
        intent.getStringExtra("aPassportExp3");
        intent.getStringExtra("aPassportNo4");
        intent.getStringExtra("aPassportExp4");
        intent.getStringExtra("aPassportNo5");
        intent.getStringExtra("aPassportExp5");
        intent.getStringExtra("aPassportNo6");
        intent.getStringExtra("aPassportExp6");
        intent.getStringExtra("aPassportNo7");
        intent.getStringExtra("aPassportExp7");
        intent.getStringExtra("aPassportNo8");
        intent.getStringExtra("aPassportExp8");
        intent.getStringExtra("aPassportNo9");
        intent.getStringExtra("aPassportExp9");
        //Get children Passport details from intent
        intent.getStringExtra("cPassportNo1");
        intent.getStringExtra("cPassportExp1");
        intent.getStringExtra("cPassportNo2");
        intent.getStringExtra("cPassportExp2");
        intent.getStringExtra("cPassportNo3");
        intent.getStringExtra("cPassportExp3");
        intent.getStringExtra("cPassportNo4");
        intent.getStringExtra("cPassportExp4");
        intent.getStringExtra("cPassportNo5");
        intent.getStringExtra("cPassportExp5");
        intent.getStringExtra("cPassportNo6");
        intent.getStringExtra("cPassportExp6");
        intent.getStringExtra("cPassportNo7");
        intent.getStringExtra("cPassportExp7");
        intent.getStringExtra("cPassportNo8");
        intent.getStringExtra("cPassportExp8");

        //Get Infants Passport details from intent
        intent.getStringExtra("iPassportNo1");
        intent.getStringExtra("iPassportExp1");
        intent.getStringExtra("iPassportNo2");
        intent.getStringExtra("iPassportExp2");
        intent.getStringExtra("iPassportNo3");
        intent.getStringExtra("iPassportExp3");
        intent.getStringExtra("iPassportNo4");
        intent.getStringExtra("iPassportExp4");
        intent.getStringExtra("iPassportNo5");
        intent.getStringExtra("iPassportExp5");
        intent.getStringExtra("iPassportNo6");
        intent.getStringExtra("iPassportExp6");
        intent.getStringExtra("iPassportNo7");
        intent.getStringExtra("iPassportExp7");
        intent.getStringExtra("iPassportNo8");
        intent.getStringExtra("iPassportExp8");
        intent.getStringExtra("iPassportNo9");
        intent.getStringExtra("iPassportExp9");
        origin = intent.getStringExtra("origin");
        destination = intent.getStringExtra("destination");

        adultCount = intent.getStringExtra("adultCount");
        childCount = intent.getStringExtra("childCount");
        infantCount = intent.getStringExtra("infantCount");
        Picasso.with(Reviewdetails.this).load("https://www.farehawker.com/img/Airlines_logo/"+airlineCode+".gif").into(airlineImage);
        //Flights Details
        flightPrice = intent.getStringExtra("flightPrice");
        flightDepartureTime = intent.getStringExtra("flightDepartureTime");
        flightArrivalTime = intent.getStringExtra("flightArrivalTime");

        airlineCode = intent.getStringExtra("airlineCode");
        flightNumber=intent.getStringExtra("flightNumber");
        flightName = intent.getStringExtra("flightName");
        //flightNumber = intent.getStringExtra("flightNumber");

        id=intent.getStringExtra("Id");
        //Return Flight Details
        if(id.equals("roundTrip"))
        {
            flightPriceR = intent.getStringExtra("flightPriceR");
            flightDepartureTimeR = intent.getStringExtra("flightDepartureTimeR");
            flightArrivalTimeR = intent.getStringExtra("flightArrivalTimeR");
            flightCodeR = intent.getStringExtra("flightCodeR");
            flightNameR = intent.getStringExtra("flightNameR");
            flightNumberR = intent.getStringExtra("flightNumberR");

            originR = intent.getStringExtra("origin");
            destinationR = intent.getStringExtra("destination");

        }


        Toast.makeText(Reviewdetails.this, "Number of adults" + adultCount, Toast.LENGTH_LONG).show();

        String adf = intent.getStringExtra("adF");
        //String  adl = intent.getStringExtra("adL");
        //adultreview=(TextView)findViewById(R.id.adultreview);
        //adultreview.setText(String.valueOf(adf)+String.valueOf(adl));
        adult1 = findViewById(R.id.adult1);
        adult2 = findViewById(R.id.adult2);
        adult3 = findViewById(R.id.adult3);
        adult4 = findViewById(R.id.adult4);
        adult5 = findViewById(R.id.adult5);
        adult6 = findViewById(R.id.adult6);
        adult7 = findViewById(R.id.adult7);
        adult8 = findViewById(R.id.adult8);
        adult9 = findViewById(R.id.adult9);

        child1 = findViewById(R.id.child1);
        child2 = findViewById(R.id.child2);
        child3 = findViewById(R.id.child3);
        child4 = findViewById(R.id.child4);
        child5 = findViewById(R.id.child5);
        child6 = findViewById(R.id.child6);
        child7 = findViewById(R.id.child7);
        child8 = findViewById(R.id.child8);

        infant1 = findViewById(R.id.infant1);
        infant2 = findViewById(R.id.infant2);
        infant3 = findViewById(R.id.infant3);
        infant4 = findViewById(R.id.infant4);
        infant5 = findViewById(R.id.infant5);
        infant6 = findViewById(R.id.infant6);
        infant7 = findViewById(R.id.infant7);
        infant8 = findViewById(R.id.infant8);
        infant9 = findViewById(R.id.infant9);

        airlineImage=findViewById(R.id.airlineImage);
        flightDetailsR_RelativeLayout=findViewById(R.id.flightDetailsR_RelativeLayout);
        adultOneFirstName = findViewById(R.id.adultName1);
        adultTwoFirstName = findViewById(R.id.adultName2);
        adultThirdFirstName = findViewById(R.id.adultName3);
        adultFourthFirstName = findViewById(R.id.adultName4);
        adultFifthFirstName = findViewById(R.id.adultName5);
        adultSixthFirstName = findViewById(R.id.adultName6);
        adultSeventhFirstName = findViewById(R.id.adultName7);
        adultEighthFirstName = findViewById(R.id.adultName8);
        adultNinethFirstName = findViewById(R.id.adultName9);

        adultOneLastName = findViewById(R.id.adultLastname1);
        adultTwoLastName = findViewById(R.id.adultLastname2);
        adultThirdLastName = findViewById(R.id.adultLastname3);
        adultFourthLastName = findViewById(R.id.adultLastname4);
        adultFifthLastName = findViewById(R.id.adultLastname5);
        adultSixthLastName = findViewById(R.id.adultLastname6);
        adultSeventhLastName = findViewById(R.id.adultLastname7);
        adultEighthLastName = findViewById(R.id.adultLastname8);
        adultNinethLastName = findViewById(R.id.adultLastname9);

        childOneFirstName = findViewById(R.id.child1_firstname);
        childTwoFirstName = findViewById(R.id.child2_firstname);
        childThirdFirstName = findViewById(R.id.child3_firstname);
        childFourthFirstName = findViewById(R.id.child4_firstname);
        childFifthFirstName = findViewById(R.id.child5_firstname);
        childSixthFirstName = findViewById(R.id.child6_firstname);
        childSeventhFirstName = findViewById(R.id.child7_firstname);
        childEighthFirstName = findViewById(R.id.child8_firstname);

        childOneLastName = findViewById(R.id.child1_lastname);
        childTwoFirstName = findViewById(R.id.child2_lastname);
        childThirdFirstName = findViewById(R.id.child3_lastname);
        childFourthFirstName = findViewById(R.id.child4_lastname);
        childFifthFirstName = findViewById(R.id.child5_lastname);
        childSixthFirstName = findViewById(R.id.child6_lastname);
        childSeventhFirstName = findViewById(R.id.child7_lastname);
        childEighthFirstName = findViewById(R.id.child8_lastname);

        infantOneFirstName = findViewById(R.id.infants1_firstname);
        infantTwoFirstName = findViewById(R.id.infants2_firstname);
        infantThirdFirstName = findViewById(R.id.infants3_firstname);
        infantFourthFirstName = findViewById(R.id.infants4_firstname);
        infantFifthFirstName = findViewById(R.id.infants5_firstname);
        infantSixthFirstName = findViewById(R.id.infants6_firstname);
        infantSeventhFirstName = findViewById(R.id.infants7_firstname);
        infantEighthFirstName = findViewById(R.id.infants8_firstname);
        infantNinethFirstName = findViewById(R.id.infants9_firstname);
        flightCodeT = findViewById(R.id.flightCode);
        flightCodeRT = findViewById(R.id.flightCode2);

        flightNameT = findViewById(R.id.flightName);

        arrivalTimeT = findViewById(R.id.arrivalTime);

        departureT = findViewById(R.id.departureTime);

       // flightCodeT = findViewById(R.id.flightCode2);

        destination1 = findViewById(R.id.destination1);

        flightNameRT = findViewById(R.id.flightName2);
        arrivalTimeRT = findViewById(R.id.arrivalTime2);
        departureRT = findViewById(R.id.departureTimeR);
        flightCodeRT = findViewById(R.id.flightCode2);
        destinationRT = findViewById(R.id.destination2);
        originRT = findViewById(R.id.origin2);
        flightNameRT.setText(flightNameR);
        originT = findViewById(R.id.origin1);
        destinationT =findViewById(R.id.destination);
        flightDetailsR = findViewById(R.id.flightDetailsR_RelativeLayout);
        flightRLinearLayout=findViewById(R.id.flightRLinearLayout);
        makePayment=findViewById(R.id.makeButton);

        makePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
              Intent intent = new Intent(Reviewdetails.this,SomeEarlierMerchantActivity.class);
              intent.putExtra("totalFare",flightPrice);
              startActivity(intent);
            }
        });
        flightNameT.setText(flightName);
        arrivalTimeT.setText(flightArrivalTime);
        departureT.setText(flightDepartureTime);
        destinationT.setText(destination);
        destination1.setText(destination);
        originT.setText(origin);
        Picasso.with(Reviewdetails.this).load("https://www.farehawker.com/img/Airlines_logo/"+airlineCode+".gif").into(airlineImage);
        flightCodeT.setText(airlineCode+"-"+flightNumber);
        flightDetailsR_RelativeLayout.setVisibility(View.GONE);
        flightRLinearLayout.setVisibility(View.GONE);
        if(id.equals("roundTrip"))
        {
            flightDetailsR_RelativeLayout.setVisibility(View.VISIBLE);
            flightRLinearLayout.setVisibility(View.VISIBLE);
            arrivalTimeRT.setText(flightArrivalTimeR);
            departureRT.setText(flightDepartureTimeR);
            flightCodeRT.setText(flightCodeR);
            originRT.setText(destinationR);
            destinationRT.setText(originR);
            flightDetailsR.setVisibility(View.VISIBLE);
        }



//        infantOneLastName=findViewById(R.id.infants1_lastname);
//        infantTwoLastName=findViewById(R.id.infants2_lastname);
//        infantThirdLastName=findViewById(R.id.infants3_lastname);
//        infantFourthLastName=findViewById(R.id.infants4_lastname);
//        infantFifthLastName=findViewById(R.id.infants5_lastname);
//        infantSixthLastName=findViewById(R.id.infants6_lastname);
//        infantSeventhLastName=findViewById(R.id.infants7_lastname);
//        infantEighthLastName=findViewById(R.id.infants8_lastname);
//        infantNinethLastName =findViewById(R.id.infants9_lastname);

        makeVisible();
    }//End of onCreate method

    public void makeVisible() {
        if (Integer.parseInt(adultCount) == 1) {
            adultOneFirstName.setText(intent.getStringExtra("adultOneFirstName"));
            adultOneLastName.setText(intent.getStringExtra("adultOneLastName"));

            adult2.setVisibility(View.GONE);
            adult3.setVisibility(View.GONE);
            adult4.setVisibility(View.GONE);
            adult5.setVisibility(View.GONE);
            adult6.setVisibility(View.GONE);
            adult7.setVisibility(View.GONE);
            adult8.setVisibility(View.GONE);
            adult9.setVisibility(View.GONE);

        } else if (Integer.parseInt(adultCount) == 2) {
            adultOneFirstName.setText(intent.getStringExtra("adultOneFirstName"));
            adultOneLastName.setText(intent.getStringExtra("adultOneLastName"));

            adultTwoFirstName.setText(intent.getStringExtra("adultSecondFirstName"));
            adultTwoLastName.setText(intent.getStringExtra("adultSecondLastName"));


            adult3.setVisibility(View.GONE);
            adult4.setVisibility(View.GONE);
            adult5.setVisibility(View.GONE);
            adult6.setVisibility(View.GONE);
            adult7.setVisibility(View.GONE);
            adult8.setVisibility(View.GONE);
            adult9.setVisibility(View.GONE);
        } else if (Integer.parseInt(adultCount) == 3) {
            adultOneFirstName.setText(intent.getStringExtra("adultOneFirstName"));
            adultOneLastName.setText(intent.getStringExtra("adultOneLastName"));

            adultTwoFirstName.setText(intent.getStringExtra("adultTwoFirstName"));
            adultTwoLastName.setText(intent.getStringExtra("adultTwoLastName"));

            adultThirdFirstName.setText(intent.getStringExtra("adultThirdFirstName"));
            adultThirdFirstName.setText(intent.getStringExtra("adultThirdLastName"));


            adult4.setVisibility(View.GONE);
            adult5.setVisibility(View.GONE);
            adult6.setVisibility(View.GONE);
            adult7.setVisibility(View.GONE);
            adult8.setVisibility(View.GONE);
            adult9.setVisibility(View.GONE);
        } else if (Integer.parseInt(adultCount) == 4) {
            adultOneFirstName.setText(intent.getStringExtra("adultOneFirstName"));
            adultOneLastName.setText(intent.getStringExtra("adultOneLastName"));

            adultTwoFirstName.setText(intent.getStringExtra("adultTwoFirstName"));
            adultTwoLastName.setText(intent.getStringExtra("adultTwoLastName"));

            adultThirdFirstName.setText(intent.getStringExtra("adultThirdFirstName"));
            adultThirdLastName.setText(intent.getStringExtra("adultThirdLastName"));

            adultFourthFirstName.setText(intent.getStringExtra("adultFourthFirstName"));
            adultFourthLastName.setText(intent.getStringExtra("adultFourthLastName"));


            adult5.setVisibility(View.GONE);
            adult6.setVisibility(View.GONE);
            adult7.setVisibility(View.GONE);
            adult8.setVisibility(View.GONE);
            adult9.setVisibility(View.GONE);
        } else if (Integer.parseInt(adultCount) == 5) {
            adultOneFirstName.setText(intent.getStringExtra("adultOneFirstName"));
            adultOneLastName.setText(intent.getStringExtra("adultOneLastName"));

            adultTwoFirstName.setText(intent.getStringExtra("adultTwoFirstName"));
            adultTwoLastName.setText(intent.getStringExtra("adultTwoLastName"));

            adultThirdFirstName.setText(intent.getStringExtra("adultThirdFirstName"));
            adultThirdLastName.setText(intent.getStringExtra("adultThirdLastName"));

            adultFourthFirstName.setText(intent.getStringExtra("adultFourthFirstName"));
            adultFourthLastName.setText(intent.getStringExtra("adultFourthLastName"));

            adult6.setVisibility(View.GONE);
            adult7.setVisibility(View.GONE);
            adult8.setVisibility(View.GONE);
            adult9.setVisibility(View.GONE);
        } else if (Integer.parseInt(adultCount) == 6) {
            adultOneFirstName.setText(intent.getStringExtra("adultOneFirstName"));
            adultOneLastName.setText(intent.getStringExtra("adultOneLastName"));

            adultTwoFirstName.setText(intent.getStringExtra("adultTwoFirstName"));
            adultTwoLastName.setText(intent.getStringExtra("adultTwoLastName"));

            adultThirdFirstName.setText(intent.getStringExtra("adultThirdFirstName"));
            adultThirdLastName.setText(intent.getStringExtra("adultThirdLastName"));

            adultFourthFirstName.setText(intent.getStringExtra("adultFourthFirstName"));
            adultFourthLastName.setText(intent.getStringExtra("adultFourthLastName"));

            adultFifthFirstName.setText(intent.getStringExtra("adultFifthFirstName"));
            adultFifthLastName.setText(intent.getStringExtra("adultFifthLastName"));

            adultSixthFirstName.setText(intent.getStringExtra("adultSixthFirstName"));
            adultSixthLastName.setText(intent.getStringExtra("adultSixthLastName"));


            adult7.setVisibility(View.GONE);
            adult8.setVisibility(View.GONE);
            adult9.setVisibility(View.GONE);
        } else if (Integer.parseInt(adultCount) == 7) {
            adultOneFirstName.setText(intent.getStringExtra("adultOneFirstName"));
            adultOneLastName.setText(intent.getStringExtra("adultOneLastName"));

            adultTwoFirstName.setText(intent.getStringExtra("adultTwoFirstName"));
            adultTwoLastName.setText(intent.getStringExtra("adultTwoLastName"));

            adultThirdFirstName.setText(intent.getStringExtra("adultThirdFirstName"));
            adultThirdLastName.setText(intent.getStringExtra("adultThirdLastName"));

            adultFourthFirstName.setText(intent.getStringExtra("adultFourthFirstName"));
            adultFourthLastName.setText(intent.getStringExtra("adultFourthLastName"));

            adultFifthFirstName.setText(intent.getStringExtra("adultFifthFirstName"));
            adultFifthLastName.setText(intent.getStringExtra("adultFifthLastName"));

            adultSixthFirstName.setText(intent.getStringExtra("adultSixthFirstName"));
            adultSixthLastName.setText(intent.getStringExtra("adultSixthLastName"));

            adultSeventhFirstName.setText(intent.getStringExtra("adultSeventhFirstName"));
            adultSeventhLastName.setText(intent.getStringExtra("adultSeventhLastName"));

            adult8.setVisibility(View.GONE);
            adult9.setVisibility(View.GONE);
        } else if (Integer.parseInt(adultCount) == 8) {

            adultOneFirstName.setText(intent.getStringExtra("adultOneFirstName"));
            adultOneLastName.setText(intent.getStringExtra("adultOneLastName"));

            adultTwoFirstName.setText(intent.getStringExtra("adultTwoFirstName"));
            adultTwoLastName.setText(intent.getStringExtra("adultTwoLastName"));

            adultThirdFirstName.setText(intent.getStringExtra("adultThirdFirstName"));
            adultThirdLastName.setText(intent.getStringExtra("adultThirdLastName"));

            adultFourthFirstName.setText(intent.getStringExtra("adultFourthFirstName"));
            adultFourthLastName.setText(intent.getStringExtra("adultFourthLastName"));

            adultFifthFirstName.setText(intent.getStringExtra("adultFifthFirstName"));
            adultFifthLastName.setText(intent.getStringExtra("adultFifthLastName"));

            adultSixthFirstName.setText(intent.getStringExtra("adultSixthFirstName"));
            adultSixthLastName.setText(intent.getStringExtra("adultSixthLastName"));

            adultSeventhFirstName.setText(intent.getStringExtra("adultSeventhFirstName"));
            adultSeventhLastName.setText(intent.getStringExtra("adultSeventhLastName"));

            adultEighthFirstName.setText(intent.getStringExtra("adultEighthFirstName"));
            adultEighthLastName.setText(intent.getStringExtra("adultEighthLastName"));

            adult9.setVisibility(View.GONE);
        } else if (Integer.parseInt(adultCount) == 9) {
            adultOneFirstName.setText(intent.getStringExtra("adultOneFirstName"));
            adultOneLastName.setText(intent.getStringExtra("adultOneLastName"));

            adultTwoFirstName.setText(intent.getStringExtra("adultTwoFirstName"));
            adultTwoLastName.setText(intent.getStringExtra("adultTwoLastName"));

            adultThirdFirstName.setText(intent.getStringExtra("adultThirdFirstName"));
            adultThirdLastName.setText(intent.getStringExtra("adultThirdLastName"));

            adultFourthFirstName.setText(intent.getStringExtra("adultFourthFirstName"));
            adultFourthLastName.setText(intent.getStringExtra("adultFourthLastName"));

            adultFifthFirstName.setText(intent.getStringExtra("adultFifthFirstName"));
            adultFifthLastName.setText(intent.getStringExtra("adultFifthLastName"));

            adultSixthFirstName.setText(intent.getStringExtra("adultSixthFirstName"));
            adultSixthLastName.setText(intent.getStringExtra("adultSixthLastName"));

            adultSeventhFirstName.setText(intent.getStringExtra("adultSeventhFirstName"));
            adultSeventhLastName.setText(intent.getStringExtra("adultSeventhLastName"));

            adultEighthFirstName.setText(intent.getStringExtra("adultEighthFirstName"));
            adultEighthLastName.setText(intent.getStringExtra("adultEighthLastName"));

            adultNinethFirstName.setText(intent.getStringExtra("adultNinethFirstName"));
            adultNinethLastName.setText(intent.getStringExtra("adultNinethLastName"));

        }


        if (Integer.parseInt(infantCount) == 0) {
            infant1.setVisibility(View.GONE);
            infant2.setVisibility(View.GONE);
            infant3.setVisibility(View.GONE);
            infant4.setVisibility(View.GONE);
            infant5.setVisibility(View.GONE);
            infant6.setVisibility(View.GONE);
            infant7.setVisibility(View.GONE);
            infant8.setVisibility(View.GONE);
            infant9.setVisibility(View.GONE);
        } else if (Integer.parseInt(infantCount) == 1) {
            infant2.setVisibility(View.GONE);
            infant3.setVisibility(View.GONE);
            infant4.setVisibility(View.GONE);
            infant5.setVisibility(View.GONE);
            infant6.setVisibility(View.GONE);
            infant7.setVisibility(View.GONE);
            infant8.setVisibility(View.GONE);
            infant9.setVisibility(View.GONE);

        } else if (Integer.parseInt(infantCount) == 2) {
            infant3.setVisibility(View.GONE);
            infant4.setVisibility(View.GONE);
            infant5.setVisibility(View.GONE);
            infant6.setVisibility(View.GONE);
            infant7.setVisibility(View.GONE);
            infant8.setVisibility(View.GONE);
            infant9.setVisibility(View.GONE);

        } else if (Integer.parseInt(infantCount) == 3) {
            infant4.setVisibility(View.GONE);
            infant5.setVisibility(View.GONE);
            infant6.setVisibility(View.GONE);
            infant7.setVisibility(View.GONE);
            infant8.setVisibility(View.GONE);
            infant9.setVisibility(View.GONE);
        } else if (Integer.parseInt(infantCount) == 4) {
            infant2.setVisibility(View.GONE);
            infant3.setVisibility(View.GONE);
            infant4.setVisibility(View.GONE);
            infant5.setVisibility(View.GONE);
            infant6.setVisibility(View.GONE);
            infant7.setVisibility(View.GONE);
            infant8.setVisibility(View.GONE);
            infant9.setVisibility(View.GONE);
        } else if (Integer.parseInt(infantCount) == 5) {
            infant6.setVisibility(View.GONE);
            infant7.setVisibility(View.GONE);
            infant8.setVisibility(View.GONE);
            infant9.setVisibility(View.GONE);

        } else if (Integer.parseInt(infantCount) == 6) {
            infant7.setVisibility(View.GONE);
            infant8.setVisibility(View.GONE);
            infant9.setVisibility(View.GONE);

        } else if (Integer.parseInt(infantCount) == 7) {
            infant8.setVisibility(View.GONE);
            infant9.setVisibility(View.GONE);
        } else if (Integer.parseInt(infantCount) == 8) {
            infant9.setVisibility(View.GONE);
        }
        if (Integer.parseInt(childCount) == 0) {
            child1.setVisibility(View.GONE);
            child2.setVisibility(View.GONE);
            child3.setVisibility(View.GONE);
            child4.setVisibility(View.GONE);
            child5.setVisibility(View.GONE);
            child6.setVisibility(View.GONE);
            child7.setVisibility(View.GONE);
            child8.setVisibility(View.GONE);
        } else if (Integer.parseInt(childCount) == 1) {
            child2.setVisibility(View.GONE);
            child3.setVisibility(View.GONE);
            child4.setVisibility(View.GONE);
            child5.setVisibility(View.GONE);
            child6.setVisibility(View.GONE);
            child7.setVisibility(View.GONE);
            child8.setVisibility(View.GONE);
        } else if (Integer.parseInt(childCount) == 2) {
            child3.setVisibility(View.GONE);
            child4.setVisibility(View.GONE);
            child5.setVisibility(View.GONE);
            child6.setVisibility(View.GONE);
            child7.setVisibility(View.GONE);
            child8.setVisibility(View.GONE);
        } else if (Integer.parseInt(childCount) == 3) {
            child4.setVisibility(View.GONE);
            child5.setVisibility(View.GONE);
            child6.setVisibility(View.GONE);
            child7.setVisibility(View.GONE);
            child8.setVisibility(View.GONE);
        } else if (Integer.parseInt(childCount) == 4) {
            child5.setVisibility(View.GONE);
            child6.setVisibility(View.GONE);
            child7.setVisibility(View.GONE);
            child8.setVisibility(View.GONE);
        } else if (Integer.parseInt(childCount) == 5) {
            child5.setVisibility(View.GONE);
            child6.setVisibility(View.GONE);
            child7.setVisibility(View.GONE);
            child8.setVisibility(View.GONE);
        } else if (Integer.parseInt(childCount) == 6) {
            child7.setVisibility(View.GONE);
            child8.setVisibility(View.GONE);
        } else if (Integer.parseInt(childCount) == 7) {
            child8.setVisibility(View.GONE);
        }
    }//End of makeVisible method


}//End of class Reviewdetails
