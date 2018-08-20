package com.farehawker;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PassengerDetailsR extends AppCompatActivity
{
    EditText mobileNumber,emailId;
    TextView adultOneFirstName, adultSecondFirstName, adultThirdFirstName, adultFourthFirstName, adultFifthFirstName, adultSixthFirstName, adultSeventhFirstName, adultEigthFirstName, adultNinethFirstName,
            adultOneLastName, adultSecondLastName, adultThirdLastName, adultFourthLastName, adultFifthLastName, adultSixthLastName, adultSeventhLastName, adultEigthLastName, adultNinethLastName,
            childOneFirstName, childSecondFirstName,childThirdFirstName,childFourthFirstName,childFifthFirstName,childSixthFirstName,childSeventhFirstName,childEigthFirstName,
            childOneLastName,childSecondLastName,childThirdLastName,childFourthLastName,childFifthLastName,childSixthLastName,childSeventhLastName,childEigthLastName;
    TextView infantOneFirstName,infantSecondFirstName,infantThirdFirstName,infantFourthFirstName,infantFifthFirstName,infantSixthFirstName,infantSeventhFirstName,infantEigthFirstName,infantNinethFirstName;

    TextView infantOneLastName,infantSecondLastName,infantThirdLastName,infantFourthLastName,infantFifthLastName,infantSixthLastName,infantSeventhLastName,infantEigthLastName,infantNinethLastName;
    EditText infant_dob1,infant_dob2,infant_dob3,infant_dob4,infant_dob5,infant_dob6,infant_dob7,infant_dob8,infant_dob9;
    TextView maincount_adult;
    TextView maincount_child;
    TextView maincount_infant;

    TextView couponCode;
    TextView TotalFare;
    ActionBar actionBar;
    static int couponValidity=1;
    TextView infants,children;
    int status=0;
    Intent intent;
    String adultCount;
    String childCount;
    String infantCount;
    LinearLayout linear_adult1,linear_adult2,linear_adult3,linear_adult4,linear_adult5,linear_adult6,linear_adult7,linear_adult8,linear_adult9;
    LinearLayout linear_child1,linear_child2,linear_child3,linear_child4,linear_child5,linear_child6,linear_child7,linear_child8;
    LinearLayout linear_infant1,linear_infant2,linear_infant3,linear_infant4,linear_infant5,linear_infant6,linear_infant7,linear_infant8,linear_infant9;

    Spinner adultSpinner1;
    Spinner adultSpinner2;
    Spinner adultSpinner3;
    Spinner adultSpinner4;
    Spinner adultSpinner5;
    Spinner adultSpinner6;
    Spinner adultSpinner7;
    Spinner adultSpinner8;
    Spinner adultSpinner9;

    Spinner childSpinner1;
    Spinner childSpinner2;
    Spinner childSpinner3;
    Spinner childSpinner4;
    Spinner childSpinner5;
    Spinner childSpinner6;
    Spinner childSpinner7;
    Spinner childSpinner8;

    Spinner infantSpinner1;
    Spinner infantSpinner2;
    Spinner infantSpinner3;
    Spinner infantSpinner4;
    Spinner infantSpinner5;
    Spinner infantSpinner6;
    Spinner infantSpinner7;
    Spinner infantSpinner8;
    Spinner infantSpinner9;

    TextView child_count,infant_count;
    LinearLayout gstLinearLayout;
    Button reviewDetails;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_details);
        adultOneFirstName = (TextView) findViewById(R.id.adult_firstname);
        adultSecondFirstName = (TextView) findViewById(R.id.adult2_firstname);
        adultThirdFirstName = (TextView) findViewById(R.id.adult3_firstname);
        adultFourthFirstName = (TextView) findViewById(R.id.adult4_firstname);
        adultFifthFirstName = (TextView) findViewById(R.id.adult5_firstname);
        adultSixthFirstName = (TextView) findViewById(R.id.adult6_firstname);
        adultSeventhFirstName = (TextView) findViewById(R.id.adult7_firstname);
        adultEigthFirstName = (TextView) findViewById(R.id.adult8_firstname);
        adultNinethFirstName = (TextView) findViewById(R.id.adult9_firstname);

        adultOneLastName = (TextView) findViewById(R.id.adult_lastname);
        adultSecondLastName = (TextView) findViewById(R.id.adult2_lastname);
        adultThirdLastName = (TextView) findViewById(R.id.adult3_lastname);
        adultFourthLastName = (TextView) findViewById(R.id.adult4_lastname);
        adultFifthLastName = (TextView) findViewById(R.id.adult5_lastname);
        adultSixthLastName = (TextView) findViewById(R.id.adult6_lastname);
        adultSeventhLastName = (TextView) findViewById(R.id.adult7_lastname);
        adultEigthLastName = (TextView) findViewById(R.id.adult8_lastname);
        adultNinethLastName = (TextView) findViewById(R.id.adult9_lastname);

        childOneFirstName = (TextView) findViewById(R.id.child1_firstname);
        childSecondFirstName = (TextView) findViewById(R.id.child2_firstname);
        childThirdFirstName = (TextView) findViewById(R.id.child3_firstname);
        childFourthFirstName = (TextView) findViewById(R.id.child4_firstname);
        childFifthFirstName = (TextView) findViewById(R.id.child5_firstname);
        childSixthFirstName = (TextView) findViewById(R.id.child6_firstname);
        childSeventhFirstName = (TextView) findViewById(R.id.child7_firstname);
        childEigthFirstName = (TextView) findViewById(R.id.child8_firstname);

        childOneLastName = (TextView) findViewById(R.id.child1_lastname);
        childSecondLastName = (TextView) findViewById(R.id.child2_lastname);
        childThirdLastName = (TextView) findViewById(R.id.child3_lastname);
        childFourthLastName = (TextView) findViewById(R.id.child4_lastname);
        childFifthLastName = (TextView) findViewById(R.id.child5_lastname);
        childSixthLastName = (TextView) findViewById(R.id.child6_lastname);
        childSeventhLastName = (TextView) findViewById(R.id.child7_lastname);
        childEigthLastName = (TextView) findViewById(R.id.child8_lastname);

        infantOneFirstName=(TextView)findViewById(R.id.infants1_firstname);
        infantSecondFirstName=(TextView)findViewById(R.id.infants2_firstname);
        infantThirdFirstName=(TextView)findViewById(R.id.infants3_firstname);
        infantFourthFirstName=(TextView)findViewById(R.id.infants4_firstname);
        infantFifthFirstName=(TextView)findViewById(R.id.infants5_firstname);
        infantSixthFirstName=(TextView)findViewById(R.id.infants6_firstname);
        infantSeventhFirstName=(TextView)findViewById(R.id.infants7_firstname);
        infantEigthFirstName=(TextView)findViewById(R.id.infants8_firstname);
        infantNinethFirstName=(TextView)findViewById(R.id.infants9_firstname);

//        infantOneLastName=(TextView)findViewById(R.id.infants1_lastname);
//        infantSecondLastName=(TextView)findViewById(R.id.infants2_lastname);
//        infantThirdLastName=(TextView)findViewById(R.id.infants3_lastname);
//        infantFourthLastName=(TextView)findViewById(R.id.infants4_lastname);
//        infantFifthLastName=(TextView)findViewById(R.id.infants5_lastname);
//        infantSixthLastName=(TextView)findViewById(R.id.infants6_lastname);
//        infantSeventhLastName=(TextView)findViewById(R.id.infants7_lastname);
//        infantEigthLastName=(TextView)findViewById(R.id.infants8_lastname);
//        infantNinethLastName=(TextView)findViewById(R.id.infants9_lastname);

        infant_dob1=findViewById(R.id.infants1_dob);
        infant_dob2=findViewById(R.id.infants2_dob);
        infant_dob3=findViewById(R.id.infants3_dob);
        infant_dob4=findViewById(R.id.infants4_dob);
        infant_dob5=findViewById(R.id.infants5_dob);
        infant_dob6=findViewById(R.id.infants6_dob);
        infant_dob7=findViewById(R.id.infants7_dob);
        infant_dob8=findViewById(R.id.infants8_dob);
        infant_dob9=findViewById(R.id.infants9_dob);

        mobileNumber=findViewById(R.id.mobileNumber);
        emailId=findViewById(R.id.emailId);

        reviewDetails=findViewById(R.id.contineee);
        reviewDetails.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                if(checkData())
                {
                    Intent inr = new Intent(PassengerDetailsR.this, Reviewdetails.class);
                    inr.putExtra("adultCount", adultCount);
                    inr.putExtra("childCount", childCount);
                    inr.putExtra("infantCount", infantCount);

                    inr.putExtra("adultOneFirstName", adultOneFirstName.getText().toString());
                    inr.putExtra("adultSecondFirstName", adultSecondFirstName.getText().toString());
                    inr.putExtra("adultThirdFirstName", adultThirdFirstName.getText().toString());
                    inr.putExtra("adultFourthFirstName", adultFourthFirstName.getText().toString());
                    inr.putExtra("adultFifthFirstName", adultFifthFirstName.getText().toString());
                    inr.putExtra("adultSixthFirstName", adultSixthFirstName.getText().toString());
                    inr.putExtra("adultSeventhFirstName", adultSeventhFirstName.getText().toString());
                    inr.putExtra("adultEigthFirstName", adultEigthFirstName.getText().toString());
                    inr.putExtra("adultNinethFirstName", adultNinethFirstName.getText().toString());

                    inr.putExtra("adultOneLastName", adultOneLastName.getText().toString());
                    inr.putExtra("adultTwoLastName", adultOneLastName.getText().toString());
                    inr.putExtra("adultThirdLastName", adultOneLastName.getText().toString());
                    inr.putExtra("adultFourthLastName", adultOneLastName.getText().toString());
                    inr.putExtra("adultFifthLastName", adultOneLastName.getText().toString());
                    inr.putExtra("adultSixthLastName", adultOneLastName.getText().toString());
                    inr.putExtra("adultSeventhLastName", adultOneLastName.getText().toString());
                    inr.putExtra("adultEigthLastName", adultOneLastName.getText().toString());
                    inr.putExtra("adultNinethLastName", adultOneLastName.getText().toString());

                    inr.putExtra("childOneFirstName",childOneFirstName.getText().toString());
                    inr.putExtra("childTwoFirstName",childOneFirstName.getText().toString());
                    inr.putExtra("childThrirdFirstName",childOneFirstName.getText().toString());
                    inr.putExtra("childFourthFirstName",childOneFirstName.getText().toString());
                    inr.putExtra("childFifthFirstName",childOneFirstName.getText().toString());
                    inr.putExtra("childSixthFirstName",childOneFirstName.getText().toString());
                    inr.putExtra("childSeventhFirstName",childOneFirstName.getText().toString());
                    inr.putExtra("childEigthFirstName",childOneFirstName.getText().toString());

                    inr.putExtra("childFirstLastName",childOneFirstName.getText().toString());
                    inr.putExtra("childSecondLastName",childOneFirstName.getText().toString());
                    inr.putExtra("childThirdLastName",childOneFirstName.getText().toString());
                    inr.putExtra("childFourthLastName",childOneFirstName.getText().toString());
                    inr.putExtra("childFifthLastName",childOneFirstName.getText().toString());
                    inr.putExtra("childSixthLastName",childOneFirstName.getText().toString());
                    inr.putExtra("childSeventhLastName",childOneFirstName.getText().toString());
                    inr.putExtra("childEigthLastName",childOneFirstName.getText().toString());

                    inr.putExtra("infantOneFirstName",infantOneFirstName.getText().toString());
                    inr.putExtra("infantSecondFirstName",infantSecondFirstName.getText().toString());
                    inr.putExtra("infantThirdFirstName",infantThirdFirstName.getText().toString());
                    inr.putExtra("infantFourthFirstName",infantFourthFirstName.getText().toString());
                    inr.putExtra("infantFifthFirstName",infantFifthFirstName.getText().toString());
                    inr.putExtra("infantSixthFirstName",infantSixthFirstName.getText().toString());
                    inr.putExtra("infantSeventhFirstName",infantSeventhFirstName.getText().toString());
                    inr.putExtra("infantEigthFirstName",infantEigthFirstName.getText().toString());
                    inr.putExtra("infantNinethFirstName",infantNinethFirstName.getText().toString());

                    inr.putExtra("infantOneLastName",infant_dob1.getText().toString());
                    inr.putExtra("infantSecondName",infant_dob2.getText().toString());
                    inr.putExtra("infantThirdLastName",infant_dob3.getText().toString());
                    inr.putExtra("infantFourthLastName",infant_dob4.getText().toString());
                    inr.putExtra("infantFifthLastName",infant_dob5.getText().toString());
                    inr.putExtra("infantSixthLastName",infant_dob6.getText().toString());
                    inr.putExtra("infantSeventhLastName",infant_dob7.getText().toString());
                    inr.putExtra("infantEigthLastName",infant_dob8.getText().toString());
                    inr.putExtra("infantNinethLastName",infant_dob9.getText().toString());
                    startActivity(inr);
                }

            }
        });
        couponCode=findViewById(R.id.couponCode);
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         TotalFare=findViewById(R.id.TotalFare);

         adultSpinner1 = findViewById(R.id.spinner_adult);
         adultSpinner2 = findViewById(R.id.spinner_adult2);
         adultSpinner3 = findViewById(R.id.spinner_adult3);
         adultSpinner4 = findViewById(R.id.spinner_adult4);
         adultSpinner5 = findViewById(R.id.spinner_adult5);
         adultSpinner6 = findViewById(R.id.spinner_adult6);
         adultSpinner7 = findViewById(R.id.spinner_adult7);
         adultSpinner8 = findViewById(R.id.spinner_adult8);
         adultSpinner9 = findViewById(R.id.spinner_adult9);

         childSpinner1=findViewById(R.id.spinner_child1);
         childSpinner2=findViewById(R.id.spinner_child2);
         childSpinner3=findViewById(R.id.spinner_child3);
         childSpinner4=findViewById(R.id.spinner_child4);
         childSpinner5=findViewById(R.id.spinner_child5);
         childSpinner6=findViewById(R.id.spinner_child6);
         childSpinner7=findViewById(R.id.spinner_child7);
         childSpinner8=findViewById(R.id.spinner_child8);

         infantSpinner1=findViewById(R.id.spinner_infants1);
         infantSpinner2=findViewById(R.id.spinner_infants2);
         infantSpinner3=findViewById(R.id.spinner_infants3);
         infantSpinner4=findViewById(R.id.spinner_infants4);
         infantSpinner5=findViewById(R.id.spinner_infants5);
         infantSpinner6=findViewById(R.id.spinner_infants6);
         infantSpinner7=findViewById(R.id.spinner_infants7);
         infantSpinner8=findViewById(R.id.spinner_infants8);
         infantSpinner9=findViewById(R.id.spinner_infants9);

         maincount_adult=findViewById(R.id.maincount_adult);
        maincount_child=findViewById(R.id.maincount_child);

        maincount_infant=findViewById(R.id.maincount_infant);

         children=findViewById(R.id.children);
         infants=findViewById(R.id.infants);
        gstLinearLayout=findViewById(R.id.gstLinearLayout);
        intent=getIntent();
        adultCount=intent.getStringExtra("adultround");
        childCount=intent.getStringExtra("childround");
        infantCount=intent.getStringExtra("infantsround");

        children=findViewById(R.id.children);
        infants=findViewById(R.id.infants);

        maincount_adult.setText(adultCount);
        maincount_child.setText(childCount);
        maincount_infant.setText(infantCount);

        TotalFare.setText(String.valueOf("₹"+(Integer.parseInt((intent.getStringExtra("flightPrice")))+Integer.parseInt((intent.getStringExtra("flightPriceR"))))));


        linear_adult1=findViewById(R.id.linear_adult1);
        linear_adult2=findViewById(R.id.linear_adult2);
        linear_adult3=findViewById(R.id.linear_adult3);
        linear_adult4=findViewById(R.id.linear_adult4);
        linear_adult5=findViewById(R.id.linear_adult5);
        linear_adult6=findViewById(R.id.linear_adult6);
        linear_adult7=findViewById(R.id.linear_adult7);
        linear_adult8=findViewById(R.id.linear_adult8);
        linear_adult9=findViewById(R.id.linear_adult9);

        linear_child1=findViewById(R.id.linear_child1);
        linear_child2=findViewById(R.id.linear_child2);
        linear_child3=findViewById(R.id.linear_child3);
        linear_child4=findViewById(R.id.linear_child4);
        linear_child5=findViewById(R.id.linear_child5);
        linear_child6=findViewById(R.id.linear_child6);
        linear_child7=findViewById(R.id.linear_child7);
        linear_child8=findViewById(R.id.linear_child8);

        linear_infant1=findViewById(R.id.linear_infants1);
        linear_infant2=findViewById(R.id.linear_infants2);
        linear_infant3=findViewById(R.id.linear_infants3);
        linear_infant4=findViewById(R.id.linear_infants4);
        linear_infant5=findViewById(R.id.linear_infants5);
        linear_infant6=findViewById(R.id.linear_infants6);
        linear_infant7=findViewById(R.id.linear_infants7);
        linear_infant8=findViewById(R.id.linear_infants8);
        linear_infant9=findViewById(R.id.linear_infants9);

        //if number of children are zero
        linear_child1.setVisibility(View.GONE);
        linear_child2.setVisibility(View.GONE);
        linear_child3.setVisibility(View.GONE);
        linear_child4.setVisibility(View.GONE);
        linear_child5.setVisibility(View.GONE);
        linear_child6.setVisibility(View.GONE);
        linear_child7.setVisibility(View.GONE);
        linear_child8.setVisibility(View.GONE);

        //if number of infants are zero
        linear_infant1.setVisibility(View.GONE);
        linear_infant2.setVisibility(View.GONE);
        linear_infant3.setVisibility(View.GONE);
        linear_infant4.setVisibility(View.GONE);
        linear_infant5.setVisibility(View.GONE);
        linear_infant6.setVisibility(View.GONE);
        linear_infant7.setVisibility(View.GONE);
        linear_infant8.setVisibility(View.GONE);
        linear_infant9.setVisibility(View.GONE);
        infants=(TextView) findViewById(R.id.infants);
        if(Integer.parseInt(childCount)==0)
        {
            children.setVisibility(View.GONE);
            maincount_child.setVisibility(View.GONE);
        }
        if(Integer.parseInt(infantCount)==0)
        {
            infants.setVisibility(View.GONE);
            maincount_infant.setVisibility(View.GONE);
        }
        if(Integer.parseInt(adultCount)==1)
        {
            linear_adult1.setVisibility(View.VISIBLE);
            linear_adult2.setVisibility(View.GONE);
            linear_adult3.setVisibility(View.GONE);
            linear_adult4.setVisibility(View.GONE);
            linear_adult5.setVisibility(View.GONE);
            linear_adult6.setVisibility(View.GONE);
            linear_adult7.setVisibility(View.GONE);
            linear_adult8.setVisibility(View.GONE);
            linear_adult9.setVisibility(View.GONE);

            if(Integer.parseInt(childCount)==0)
            {
                maincount_child.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==1)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.GONE);
                linear_child3.setVisibility(View.GONE);
                linear_child4.setVisibility(View.GONE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);


            }
            else if(Integer.parseInt(childCount)==2)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.GONE);
                linear_child4.setVisibility(View.GONE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);

            }
            else if (Integer.parseInt(childCount)==3)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.GONE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);

            }
            else if(Integer.parseInt(childCount)==4)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);

            }
            else if(Integer.parseInt(childCount)==5)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);

            }
            else if(Integer.parseInt(childCount)==6)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.VISIBLE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);

            }
            else if(Integer.parseInt(childCount)==7)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.VISIBLE);
                linear_child7.setVisibility(View.VISIBLE);
                linear_child8.setVisibility(View.GONE);

            }
            else if(Integer.parseInt(childCount)==8)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.VISIBLE);
                linear_child7.setVisibility(View.VISIBLE);
                linear_child8.setVisibility(View.VISIBLE);

            }
            if(Integer.parseInt(infantCount)==1)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.GONE);
                linear_infant3.setVisibility(View.GONE);
                linear_infant4.setVisibility(View.GONE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }
            else if(Integer.parseInt(infantCount)==2)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.GONE);
                linear_infant4.setVisibility(View.GONE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==3)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.GONE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==4)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==5)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);

                linear_infant4.setVisibility(View.VISIBLE);

                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==6)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==7)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.VISIBLE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==8)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.VISIBLE);
                linear_infant8.setVisibility(View.VISIBLE);
                linear_infant9.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(infantCount)==9)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.VISIBLE);
                linear_infant8.setVisibility(View.VISIBLE);
                linear_infant9.setVisibility(View.VISIBLE);
            }
        }//end of outer if
        if(Integer.parseInt(adultCount)==2)
        {
            linear_adult1.setVisibility(View.VISIBLE);
            linear_adult2.setVisibility(View.VISIBLE);
            linear_adult3.setVisibility(View.GONE);
            linear_adult4.setVisibility(View.GONE);
            linear_adult5.setVisibility(View.GONE);
            linear_adult6.setVisibility(View.GONE);
            linear_adult7.setVisibility(View.GONE);
            linear_adult8.setVisibility(View.GONE);
            linear_adult9.setVisibility(View.GONE);

            if(Integer.parseInt(childCount)==0)
            {
                maincount_child.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==1)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.GONE);
                linear_child3.setVisibility(View.GONE);
                linear_child4.setVisibility(View.GONE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);

            }
            else if(Integer.parseInt(childCount)==2)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.GONE);
                linear_child4.setVisibility(View.GONE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);
            }
            else if (Integer.parseInt(childCount)==3)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.GONE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==4)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==5)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==6)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.VISIBLE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);


            }
            else if(Integer.parseInt(childCount)==7)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.VISIBLE);
                linear_child7.setVisibility(View.VISIBLE);
                linear_child8.setVisibility(View.GONE);

            }
            else if(Integer.parseInt(childCount)==8)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.VISIBLE);
                linear_child7.setVisibility(View.VISIBLE);
                linear_child8.setVisibility(View.VISIBLE);

            }
            if(Integer.parseInt(infantCount)==1)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.GONE);
                linear_infant3.setVisibility(View.GONE);
                linear_infant4.setVisibility(View.GONE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }
            else if(Integer.parseInt(infantCount)==2)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.GONE);
                linear_infant4.setVisibility(View.GONE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==3)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.GONE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==4)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==5)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);

                linear_infant4.setVisibility(View.VISIBLE);

                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==6)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==7)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.VISIBLE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==8)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.VISIBLE);
                linear_infant8.setVisibility(View.VISIBLE);
                linear_infant9.setVisibility(View.GONE);


            }
            else if(Integer.parseInt(infantCount)==9)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.VISIBLE);
                linear_infant8.setVisibility(View.VISIBLE);
                linear_infant9.setVisibility(View.VISIBLE);
            }



        }//end of outer if, two adults


        else if(Integer.parseInt(adultCount)==3)
        {
        linear_adult1.setVisibility(View.VISIBLE);
        linear_adult2.setVisibility(View.VISIBLE);
        linear_adult3.setVisibility(View.VISIBLE);
            linear_adult4.setVisibility(View.GONE);
            linear_adult5.setVisibility(View.GONE);
            linear_adult6.setVisibility(View.GONE);
            linear_adult7.setVisibility(View.GONE);
            linear_adult8.setVisibility(View.GONE);
            linear_adult9.setVisibility(View.GONE);
            if(Integer.parseInt(childCount)==0)
            {
                maincount_child.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==1)
        {
            linear_child1.setVisibility(View.VISIBLE);
            linear_child2.setVisibility(View.GONE);
            linear_child3.setVisibility(View.GONE);
            linear_child4.setVisibility(View.GONE);
            linear_child5.setVisibility(View.GONE);
            linear_child6.setVisibility(View.GONE);
            linear_child7.setVisibility(View.GONE);
            linear_child8.setVisibility(View.GONE);

        }
        else if(Integer.parseInt(childCount)==2)
        {
            linear_child1.setVisibility(View.VISIBLE);
            linear_child2.setVisibility(View.VISIBLE);
            linear_child3.setVisibility(View.GONE);
            linear_child4.setVisibility(View.GONE);
            linear_child5.setVisibility(View.GONE);
            linear_child6.setVisibility(View.GONE);
            linear_child7.setVisibility(View.GONE);
            linear_child8.setVisibility(View.GONE);

        }
        else if (Integer.parseInt(childCount)==3)
        {
            linear_child1.setVisibility(View.VISIBLE);
            linear_child2.setVisibility(View.VISIBLE);
            linear_child3.setVisibility(View.VISIBLE);
            linear_child4.setVisibility(View.GONE);
            linear_child5.setVisibility(View.GONE);
            linear_child6.setVisibility(View.GONE);
            linear_child7.setVisibility(View.GONE);
            linear_child8.setVisibility(View.GONE);

        }
        else if(Integer.parseInt(childCount)==4)
        {
            linear_child1.setVisibility(View.VISIBLE);
            linear_child2.setVisibility(View.VISIBLE);
            linear_child3.setVisibility(View.VISIBLE);
            linear_child4.setVisibility(View.VISIBLE);
            linear_child5.setVisibility(View.GONE);
            linear_child6.setVisibility(View.GONE);
            linear_child7.setVisibility(View.GONE);
            linear_child8.setVisibility(View.GONE);

        }
        else if(Integer.parseInt(childCount)==5)
        {
            linear_child1.setVisibility(View.VISIBLE);
            linear_child2.setVisibility(View.VISIBLE);
            linear_child3.setVisibility(View.VISIBLE);
            linear_child4.setVisibility(View.VISIBLE);
            linear_child5.setVisibility(View.VISIBLE);
            linear_child6.setVisibility(View.GONE);
            linear_child7.setVisibility(View.GONE);
            linear_child8.setVisibility(View.GONE);

        }
        else if(Integer.parseInt(childCount)==6)
        {
            linear_child1.setVisibility(View.VISIBLE);
            linear_child2.setVisibility(View.VISIBLE);
            linear_child3.setVisibility(View.VISIBLE);
            linear_child4.setVisibility(View.VISIBLE);
            linear_child5.setVisibility(View.VISIBLE);
            linear_child6.setVisibility(View.VISIBLE);
            linear_child7.setVisibility(View.GONE);
            linear_child8.setVisibility(View.GONE);

        }
        else if(Integer.parseInt(childCount)==7)
        {
            linear_child1.setVisibility(View.VISIBLE);
            linear_child2.setVisibility(View.VISIBLE);
            linear_child3.setVisibility(View.VISIBLE);
            linear_child4.setVisibility(View.VISIBLE);
            linear_child5.setVisibility(View.VISIBLE);
            linear_child6.setVisibility(View.VISIBLE);
            linear_child7.setVisibility(View.VISIBLE);
            linear_child8.setVisibility(View.GONE);

        }
        else if(Integer.parseInt(childCount)==8)
        {
            linear_child1.setVisibility(View.VISIBLE);
            linear_child2.setVisibility(View.VISIBLE);
            linear_child3.setVisibility(View.VISIBLE);
            linear_child4.setVisibility(View.VISIBLE);
            linear_child5.setVisibility(View.VISIBLE);
            linear_child6.setVisibility(View.VISIBLE);
            linear_child7.setVisibility(View.VISIBLE);
            linear_child8.setVisibility(View.VISIBLE);

        }
        if(Integer.parseInt(infantCount)==1)
        {
            linear_infant1.setVisibility(View.VISIBLE);
            linear_infant2.setVisibility(View.GONE);
            linear_infant3.setVisibility(View.GONE);
            linear_infant4.setVisibility(View.GONE);
            linear_infant5.setVisibility(View.GONE);
            linear_infant6.setVisibility(View.GONE);
            linear_infant7.setVisibility(View.GONE);
            linear_infant8.setVisibility(View.GONE);
            linear_infant9.setVisibility(View.GONE);

        }
        else if(Integer.parseInt(infantCount)==2)
        {
            linear_infant1.setVisibility(View.VISIBLE);
            linear_infant2.setVisibility(View.VISIBLE);
            linear_infant3.setVisibility(View.GONE);
            linear_infant4.setVisibility(View.GONE);
            linear_infant5.setVisibility(View.GONE);
            linear_infant7.setVisibility(View.GONE);
            linear_infant8.setVisibility(View.GONE);
            linear_infant9.setVisibility(View.GONE);


        }

        else if(Integer.parseInt(infantCount)==3)
        {
            linear_infant1.setVisibility(View.VISIBLE);
            linear_infant2.setVisibility(View.VISIBLE);
            linear_infant3.setVisibility(View.VISIBLE);
            linear_infant4.setVisibility(View.GONE);
            linear_infant5.setVisibility(View.GONE);
            linear_infant6.setVisibility(View.GONE);
            linear_infant7.setVisibility(View.GONE);
            linear_infant8.setVisibility(View.GONE);
            linear_infant9.setVisibility(View.GONE);

        }

        else if(Integer.parseInt(infantCount)==4)
        {
            linear_infant1.setVisibility(View.VISIBLE);
            linear_infant2.setVisibility(View.VISIBLE);
            linear_infant3.setVisibility(View.VISIBLE);
            linear_infant4.setVisibility(View.VISIBLE);
            linear_infant5.setVisibility(View.GONE);
            linear_infant6.setVisibility(View.GONE);
            linear_infant7.setVisibility(View.GONE);
            linear_infant8.setVisibility(View.GONE);
            linear_infant9.setVisibility(View.GONE);

        }

        else if(Integer.parseInt(infantCount)==5)
        {
            linear_infant1.setVisibility(View.VISIBLE);
            linear_infant2.setVisibility(View.VISIBLE);
            linear_infant3.setVisibility(View.VISIBLE);
            linear_infant4.setVisibility(View.VISIBLE);
            linear_infant5.setVisibility(View.VISIBLE);
            linear_infant6.setVisibility(View.GONE);
            linear_infant7.setVisibility(View.GONE);
            linear_infant8.setVisibility(View.GONE);
            linear_infant9.setVisibility(View.GONE);

        }

        else if(Integer.parseInt(infantCount)==6)
        {
            linear_infant1.setVisibility(View.VISIBLE);
            linear_infant2.setVisibility(View.VISIBLE);
            linear_infant3.setVisibility(View.VISIBLE);
            linear_infant4.setVisibility(View.VISIBLE);
            linear_infant5.setVisibility(View.VISIBLE);
            linear_infant6.setVisibility(View.VISIBLE);
            linear_infant7.setVisibility(View.GONE);
            linear_infant8.setVisibility(View.GONE);
            linear_infant9.setVisibility(View.GONE);

        }

        else if(Integer.parseInt(infantCount)==7)
        {
            linear_infant1.setVisibility(View.VISIBLE);
            linear_infant2.setVisibility(View.VISIBLE);
            linear_infant3.setVisibility(View.VISIBLE);
            linear_infant4.setVisibility(View.VISIBLE);
            linear_infant5.setVisibility(View.VISIBLE);
            linear_infant6.setVisibility(View.VISIBLE);
            linear_infant7.setVisibility(View.VISIBLE);
            linear_infant8.setVisibility(View.GONE);
            linear_infant9.setVisibility(View.GONE);

        }

        else if(Integer.parseInt(infantCount)==8)
        {
            linear_infant1.setVisibility(View.VISIBLE);
            linear_infant2.setVisibility(View.VISIBLE);
            linear_infant3.setVisibility(View.VISIBLE);
            linear_infant4.setVisibility(View.VISIBLE);
            linear_infant5.setVisibility(View.VISIBLE);
            linear_infant6.setVisibility(View.VISIBLE);
            linear_infant7.setVisibility(View.VISIBLE);
            linear_infant8.setVisibility(View.VISIBLE);
            linear_infant9.setVisibility(View.GONE);









        }
        else if(Integer.parseInt(infantCount)==9)
        {
            linear_infant1.setVisibility(View.VISIBLE);
            linear_infant2.setVisibility(View.VISIBLE);
            linear_infant3.setVisibility(View.VISIBLE);
            linear_infant4.setVisibility(View.VISIBLE);
            linear_infant5.setVisibility(View.VISIBLE);
            linear_infant6.setVisibility(View.VISIBLE);
            linear_infant7.setVisibility(View.VISIBLE);
            linear_infant8.setVisibility(View.VISIBLE);
            linear_infant9.setVisibility(View.VISIBLE);
        }



    }
        if(Integer.parseInt(adultCount)==4)
        {
            linear_adult1.setVisibility(View.VISIBLE);
            linear_adult2.setVisibility(View.VISIBLE);
            linear_adult3.setVisibility(View.VISIBLE);
            linear_adult4.setVisibility(View.VISIBLE);
            linear_adult5.setVisibility(View.GONE);
            linear_adult6.setVisibility(View.GONE);
            linear_adult7.setVisibility(View.GONE);
            linear_adult8.setVisibility(View.GONE);
            linear_adult9.setVisibility(View.GONE);

            if(Integer.parseInt(childCount)==0)
            {
                maincount_child.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==1)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.GONE);
                linear_child3.setVisibility(View.GONE);
                linear_child4.setVisibility(View.GONE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);

            }
            else if(Integer.parseInt(childCount)==2)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.GONE);
                linear_child4.setVisibility(View.GONE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);
            }
            else if (Integer.parseInt(childCount)==3)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.GONE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==4)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==5)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==6)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.VISIBLE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);


            }
            else if(Integer.parseInt(childCount)==7)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.VISIBLE);
                linear_child7.setVisibility(View.VISIBLE);
                linear_child8.setVisibility(View.GONE);

            }
            else if(Integer.parseInt(childCount)==8)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.VISIBLE);
                linear_child7.setVisibility(View.VISIBLE);
                linear_child8.setVisibility(View.VISIBLE);

            }
            if(Integer.parseInt(infantCount)==1)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.GONE);
                linear_infant3.setVisibility(View.GONE);
                linear_infant4.setVisibility(View.GONE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }
            else if(Integer.parseInt(infantCount)==2)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.GONE);
                linear_infant4.setVisibility(View.GONE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==3)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.GONE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==4)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==5)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);

                linear_infant4.setVisibility(View.VISIBLE);

                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==6)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==7)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.VISIBLE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==8)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.VISIBLE);
                linear_infant8.setVisibility(View.VISIBLE);
                linear_infant9.setVisibility(View.GONE);


            }
            else if(Integer.parseInt(infantCount)==9)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.VISIBLE);
                linear_infant8.setVisibility(View.VISIBLE);
                linear_infant9.setVisibility(View.VISIBLE);
            }



        }//end of outer if
        if(Integer.parseInt(adultCount)==5)
        {
            linear_adult1.setVisibility(View.VISIBLE);
            linear_adult2.setVisibility(View.VISIBLE);
            linear_adult3.setVisibility(View.VISIBLE);
            linear_adult4.setVisibility(View.VISIBLE);
            linear_adult5.setVisibility(View.VISIBLE);
            linear_adult6.setVisibility(View.GONE);
            linear_adult7.setVisibility(View.GONE);
            linear_adult8.setVisibility(View.GONE);
            linear_adult9.setVisibility(View.GONE);
            if(Integer.parseInt(childCount)==0)
            {
                maincount_child.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==1)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.GONE);
                linear_child3.setVisibility(View.GONE);
                linear_child4.setVisibility(View.GONE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);

            }
            else if(Integer.parseInt(childCount)==2)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.GONE);
                linear_child4.setVisibility(View.GONE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);
            }
            else if (Integer.parseInt(childCount)==3)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.GONE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==4)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==5)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==6)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.VISIBLE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);


            }
            else if(Integer.parseInt(childCount)==7)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.VISIBLE);
                linear_child7.setVisibility(View.VISIBLE);
                linear_child8.setVisibility(View.GONE);

            }
            else if(Integer.parseInt(childCount)==8)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.VISIBLE);
                linear_child7.setVisibility(View.VISIBLE);
                linear_child8.setVisibility(View.VISIBLE);

            }
            if(Integer.parseInt(infantCount)==1)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.GONE);
                linear_infant3.setVisibility(View.GONE);
                linear_infant4.setVisibility(View.GONE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }
            else if(Integer.parseInt(infantCount)==2)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.GONE);
                linear_infant4.setVisibility(View.GONE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==3)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.GONE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==4)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==5)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);

                linear_infant4.setVisibility(View.VISIBLE);

                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==6)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==7)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.VISIBLE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==8)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.VISIBLE);
                linear_infant8.setVisibility(View.VISIBLE);
                linear_infant9.setVisibility(View.GONE);


            }
            else if(Integer.parseInt(infantCount)==9)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.VISIBLE);
                linear_infant8.setVisibility(View.VISIBLE);
                linear_infant9.setVisibility(View.VISIBLE);
            }



        }//end of outer if
        if(Integer.parseInt(adultCount)==6)
        {
            linear_adult1.setVisibility(View.VISIBLE);
            linear_adult2.setVisibility(View.VISIBLE);
            linear_adult3.setVisibility(View.VISIBLE);
            linear_adult4.setVisibility(View.VISIBLE);
            linear_adult5.setVisibility(View.VISIBLE);
            linear_adult6.setVisibility(View.VISIBLE);
            linear_adult7.setVisibility(View.GONE);
            linear_adult8.setVisibility(View.GONE);
            linear_adult9.setVisibility(View.GONE);

            if(Integer.parseInt(childCount)==0)
            {
                maincount_child.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==1)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.GONE);
                linear_child3.setVisibility(View.GONE);
                linear_child4.setVisibility(View.GONE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);

            }
            else if(Integer.parseInt(childCount)==2)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.GONE);
                linear_child4.setVisibility(View.GONE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);
            }
            else if (Integer.parseInt(childCount)==3)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.GONE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==4)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==5)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==6)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.VISIBLE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);


            }
            else if(Integer.parseInt(childCount)==7)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.VISIBLE);
                linear_child7.setVisibility(View.VISIBLE);
                linear_child8.setVisibility(View.GONE);

            }
            else if(Integer.parseInt(childCount)==8)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.VISIBLE);
                linear_child7.setVisibility(View.VISIBLE);
                linear_child8.setVisibility(View.VISIBLE);

            }
            if(Integer.parseInt(infantCount)==0)
            {
                maincount_infant.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(infantCount)==1)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.GONE);
                linear_infant3.setVisibility(View.GONE);
                linear_infant4.setVisibility(View.GONE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }
            else if(Integer.parseInt(infantCount)==2)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.GONE);
                linear_infant4.setVisibility(View.GONE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==3)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.GONE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==4)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==5)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);

                linear_infant4.setVisibility(View.VISIBLE);

                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==6)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==7)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.VISIBLE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==8)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.VISIBLE);
                linear_infant8.setVisibility(View.VISIBLE);
                linear_infant9.setVisibility(View.GONE);


            }
            else if(Integer.parseInt(infantCount)==9)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.VISIBLE);
                linear_infant8.setVisibility(View.VISIBLE);
                linear_infant9.setVisibility(View.VISIBLE);
            }



        }//end of outer if
        if(Integer.parseInt(adultCount)==7)
        {
            linear_adult1.setVisibility(View.VISIBLE);
            linear_adult2.setVisibility(View.VISIBLE);
            linear_adult3.setVisibility(View.VISIBLE);
            linear_adult4.setVisibility(View.VISIBLE);
            linear_adult5.setVisibility(View.VISIBLE);
            linear_adult6.setVisibility(View.VISIBLE);
            linear_adult7.setVisibility(View.VISIBLE);
            linear_adult8.setVisibility(View.GONE);
            linear_adult9.setVisibility(View.GONE);
            if(Integer.parseInt(childCount)==0)
            {
                maincount_child.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==1)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.GONE);
                linear_child3.setVisibility(View.GONE);
                linear_child4.setVisibility(View.GONE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);

            }
            else if(Integer.parseInt(childCount)==2)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.GONE);
                linear_child4.setVisibility(View.GONE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);
            }
            else if (Integer.parseInt(childCount)==3)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.GONE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==4)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==5)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==6)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.VISIBLE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);


            }
            else if(Integer.parseInt(childCount)==7)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.VISIBLE);
                linear_child7.setVisibility(View.VISIBLE);
                linear_child8.setVisibility(View.GONE);

            }
            else if(Integer.parseInt(childCount)==8)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.VISIBLE);
                linear_child7.setVisibility(View.VISIBLE);
                linear_child8.setVisibility(View.VISIBLE);

            }
            if(Integer.parseInt(infantCount)==1)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.GONE);
                linear_infant3.setVisibility(View.GONE);
                linear_infant4.setVisibility(View.GONE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }
            else if(Integer.parseInt(infantCount)==2)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.GONE);
                linear_infant4.setVisibility(View.GONE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==3)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.GONE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==4)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==5)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);

                linear_infant4.setVisibility(View.VISIBLE);

                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==6)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==7)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.VISIBLE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==8)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.VISIBLE);
                linear_infant8.setVisibility(View.VISIBLE);
                linear_infant9.setVisibility(View.GONE);


            }
            else if(Integer.parseInt(infantCount)==9)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.VISIBLE);
                linear_infant8.setVisibility(View.VISIBLE);
                linear_infant9.setVisibility(View.VISIBLE);
            }



        }//end of outer if
        if(Integer.parseInt(adultCount)==8)
        {
            linear_adult1.setVisibility(View.VISIBLE);
            linear_adult2.setVisibility(View.VISIBLE);
            linear_adult3.setVisibility(View.VISIBLE);
            linear_adult4.setVisibility(View.VISIBLE);
            linear_adult5.setVisibility(View.VISIBLE);
            linear_adult6.setVisibility(View.VISIBLE);
            linear_adult7.setVisibility(View.VISIBLE);
            linear_adult8.setVisibility(View.VISIBLE);
            linear_adult9.setVisibility(View.GONE);
            if(Integer.parseInt(childCount)==0)
            {
                maincount_child.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==1)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.GONE);
                linear_child3.setVisibility(View.GONE);
                linear_child4.setVisibility(View.GONE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);

            }
            else if(Integer.parseInt(childCount)==2)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.GONE);
                linear_child4.setVisibility(View.GONE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);
            }
            else if (Integer.parseInt(childCount)==3)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.GONE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==4)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==5)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==6)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.VISIBLE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);


            }
            else if(Integer.parseInt(childCount)==7)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.VISIBLE);
                linear_child7.setVisibility(View.VISIBLE);
                linear_child8.setVisibility(View.GONE);

            }
            else if(Integer.parseInt(childCount)==8)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.VISIBLE);
                linear_child7.setVisibility(View.VISIBLE);
                linear_child8.setVisibility(View.VISIBLE);

            }
            if(Integer.parseInt(infantCount)==1)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.GONE);
                linear_infant3.setVisibility(View.GONE);
                linear_infant4.setVisibility(View.GONE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }
            else if(Integer.parseInt(infantCount)==2)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.GONE);
                linear_infant4.setVisibility(View.GONE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==3)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.GONE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==4)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==5)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);

                linear_infant4.setVisibility(View.VISIBLE);

                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==6)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==7)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.VISIBLE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==8)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.VISIBLE);
                linear_infant8.setVisibility(View.VISIBLE);
                linear_infant9.setVisibility(View.GONE);


            }
            else if(Integer.parseInt(infantCount)==9)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.VISIBLE);
                linear_infant8.setVisibility(View.VISIBLE);
                linear_infant9.setVisibility(View.VISIBLE);
            }



        }//end of outer if
        else if(Integer.parseInt(adultCount)==9)
        {
            linear_adult1.setVisibility(View.VISIBLE);
            linear_adult2.setVisibility(View.VISIBLE);
            linear_adult3.setVisibility(View.VISIBLE);
            linear_adult4.setVisibility(View.VISIBLE);
            linear_adult5.setVisibility(View.VISIBLE);
            linear_adult6.setVisibility(View.VISIBLE);
            linear_adult7.setVisibility(View.VISIBLE);
            linear_adult8.setVisibility(View.VISIBLE);
            linear_adult9.setVisibility(View.VISIBLE);
            if(Integer.parseInt(childCount)==0)
            {
                maincount_child.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==1)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.GONE);
                linear_child3.setVisibility(View.GONE);
                linear_child4.setVisibility(View.GONE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);

            }
            else if(Integer.parseInt(childCount)==2)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.GONE);
                linear_child4.setVisibility(View.GONE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);
            }
            else if (Integer.parseInt(childCount)==3)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.GONE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==4)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.GONE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==5)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.GONE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);
            }
            else if(Integer.parseInt(childCount)==6)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.VISIBLE);
                linear_child7.setVisibility(View.GONE);
                linear_child8.setVisibility(View.GONE);


            }
            else if(Integer.parseInt(childCount)==7)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.VISIBLE);
                linear_child7.setVisibility(View.VISIBLE);
                linear_child8.setVisibility(View.GONE);

            }
            else if(Integer.parseInt(childCount)==8)
            {
                linear_child1.setVisibility(View.VISIBLE);
                linear_child2.setVisibility(View.VISIBLE);
                linear_child3.setVisibility(View.VISIBLE);
                linear_child4.setVisibility(View.VISIBLE);
                linear_child5.setVisibility(View.VISIBLE);
                linear_child6.setVisibility(View.VISIBLE);
                linear_child7.setVisibility(View.VISIBLE);
                linear_child8.setVisibility(View.VISIBLE);

            }
            if(Integer.parseInt(infantCount)==1)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.GONE);
                linear_infant3.setVisibility(View.GONE);
                linear_infant4.setVisibility(View.GONE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }
            else if(Integer.parseInt(infantCount)==2)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.GONE);
                linear_infant4.setVisibility(View.GONE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==3)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.GONE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==4)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.GONE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==5)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);

                linear_infant4.setVisibility(View.VISIBLE);

                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.GONE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==6)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.GONE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==7)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.VISIBLE);
                linear_infant8.setVisibility(View.GONE);
                linear_infant9.setVisibility(View.GONE);

            }

            else if(Integer.parseInt(infantCount)==8)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.VISIBLE);
                linear_infant8.setVisibility(View.VISIBLE);
                linear_infant9.setVisibility(View.GONE);


            }
            else if(Integer.parseInt(infantCount)==9)
            {
                linear_infant1.setVisibility(View.VISIBLE);
                linear_infant2.setVisibility(View.VISIBLE);
                linear_infant3.setVisibility(View.VISIBLE);
                linear_infant4.setVisibility(View.VISIBLE);
                linear_infant5.setVisibility(View.VISIBLE);
                linear_infant6.setVisibility(View.VISIBLE);
                linear_infant7.setVisibility(View.VISIBLE);
                linear_infant8.setVisibility(View.VISIBLE);
                linear_infant9.setVisibility(View.VISIBLE);
            }

        }//end of outer if
        childSpinners();
        infantSpinners();
        adultSpinners();
    }//End of Create method

    public boolean checkData()
    {
        if(TextUtils.isEmpty(adultOneFirstName.getText()))
        {
            adultOneFirstName.setError("Please enter First Name");
            adultOneFirstName.requestFocus();
            return false;
        }
         if(TextUtils.isEmpty(adultOneLastName.getText()))
        {
            adultOneLastName.setError("Please enter last Name");
            adultOneLastName.requestFocus();
            return false;
        }
         if(TextUtils.isEmpty(adultSecondFirstName.getText()) && Integer.parseInt(adultCount)>=2)
        {
            adultSecondFirstName.setError("Please enter your First Name");
            adultSecondFirstName.requestFocus();
            return false;
        }
         if(TextUtils.isEmpty(adultSecondLastName.getText())&& Integer.parseInt(adultCount)>=2)
        {
            adultSecondLastName.setError("Please enter your Last name");
            adultSecondLastName.requestFocus();
            return false;
        }
         if(TextUtils.isEmpty(adultThirdFirstName.getText())&& Integer.parseInt(adultCount)>=3)
        {
            adultThirdFirstName.setError("Please enter your First name");
            adultThirdFirstName.requestFocus();
            return false;
        }
         if(TextUtils.isEmpty(adultThirdLastName.getText())&& Integer.parseInt(adultCount)>=3)
        {
            adultThirdLastName.setError("Please enter your Last name");
            adultThirdLastName.requestFocus();
            return false;
        }
         if(TextUtils.isEmpty(adultFourthFirstName.getText()) && Integer.parseInt(adultCount)>=4)
        {
            adultFourthFirstName.setError("Please enter your First name");
            adultFourthFirstName.requestFocus();
            return false;
        }
         if(TextUtils.isEmpty(adultFourthLastName.getText()) && Integer.parseInt(adultCount)>=4)
        {
            adultFourthLastName.setError("Please enter your Last name");
            adultFourthLastName.requestFocus();
            return false;
        }
         if(TextUtils.isEmpty(adultFifthFirstName.getText()) && Integer.parseInt(adultCount)>=5)
        {
            adultFifthFirstName.setError("Please enter your First name");
            adultFifthFirstName.requestFocus();
            return false;
        }
         if(TextUtils.isEmpty(adultFifthLastName.getText()) && Integer.parseInt(adultCount)>=5)
        {
            adultFifthLastName.setError("Please enter your Last name");
            adultFifthLastName.requestFocus();
            return false;
        }
         if(TextUtils.isEmpty(adultSixthFirstName.getText())&& Integer.parseInt(adultCount)>=6)
        {
            adultSixthFirstName.setError("Please enter your First name");
            adultSixthFirstName.requestFocus();
            return false;
        }
         if(TextUtils.isEmpty(adultSixthLastName.getText())&& Integer.parseInt(adultCount)>=6)
        {
            adultSixthLastName.setError("Please enter your Last name");
            adultSixthLastName.requestFocus();
            return false;
        }
         if(TextUtils.isEmpty(adultSeventhFirstName.getText())&& Integer.parseInt(adultCount)>=7)
        {
            adultSeventhFirstName.setError("Please enter your first name");
            adultSeventhFirstName.requestFocus();
            return false;
        }
         if(TextUtils.isEmpty(adultSeventhLastName.getText())&& Integer.parseInt(adultCount)>=7)
        {
            adultSeventhLastName.setError("Please enter your Last name");
            adultSeventhLastName.requestFocus();
            return false;
        }
         if(TextUtils.isEmpty(adultEigthFirstName.getText())&& Integer.parseInt(adultCount)>=8)
        {
            adultEigthFirstName.setError("Please enter your First name");
            adultEigthFirstName.requestFocus();
            return false;
        }
         if(TextUtils.isEmpty(adultEigthLastName.getText())&& Integer.parseInt(adultCount)>=8)
        {
            adultEigthLastName.setError("Please enter your Last name");
            adultEigthLastName.requestFocus();
            return false;
        }
         if(TextUtils.isEmpty(adultNinethFirstName.getText())&& Integer.parseInt(adultCount)>=9)
        {
            adultNinethFirstName.setError("Please enter your First name");
            adultNinethFirstName.requestFocus();
            return false;
        }
         if(TextUtils.isEmpty(adultNinethLastName.getText())&& Integer.parseInt(adultCount)>=9)
        {
            adultNinethLastName.setError("Please enter your Last name");
            adultNinethLastName.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(childOneFirstName.getText()) && Integer.parseInt(childCount)>=1)
        {
            childOneFirstName.setError("Please enter your First Name");
            childOneFirstName.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(childOneLastName.getText()) && Integer.parseInt(childCount)>=1)
        {
            childOneLastName.setError("Please enter your Last Name");
            childOneLastName.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(childSecondFirstName.getText()) && Integer.parseInt(childCount)>=2)
        {
            childSecondFirstName.setError("Please enter your First Name");
            childSecondFirstName.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(childSecondLastName.getText()) && Integer.parseInt(childCount)>=2)
        {
            childSecondLastName.setError("Please enter your Last Name");
            childSecondLastName.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(childThirdFirstName.getText()) && Integer.parseInt(childCount)>=3)
        {
            childThirdFirstName.setError("Please enter your First Name");
            childThirdFirstName.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(childThirdLastName.getText()) && Integer.parseInt(childCount)>=3)
        {
            childThirdLastName.setError("Please enter your Last Name");
            childThirdLastName.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(childFourthFirstName.getText()) && Integer.parseInt(childCount)>=4)
        {
            childFourthFirstName.setError("Please enter your First Name");
            childFourthFirstName.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(childFourthLastName.getText()) && Integer.parseInt(childCount)>=4)
        {
            childFourthLastName.setError("Please enter your Last Name");
            childFourthLastName.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(childFifthFirstName.getText()) && Integer.parseInt(childCount)>=5)
        {
            childFifthFirstName.setError("Please enter your First Name");
            childFifthFirstName.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(childFifthLastName.getText()) && Integer.parseInt(childCount)>=5)
        {
            childFifthLastName.setError("Please enter your Last Name");
            childFifthLastName.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(childSixthFirstName.getText()) && Integer.parseInt(childCount)>=6)
        {
            childSixthFirstName.setError("Please enter your First Name");
            childSixthFirstName.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(childSixthLastName.getText()) && Integer.parseInt(childCount)>=6)
        {
            childSixthLastName.setError("Please enter your Last Name");
            childSixthLastName.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(childSeventhFirstName.getText()) && Integer.parseInt(childCount)>=7)
        {
            childSeventhFirstName.setError("Please enter your First Name");
            childSeventhFirstName.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(childSeventhLastName.getText()) && Integer.parseInt(childCount)>=7)
        {
            childSeventhLastName.setError("Please enter your Last Name");
            childSeventhLastName.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(childEigthFirstName.getText()) && Integer.parseInt(childCount)>=8)
        {
            childEigthFirstName.setError("Please enter your First Name");
            childEigthFirstName.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(childEigthLastName.getText()) && Integer.parseInt(childCount)>=8)
        {
            childEigthLastName.setError("Please enter your Last Name");
            childEigthLastName.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(mobileNumber.getText()) )
        {
            mobileNumber.setError("Please enter Mobile number");
            mobileNumber.requestFocus();
            return false;
        }
        if(TextUtils.isEmpty(emailId.getText()))
        {
            emailId.setError("Please enter Email ID");
            emailId.requestFocus();
            return false;
        }
        return true;
    }

    public void childSpinners()
    {
        List<String> title = new ArrayList<String>();
        title.add("Mstr.");
        title.add("Miss.");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, title);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        childSpinner1.setAdapter(dataAdapter);
        childSpinner2.setAdapter(dataAdapter);
        childSpinner3.setAdapter(dataAdapter);
        childSpinner4.setAdapter(dataAdapter);
        childSpinner5.setAdapter(dataAdapter);
        childSpinner6.setAdapter(dataAdapter);
        childSpinner7.setAdapter(dataAdapter);
        childSpinner8.setAdapter(dataAdapter);
    }
    public void infantSpinners()
    {
        List<String> title=new ArrayList<String>();
        title.add("Mstr.");
        title.add("Miss.");
        ArrayAdapter<String> dataAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,title);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        infantSpinner1.setAdapter(dataAdapter);
        infantSpinner2.setAdapter(dataAdapter);
        infantSpinner3.setAdapter(dataAdapter);
        infantSpinner4.setAdapter(dataAdapter);
        infantSpinner5.setAdapter(dataAdapter);
        infantSpinner6.setAdapter(dataAdapter);
        infantSpinner7.setAdapter(dataAdapter);
        infantSpinner8.setAdapter(dataAdapter);
        infantSpinner9.setAdapter(dataAdapter);
    }//end of infantSpinner method
    public void adultSpinners()
    {
        List<String> title=new ArrayList<String>();
        title.add("Mr.");
        title.add("Miss.");
        ArrayAdapter dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,title);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adultSpinner1.setAdapter(dataAdapter);
        adultSpinner2.setAdapter(dataAdapter);
        adultSpinner3.setAdapter(dataAdapter);
        adultSpinner4.setAdapter(dataAdapter);
        adultSpinner5.setAdapter(dataAdapter);
        adultSpinner6.setAdapter(dataAdapter);
        adultSpinner7.setAdapter(dataAdapter);
        adultSpinner8.setAdapter(dataAdapter);
        adultSpinner9.setAdapter(dataAdapter);
    }//End of adultSpinners method

    //invoked when user taps GST details
    public void makeGstVisible(View view)
    {
        if (status == 0) {
            gstLinearLayout.setVisibility(View.VISIBLE);
            status = 1;
        } else {
            gstLinearLayout.setVisibility(View.GONE);
            status = 0;
        }
    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), FarerulesActivity.class);
        startActivityForResult(myIntent, 0);
        return true;

    }
    public void applyForCoupon(View view) {

        String value;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //Log.i(TAG, "Inside applyForCoupon method");
        String URL = "https://www.farehawker.com/api/coupon_code.php?coupon_code=" + couponCode.getText();
        JSONObject jsonObject = new JSONObject();
// prepare the Request

        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, URL,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.d("my_res", response.toString());

                        String coupon_res = response.toString();
                        try {
                            //Log.i(TAG, "Inside on Response");
                            //Log.i(TAG, response.get("value").toString());
                            int my_amount = Integer.parseInt(response.get("value").toString());
                            Log.i("my_amount", String.valueOf(my_amount));
                            String value = response.get("value").toString();
                            //value is discount amount from Total fare
                            //Suppose value is equals to 9
                            //Total fare is 100
                            //Then fare after discount is =total-value;
                            //  int amount = Integer.parseInt(TotalFare.getText().toString());

                            if (response.get("value").toString() == null) {
                                Log.i("Response1073", response.get("value").toString());
                                Toast.makeText(PassengerDetailsR.this, "invalid coupon", Toast.LENGTH_SHORT).show();

                            } else {
                                if (couponValidity == 1) {
                                    String str=TotalFare.getText().toString();

                                    TotalFare.setText("₹"+String.valueOf(Integer.parseInt(TotalFare.getText().toString().substring(1)) - my_amount));
                                    //set couponValidity to zero.Since Coupon has been used once it not valid now
                                    couponValidity = 0;
                                    //Toast.makeText(PassengerDetailsR.this, "Coupon Code is valid for once", Toast.LENGTH_SHORT);
                                    Log.d("my_minus", String.valueOf(TotalFare));
                                } else {
                                    Toast.makeText(PassengerDetailsR.this, "You have already used this coupon!", Toast.LENGTH_LONG).show();
                                }
                            }
                        } catch (JSONException je) {
                          //  Log.i(TAG, je.toString());
                        }
                        // check the Response Code

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               // Log.i(TAG, error.toString());
                Toast.makeText(PassengerDetailsR.this, "Invalid Coupon Code", Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonRequest);
    }//End of method applyForCoupon

}//End of PassengerDetailsR