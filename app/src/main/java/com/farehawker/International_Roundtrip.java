package com.farehawker;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.sip.SipSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;

public class International_Roundtrip extends AppCompatActivity
{
    ProgressDialog progressDialog;
    String traceId;
    String TAG="International_Roundtrip";
    Intent intent;
    String endUserIp="216.10.251.69";
    String URL="http://api.tektravels.com/BookingEngineService_Air/AirService.svc/rest/Search/";
    String TokenId="872c1e32-b2c1-4154-8151-a9544650ba9e";
    String adultCount="1";
    String childCount="0";
    String infantCount="0";
    String noOfSeatsAvailable;
    boolean directFlight=false;
    boolean oneStopFlight=false;

    int journeyType=1;
    Double publishedFare;
    String airlineCode;
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
            /*
            * {"EndUserIp":"216.10.251.69","TokenId":"51e12095-4692-40fe-9540-fc5ebe621008","AdultCount":"1","ChildCount":"0","InfantCount":"0","DirectFlight":"false","OneStopFlight":"false","JourneyType":"1","Segments":[{"Origin":"DEL","Destination":"DXB","FlightCabinClass":"1","PreferredDepartureTime":"2018-08-22T00:00:00"}]}*/
            RequestQueue requestQueue= Volley.newRequestQueue(this);
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("EndUserIp","216.10.251.69");
            jsonObject.put("TokenId",TokenId);
            jsonObject.put("AdultCount",adultCount);
            jsonObject.put("ChildCount",childCount);
            jsonObject.put("InfantCount",infantCount);
            jsonObject.put("DirectFlight",directFlight);
            jsonObject.put("OneStopFlight",oneStopFlight);
            jsonObject.put("JourneyType",journeyType);
            final JSONArray jsonArray =new JSONArray();
            JSONObject jsonObject1= new JSONObject();
            jsonObject1.put("Origin","DEL");
            jsonObject1.put("Destination","DXB");
            jsonObject1.put("FlightCabinClass",1);
            jsonObject1.put("PreferredDepartureTime","2018-08-22T00:00:00");
            jsonArray.put(jsonObject1);
            jsonObject.put("Segments",jsonArray);

            progressDialog=new ProgressDialog(this);
            progressDialog.setMessage("Loading please wait...");
            progressDialog.show();
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL, jsonObject, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        response.toString();
                        progressDialog.dismiss();
                        JSONObject jsonObject2= new JSONObject();

                        JSONArray jsonArray1= new JSONArray();
                        jsonObject2=response.getJSONObject("Response");
                        traceId=jsonObject2.getString("TraceId");
                        jsonArray1=jsonObject2.getJSONArray("Results");
                        Log.i(TAG,jsonArray1.toString());

                        Log.i("0",jsonArray1.getJSONArray(0).toString());
                        JSONArray jsonArray2=jsonArray1.getJSONArray(0);
                        for(int i=0;i<jsonArray2.length();i++)
                        {
                            JSONObject jsonObject3 = new JSONObject();
                            jsonObject3=jsonArray2.getJSONObject(i);
                            JSONArray jsonArray3 = new JSONArray();
                            JSONObject jsonObject4 = new JSONObject();
                            jsonObject4=jsonObject3.getJSONObject("Fare");
                            publishedFare=Double.parseDouble(jsonObject3.get("PublishedFare").toString());
                            JSONArray segment=jsonObject3.getJSONArray("Segments");
                            JSONArray subArray=segment.getJSONArray(0);
                            JSONObject jsonObject5=new JSONObject();
                            jsonObject5=subArray.getJSONObject(0);
                            if(jsonObject5.has("NoOfSeatsAvailable"))
                            {
                                noOfSeatsAvailable=jsonObject5.get("NoOfSeatsAvailable").toString();
                                Log.i("Seats",noOfSeatsAvailable);
                            }
                            else
                            {

                            }

                            Log.i("AirlineCode",jsonObject3.get("AirlineCode").toString());
                        }


                    } catch (Exception e)
                    {
                        Toast.makeText(International_Roundtrip.this,"on line 90",Toast.LENGTH_LONG);
                        }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.i("International_Roundtrip",error.toString());
                    Toast.makeText(International_Roundtrip.this,"onErrorResponse",Toast.LENGTH_LONG);

                }
            })
            {
                @Override
                public String getBodyContentType()
                {
                    return "application/json; charset=utf-8";
                }
            };
            int socketTimeOut=900000;
            RetryPolicy policy = new DefaultRetryPolicy(socketTimeOut,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            jsonObjectRequest.setRetryPolicy(policy);
            requestQueue.add(jsonObjectRequest);
        }
        catch(Exception e)
        {

        }
    }
}
