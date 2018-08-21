package com.farehawker;

import android.content.Intent;
import android.net.sip.SipSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;

public class International_Roundtrip extends AppCompatActivity
{
    Intent intent;
    String endUserIp="216.10.251.69";
    String URL="http://api.tektravels.com/BookingEngineService_Air/AirService.svc/rest/Search/";
    String TokenId="dea00526-a6b8-497d-bddc-f6ae12c56e2c";
    String adultCount;
    String childCount;
    String infantCount;
    boolean directFlight=false;
    boolean oneStopFlight=false;
    int   journeyType=1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_international__roundtrip);

        intent=getIntent();
        intent.getStringExtra("origin");
        intent.getStringExtra("destination");
        intent.getStringExtra("adultCount");
        intent.getStringExtra("childCount");
        intent.getStringExtra("infantCount");
        intent.getStringExtra("departureDate");
        intent.getStringExtra("returnDate");
        intent.getStringExtra("cabinClass");
        sendRequest();

    }
    public void sendRequest()
    {
        try
        {
            RequestQueue requestQueue= Volley.newRequestQueue(this);
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("EndUserIp",endUserIp);
            jsonObject.put("TokenId",TokenId);
            jsonObject.put("AdultCount",adultCount);
            jsonObject.put("ChildCount",childCount);
            jsonObject.put("InfantCount",infantCount);
            jsonObject.put("DirectFlight",directFlight);
            jsonObject.put("OneStopFlight",oneStopFlight);
            jsonObject.put("JourneyType",journeyType);
            JSONArray jsonArray =new JSONArray();
            JSONObject jsonObject1= new JSONObject();
            jsonObject1.put("Origin","DEL");
            jsonObject1.put("Destionation","DXB");
            jsonObject1.put("FlightCabinClass",1);
            jsonObject1.put("PreferedDepartureTime","2018-08-21T00:00:00");
            jsonArray.put(jsonObject1);
            jsonObject.put("Segments",json)
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, jsonObject, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response)
                {

                }
            });

        }
        catch(Exception e)
        {

        }
    }
}
