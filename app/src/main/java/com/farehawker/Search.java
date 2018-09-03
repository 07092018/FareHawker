package com.farehawker;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class Search extends AppCompatActivity
{
    String TAG="Search";
    String URL="http://api.tektravels.com/BookingEngineService_Air/AirService.svc/rest/Search/";
    JSONArray jsonArray;
    JSONObject jsonObject;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState)
    {
        super.onCreate(savedInstanceState, persistentState);
        sendRequest();

    }
    public void sendRequest()
    {
        try {
            final RequestQueue requestQueue =  Volley.newRequestQueue(this);
            //Flight Details json Object
            JSONObject jsonObject = new JSONObject();
            /*
            * {"EndUserIp":"216.10.251.69","TokenId":"66e75448-03bc-4c96-8966-2d01d37fc43b","AdultCount":"1","ChildCount":0,"InfantCount":0,"DirectFlight":"false","OneStopFlight":"false","JourneyType":"1","PreferredAirlines":null,"Segments":[{"Origin":"DEL","Destination":"VNS","FlightCabinClass":"2","PreferredDepartureTime":"2018-08-08T00:00:00"}]}    */
            JSONArray jsonArray=new JSONArray();
            jsonObject.put("Origin", "DEL");
            jsonObject.put("Destination", "VNS");
            jsonObject.put("FlightCabinClass","2");
            jsonObject.put("PreferredDepartureTime","2018-08-10T00:00:00");
            //put this object in JSON array
            jsonArray.put(jsonObject);
            //Second Object
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("EndUserIp","216.10.251.69");
            jsonObject1.put("TokenId","5fb88b65-91ef-4566-a9c8-1556e54e009d");
            jsonObject1.put("AdultCount","1");
            jsonObject1.put("ChildCount","0");
            jsonObject1.put("InfantCount","0");
            jsonObject1.put("DirectFlight","false");
            jsonObject1.put("OneStopFlight","false");
            jsonObject1.put("JourneyType","1");
            jsonObject1.put("PreferredAirlines","null");
            jsonObject1.put("Segments",jsonArray);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL, jsonObject1, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response)
                {
                    Log.i(TAG,response.toString());
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Log.i(TAG,"Inside onErrorResponse method");
                }
            });
        }
        catch(Exception e)
        {

        }
    }
}
