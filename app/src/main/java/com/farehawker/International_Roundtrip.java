package com.farehawker;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.sip.SipSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
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
import com.farehawker.Model.RoundtripModelclass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class International_Roundtrip extends AppCompatActivity
{
    List<RoundtripModelclass> roundtripModelclassList=new ArrayList<RoundtripModelclass>();
    RecyclerView recyclerView;
    ProgressDialog progressDialog;
    String traceId;
    String TAG="International_Roundtrip";
    Intent intent;
    String endUserIp="216.10.251.69";
    String URL="http://api.tektravels.com/BookingEngineService_Air/AirService.svc/rest/Search/";
    String TokenId="ad40ebb1-585a-4f3f-a9ba-a3f14b744dfc";
    String adultCount="1";
    String childCount="0";
    String infantCount="0";
    String countryTo,countryFrom,origin,destination,departureDate,returnDate,cabinClass;
    String noOfSeatsAvailable;
    boolean directFlight=false;
    boolean oneStopFlight=false;
    int journeyType;
    Double publishedFare;
    String airlineCode;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_international__roundtrip);

        intent =getIntent();
        countryTo=intent.getStringExtra("countryTo");
        countryFrom=intent.getStringExtra("countryFrom");
        origin=intent.getStringExtra("originround");
        destination=intent.getStringExtra("destinationround");
        departureDate=intent.getStringExtra("departureround");
        returnDate=intent.getStringExtra("returnround");
        adultCount=intent.getStringExtra("adultround");
        childCount=intent.getStringExtra("childround");
        infantCount=intent.getStringExtra("infantsround");
        cabinClass=intent.getStringExtra("cabinclass");
        if(countryFrom==null)
        {
            countryFrom="India";
        }
        sendRequest();
    }//End of onCreate method
    public void sendRequest()
    {
        try
        {
            /*
            * {"EndUserIp":"216.10.251.69","TokenId":"51e12095-4692-40fe-9540-fc5ebe621008","AdultCount":"1","ChildCount":"0","InfantCount":"0","DirectFlight":"false","OneStopFlight":"false","JourneyType":"1","Segments":[{"Origin":"DEL","Destination":"DXB","FlightCabinClass":"1","PreferredDepartureTime":"2018-08-22T00:00:00"}]}*/
            /*{"EndUserIp":"216.10.251.69","TokenId":"ad40ebb1-585a-4f3f-a9ba-a3f14b744dfc","AdultCount":"1","ChildCount":"0","InfantCount":"0","IsDomestic":"false","DirectFlight":"false","OneStopFlight":"false","JourneyType":"2","Segments":[{"Origin":"DEL","Destination":"DXB","FlightCabinClass":"1","PreferredArrivalTime":"2018-09-04T00:00:00","PreferredDepartureTime":"2018-09-04T00:00:00"},{"Origin":"DXB","Destination":"DEL","FlightCabinClass":"1","PreferredDepartureTime":"2018-09-05T00:00:00","PreferredArrivalTime":"2018-09-05T00:00:00"}]}*/
            RequestQueue requestQueue= Volley.newRequestQueue(this);
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("AdultCount",adultCount);
            jsonObject.put("ChildCount",childCount);
            jsonObject.put("InfantCount",infantCount);
            jsonObject.put("isDomestic",false);
            jsonObject.put("DirectFlight",directFlight);
            jsonObject.put("OneStopFlight",oneStopFlight);
            /*
            JourneyType
            JourneyType
            One way 1
            return 2
            multi stop 3
            Advance search 4
            Special return 5
             */
            jsonObject.put("JourneyType",2);
            jsonObject.put("EndUserIp","216.10.251.69");
            jsonObject.put("TokenId",TokenId);
            jsonObject.put("PreferredAirlines",JSONObject.NULL);
            final JSONArray jsonArray =new JSONArray();
            JSONObject jsonObject1= new JSONObject();
            jsonObject1.put("Origin",origin);
            jsonObject1.put("Destination",destination);
            jsonObject1.put("FlightCabinClass",cabinClass);
            jsonObject1.put("PreferredArrivalTime",departureDate+"T00:00:00");
            jsonObject1.put("PreferredDepartureTime",departureDate+"T00:00:00");
            JSONObject jsonObject2=new JSONObject();
            jsonObject2.put("Origin",destination);
            jsonObject2.put("Destination",origin);
            jsonObject2.put("FlightCabinClass",cabinClass);
            jsonObject2.put("PreferredArrivalTime",returnDate+"T00:00:00");
            jsonObject2.put("PreferredDepartureTime",returnDate+"T00:00:00");

            jsonArray.put(jsonObject1);
            jsonArray.put(jsonObject2);

            jsonObject.put("Segments",jsonArray);
            jsonObject.put("Sources",JSONObject.NULL);
            progressDialog=new ProgressDialog(this);
            progressDialog.setMessage("Loading please wait...");
            progressDialog.show();

            Log.i("Object",jsonObject.toString());

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL, jsonObject, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        response.toString();
                        progressDialog.dismiss();
                        JSONObject jsonObject2= new JSONObject();
                        JSONArray jsonArray1= new JSONArray();
                        jsonObject2=response.getJSONObject("Response");

                        Log.i(TAG,response.toString());
                        traceId=jsonObject2.getString("TraceId");

                        jsonArray1=jsonObject2.getJSONArray("Results");
                        Log.i(TAG,jsonArray1.toString());
                        Log.i("0",jsonArray1.getJSONArray(0).toString());
                        JSONArray jsonArray2=jsonArray1.getJSONArray(0);

                        for(int i=0;i<jsonArray2.length();i++)
                        {
                            RoundtripModelclass roundtripModelclass= new RoundtripModelclass();
                            JSONObject jsonObject3 = new JSONObject();
                            jsonObject3=jsonArray2.getJSONObject(i);
                            roundtripModelclass.setResultindex_oneward(jsonObject3.getString("ResultIndex"));
                            JSONObject jsonObject4=jsonObject3.getJSONObject("Fare");
                            roundtripModelclass.setPriceneway(jsonObject4.getString("PublishedFare"));
                            JSONArray jsonArray3 = new JSONArray();
                            jsonArray3=jsonObject3.getJSONArray("Segments");
                            //This json array(Segment[0])  Contains origin to destination
                            JSONArray jsonArray4=jsonArray3.getJSONArray(0);

                            JSONObject jsonObject5 =new JSONObject();
                            jsonObject5=jsonArray4.getJSONObject(0);
                            JSONObject jsonObject6=jsonObject5.getJSONObject("Airline");
                            roundtripModelclass.setCodeneway(jsonObject6.getString("AirlineCode"));
                            roundtripModelclass.setFlightnameneway(jsonObject6.getString("AirlineName"));

                            roundtripModelclass.setSeatsleftneway(jsonObject5.getString("NoOfSeatAvailable"));
                            roundtripModelclass.setDiparturetimeneway();
                            jsonArray4.getJSONObject(1);

                            //This json array(Segment[1]) contains destination to origin
                            JSONArray jsonArray5=jsonArray3.getJSONArray(1);

                        }//End of for loop



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
