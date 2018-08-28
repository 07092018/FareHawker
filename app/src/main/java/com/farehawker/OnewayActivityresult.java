package com.farehawker;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
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
import com.farehawker.Adaptors.OnewayAdaptor;
import com.farehawker.Model.OnewayModelClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class OnewayActivityresult extends AppCompatActivity implements ClickListener
{
    String airlineCode,countryFrom,countryTo;;
    String TAG ="OnewayActivityresult";
    private RecyclerView mRecyclerView;
    private OnewayAdaptor mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    List<OnewayModelClass> mDataset;
    TextView text_ocode,text_dcode;
    Spinner spfiltr;
    String item;
    String EndUserIp="216.10.251.69";
    String TokenId="304f22f8-0d39-4aee-926a-c780159b3639";
    String traceid;
    String originacc_one,destinationacc_one,adultacc_one,childacc_one,infantacc_one,cabinacc_one,depdateacc_one,returndateacc_one;
    public static final String JSON_URL = "http://api.tektravels.com/BookingEngineService_Air/AirService.svc/rest/Search/";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oneway_activityresult);
        text_ocode=(TextView)findViewById(R.id.origincodeo);
        text_dcode=(TextView)findViewById(R.id.destcodeo);
        spfiltr=(Spinner)findViewById(R.id.onewayspinner);
        List<String> onewatcate = new ArrayList<String>();
        onewatcate.add("Filter");
        onewatcate.add("Departure");
        onewatcate.add("Stop");
        onewatcate.add("Airlines");
        //Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, onewatcate);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spfiltr.setAdapter(dataAdapter);
        // Spinner Drop down elements
        spfiltr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item = parent.getItemAtPosition(position).toString();
                if (item.equals("Filter")) {
                    Toast.makeText(parent.getContext(), "Selected: " + item , Toast.LENGTH_SHORT).show();

                } else if (item.equals("Departure")) {
                    Toast.makeText(parent.getContext(), "Selected: " + item , Toast.LENGTH_SHORT).show();
                } else if (item.equals("Stop")) {
                    Toast.makeText(parent.getContext(), "Selected: " + item , Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(parent.getContext(), "Selected: " + item , Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerviewlist_onewway);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mDataset = new ArrayList<>();
        sendRequest();

        //get the data from bundle
        Intent intent= getIntent();
        originacc_one = intent.getStringExtra("origin");
        destinationacc_one = intent.getStringExtra("destination");
        adultacc_one = intent.getStringExtra("adult");
        childacc_one = intent.getStringExtra("child");
        infantacc_one = intent.getStringExtra("infants");
        cabinacc_one = intent.getStringExtra("cabinclass");
        depdateacc_one = intent.getStringExtra("departure");

        countryFrom=intent.getStringExtra("countryFrom");
        countryTo=intent.getStringExtra("countryTo");

        text_ocode.setText(String.valueOf(originacc_one));
        text_dcode.setText(String.valueOf(destinationacc_one));
        Toast.makeText(OnewayActivityresult.this, "mag" + originacc_one+"\n" + destinationacc_one+"\n" + adultacc_one +"\n"+ childacc_one+"\n" + infantacc_one+"\n" + cabinacc_one+"\n" + depdateacc_one +"\n"+ returndateacc_one, Toast.LENGTH_LONG).show();
    }//End of onCreate method

    private void sendRequest()
    {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading please wait ...");
        progressDialog.show();
        try
        {
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            //start bottom
            JSONObject objsagment = new JSONObject();

            Intent intent= getIntent();
            String aa = intent.getStringExtra("origin");
            String bb = intent.getStringExtra("destination");
            String ad = intent.getStringExtra("adult");
            String ch = intent.getStringExtra("child");
            String inf = intent.getStringExtra("infants");
            String cabin = intent.getStringExtra("cabinclass");

            String depart = intent.getStringExtra("departure")+"T00:00:00";
            objsagment.put("Origin",String.valueOf(aa));
            objsagment.put("Destination",String.valueOf(bb));
            objsagment.put("FlightCabinClass",cabin);
            objsagment.put("PreferredDepartureTime",String.valueOf(depart));
            //bottom array
            JSONArray Arraysagment = new JSONArray();
            Arraysagment.put(objsagment);
            //first object
            JSONObject jsonobjectt = new JSONObject();
            jsonobjectt.put("EndUserIp", "216.10.251.69");
            jsonobjectt.put("TokenId","304f22f8-0d39-4aee-926a-c780159b3639");
            jsonobjectt.put("AdultCount", String.valueOf(ad));
            jsonobjectt.put("ChildCount", String.valueOf(ch));
            jsonobjectt.put("InfantCount", String.valueOf(inf));
            jsonobjectt.put("DirectFlight", "false");
            jsonobjectt.put("OneStopFlight", "false");
            jsonobjectt.put("JourneyType", "1");
            jsonobjectt.put("PreferredAirlines", null);
            jsonobjectt.put("Segments", Arraysagment);
            final String mRequestBody = jsonobjectt.toString();
            Log.wtf("bodylog",mRequestBody);
            JsonObjectRequest jsonobjectreq = new JsonObjectRequest(Request.Method.POST, JSON_URL,jsonobjectt,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                Log.i(TAG,"Line 164");
                                Log.i("LOG_VOLLEY164", response.toString());
                                JSONObject firstobjs = response.getJSONObject("Response");
                                Log.i("response166",firstobjs.toString());
                                traceid=firstobjs.getString("TraceId");
                                JSONArray resultarray = firstobjs.getJSONArray("Results");
                                JSONArray resulsetarray = resultarray.getJSONArray(0);
                                Log.i(TAG,resulsetarray.toString());
                                for (int i = 0; i < resulsetarray.length(); i++)
                                {
                                    OnewayModelClass onewayset = new OnewayModelClass();
                                    JSONObject jobjet = resulsetarray.getJSONObject(i);
                                    onewayset.setResultindex(jobjet.getString("ResultIndex"));
                                    JSONObject fares = jobjet.getJSONObject("Fare");
                                    Double dfare = Double.valueOf(fares.getString("PublishedFare"));
                                    //round fare after decimal
                                    String finalfare = String.format("%.0f", dfare);
                                    // Log.wtf("faress",finalfare);
                                    onewayset.setPrice(finalfare);
                                    JSONArray sagmentarray = jobjet.getJSONArray("Segments");
                                    JSONArray sagmentsubarray = sagmentarray.getJSONArray(0);
                                    if (sagmentsubarray.length() == 2) {
                                        onewayset.setNumstop("1");
                                        JSONObject sagment1 = sagmentsubarray.getJSONObject(1);
                                        JSONObject destinationobj1 = sagment1.getJSONObject("Destination");
                                        String splitarive1 = destinationobj1.getString("ArrTime");
                                        String[] textslitarivtim1 = splitarive1.split("T");
                                        String newsplitarriv1 = textslitarivtim1[0];
                                        String newsplitarriv11 = textslitarivtim1[1];
                                        String one_text1 = newsplitarriv11;
                                        String sub_one1 = one_text1.substring(0, newsplitarriv11.length() - 3);
                                        //this is wrong because i made mistake in xml
                                        onewayset.setDeparturetime(sub_one1);
                                    } else if (sagmentsubarray.length() == 3) {
                                        onewayset.setNumstop("2");
                                        JSONObject sagment2 = sagmentsubarray.getJSONObject(2);
                                        JSONObject destinationobj2 = sagment2.getJSONObject("Destination");
                                        String splitarive2 = destinationobj2.getString("ArrTime");
                                        String[] textslitarivtim2 = splitarive2.split("T");
                                        String newsplitarriv2 = textslitarivtim2[0];
                                        String newsplitarriv21 = textslitarivtim2[1];
                                        String one_text21 = newsplitarriv21;
                                        String sub_one21 = one_text21.substring(0, newsplitarriv21.length() - 3);
                                        //this is wrong because i made mistake in xml
                                        onewayset.setDeparturetime(sub_one21);
                                    } else if (sagmentsubarray.length() == 4) {
                                        onewayset.setNumstop("3");
                                        JSONObject sagment3 = sagmentsubarray.getJSONObject(3);
                                        JSONObject destinationobj3 = sagment3.getJSONObject("Destination");
                                        //value for stop
                                        String splitarive3 = destinationobj3.getString("ArrTime");
                                        String[] textslitarivtim3 = splitarive3.split("T");
                                        String newsplitarriv3 = textslitarivtim3[0];
                                        String newsplitarriv31 = textslitarivtim3[1];
                                        String one_text3 = newsplitarriv31;
                                        String sub_one3 = one_text3.substring(0, newsplitarriv31.length() - 3);
                                        //this is wrong because i made mistake in xml
                                        onewayset.setDeparturetime(sub_one3);
                                    } else {
                                        onewayset.setNumstop("0");
                                        JSONObject sagment0 = sagmentsubarray.getJSONObject(0);
                                        JSONObject destinationobj0 = sagment0.getJSONObject("Destination");
                                        String splitarive0 = destinationobj0.getString("ArrTime");
                                        String[] textslitarivtim0 = splitarive0.split("T");
                                        String newsplitarriv0 = textslitarivtim0[0];
                                        String newsplitarriv00 = textslitarivtim0[1];
                                        String one_text0 = newsplitarriv00;
                                        String sub_one0 = one_text0.substring(0, newsplitarriv00.length() - 3);
                                        //this is wrong because i made mistake in xml
                                        onewayset.setDeparturetime(sub_one0);
                                    }
                                    JSONObject sagmentobj = sagmentsubarray.getJSONObject(0);
                                    if (sagmentobj.has("NoOfSeatAvailable")) {
                                        onewayset.setSeatavalble(sagmentobj.getString("NoOfSeatAvailable"));
                                    } else {
                                        onewayset.setSeatavalble(" ");
                                    }
                                    // onewayset.setNumstop(sagmentobj.getString("StopPoint"));
                                    JSONObject airlineobje = sagmentobj.getJSONObject("Airline");
                                    onewayset.setAirlinename(airlineobje.getString("AirlineName"));
                                    onewayset.setFlightcode(airlineobje.getString("AirlineCode"));
                                    airlineCode=airlineobje.getString("AirlineCode");
                                    Log.i("airlineCode",airlineCode);
                                    onewayset.setFlightnumber(airlineobje.getString("FlightNumber"));
                                    JSONObject originobject = sagmentobj.getJSONObject("Origin");
                                    //JSONObject destinationobj = sagmentobj.getJSONObject("Destination");
                                    //split the value
                                    String splitdest = originobject.getString("DepTime");
                                    String[] textslitdest = splitdest.split("T");
                                    String newsplitdest1 = textslitdest[0];
                                    String newsplitdest2 = textslitdest[1];
                                    //for substring
                                    String one_text = newsplitdest2;
                                    String sub_one = one_text.substring(0, newsplitdest2.length() - 3);
                                    //this is wrong because i made mistake in xml
                                    onewayset.setArrivingtime(sub_one);
                                    mDataset.add(onewayset);
                                    Log.wtf("printlog", onewayset.toString());
                                    progressDialog.dismiss();

                                }
                            } catch (JSONException e)
                            {
                                e.printStackTrace();
                            }
                            mAdapter = new OnewayAdaptor(OnewayActivityresult.this, mDataset);
                            mRecyclerView.setAdapter(mAdapter);
                            mAdapter.setClickListener(OnewayActivityresult.this);
                            mAdapter.notifyDataSetChanged();
                            progressDialog.dismiss();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            progressDialog.dismiss();
                        }
                    }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }
            };
            int socketTimeout = 50000; // 30 seconds. You can change it
            RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,

                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            jsonobjectreq.setRetryPolicy(policy);
            requestQueue.add(jsonobjectreq);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void itemClicked(View view, int position) {
        OnewayModelClass onewaymodel=(OnewayModelClass) mAdapter.getItem(position);
        String resultindex=onewaymodel.getResultindex();
        Toast.makeText(getApplicationContext(),"color chenge"+resultindex,Toast.LENGTH_SHORT).show();
        Intent in=new Intent(OnewayActivityresult.this,OnewayFareruleaActivity.class);
         in.putExtra("airlineCode",airlineCode);
         in.putExtra("enduserip",EndUserIp);
         in.putExtra("tokenid",TokenId);
         in.putExtra("resultindex",resultindex);
         in.putExtra("traceid",traceid);
         in.putExtra("adultone",adultacc_one);
         in.putExtra("childone",childacc_one);
         in.putExtra("infantsone",infantacc_one);
         in.putExtra("flightName",onewaymodel.getAirlinename());
         in.putExtra("flightPrice",onewaymodel.getPrice());
         in.putExtra("flightDepartureTime",onewaymodel.getDeparturetime());
         in.putExtra("arrivalTime",onewaymodel.getArrivingtime());
         in.putExtra("flightCode",onewaymodel.getFlightcode());
         String f=onewaymodel.getFlightcode();
         in.putExtra("origin",originacc_one);
         in.putExtra("destination",destinationacc_one);

         in.putExtra("countryTo",countryTo);
         in.putExtra("countryFrom",countryFrom);

        startActivity(in);
    }
}