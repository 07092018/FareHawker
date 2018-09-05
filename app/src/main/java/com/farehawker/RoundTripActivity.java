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
import android.widget.LinearLayout;
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
import com.farehawker.Adaptors.RoundtripOriginAdaptor;
import com.farehawker.Adaptors.RoundtripReturnAdaptor;
import com.farehawker.Model.RoundtripModelclass;
import com.farehawker.Model.RoundtripreturnModelclass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RoundTripActivity extends AppCompatActivity implements ClickListener, LeftclickI
{
    int flightImage;

    String flightCode;
    String flightName;
    String flightNumber;
    String flightSeatLeft;
    String flightDepartureTime;
    String flightPrice;
    String flightArrivalTime;
    String flightCodeR;
    String flightNameR;
    String flightNumberR;
    String flightSeatLeftR;
    String flightDepartureTimeR;
    String flightPriceR;
    String flightArrivalTimeR;
    Intent intent;
    String TAG = "RoundTripActivity";
    Spinner onward_spin, return_spin;
    private List<RoundtripModelclass> roundleftlist;
    private List<RoundtripreturnModelclass> roundrightlist;
    private RecyclerView recyclerViewleft, recyclerViewright;
    private RoundtripOriginAdaptor leftadaptor;
    private RoundtripReturnAdaptor rightadaptor;
    String items, itemsr;
    int priceid = 0;
    int finalprice = 0;
    String result_oneward, resutlt_retunr;
    String traceid;
    TextView text_price;
    LinearLayout Linvisible;
    TextView Book_btn;
    String EndUserIp_Round = "216.10.251.69";
    String TokenId_Round = "f7f8c9ce-1f9a-4367-9e87-9b67bc30005e";
    String originacc, destinationacc, adultacc, childacc, infantacc, cabinacc, depdateacc, returndateacc;
    String urlJsonroundtrip = "http://api.tektravels.com/BookingEngineService_Air/AirService.svc/rest/Search/";
    private int flightImageR;
    String countryTo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_trip);
        text_price = (TextView) findViewById(R.id.price_text);
        Book_btn = (TextView) findViewById(R.id.book_btn);
        Book_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent in = new Intent(RoundTripActivity.this, FarerulesActivity.class);

                in.putExtra("adultR", adultacc);
                in.putExtra("childR", childacc);
                in.putExtra("infantR", infantacc);
                in.putExtra("result_oneward", result_oneward);
                in.putExtra("result_return", resutlt_retunr);
                in.putExtra("traceid", traceid);
                in.putExtra("enduserip_round", EndUserIp_Round);
                in.putExtra("tokenid_round", TokenId_Round);
                in.putExtra("depart", depdateacc);

                in.putExtra("originround", originacc);
                in.putExtra("destinationround", destinationacc);
                in.putExtra("cabinclass", cabinacc);
                in.putExtra("departureround", depdateacc);
                in.putExtra("returnround", returndateacc);
                //First FLight Details
                in.putExtra("flightPrice",flightPrice);
                in.putExtra("flightDepartureTime",flightDepartureTime);
                in.putExtra("flightArrivalTime",flightArrivalTime);
                in.putExtra("flightCode",flightCode);
                in.putExtra("flightName",flightName);
                in.putExtra("flightNumber",flightNumber);

                //Return FLight Details
                in.putExtra("flightPriceR",flightPriceR);
                in.putExtra("flightDepartureTimeR",flightDepartureTimeR);
                in.putExtra("flightArrivalTimeR",flightArrivalTimeR);
                in.putExtra("flightCodeR",flightCodeR);
                in.putExtra("flightNameR",flightNameR);
                in.putExtra("flightNumberR",flightNumberR);
                in.putExtra("countryTo",countryTo);


                startActivity(in);
            }
        });
        Linvisible = (LinearLayout) findViewById(R.id.invisible_layout);

        recyclerViewleft = (RecyclerView) findViewById(R.id.recyclerview_roundtriporigin);
        RecyclerView.LayoutManager leftLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewleft.setLayoutManager(leftLayoutManager);
        roundleftlist = new ArrayList<>();
        roundrightlist = new ArrayList<>();
        recyclerViewright = (RecyclerView) findViewById(R.id.recyclerview_roundtripreturn);
        RecyclerView.LayoutManager rightLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewright.setLayoutManager(rightLayoutManager);

        //get the data from bundle
        Intent intent = getIntent();
        originacc = intent.getStringExtra("originround");
        destinationacc = intent.getStringExtra("destinationround");
        adultacc = intent.getStringExtra("adultround");
        childacc = intent.getStringExtra("childround");
        infantacc = intent.getStringExtra("infantsround");
        cabinacc = intent.getStringExtra("cabinclass");
        depdateacc = intent.getStringExtra("departureround");
        returndateacc = intent.getStringExtra("returnround");
        countryTo=intent.getStringExtra("countryTo");

        makeJsonObjectRequest();
        onward_spin = (Spinner) findViewById(R.id.originfilter);
        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Filter");
        categories.add("Departure");
        categories.add("Stop");
        categories.add("Airlines");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        onward_spin.setAdapter(dataAdapter);
        onward_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                items = parent.getItemAtPosition(position).toString();
                if (items.equals("Filter")) {
                    Toast.makeText(parent.getContext(), "Selected: " + items, Toast.LENGTH_SHORT).show();

                } else if (items.equals("Departure")) {
                    Toast.makeText(parent.getContext(), "Selected: " + items, Toast.LENGTH_SHORT).show();
                } else if (items.equals("Stop")) {
                    Toast.makeText(parent.getContext(), "Selected: " + items, Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(parent.getContext(), "Selected: " + items, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        return_spin = (Spinner) findViewById(R.id.returnfilter);
        List<String> categoriesreturn = new ArrayList<String>();
        categoriesreturn.add("Filter");
        categoriesreturn.add("Departure");
        categoriesreturn.add("Stop");
        categoriesreturn.add("Airlines");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapterreturn = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categoriesreturn);
        // Drop down layout style - list view with radio button
        dataAdapterreturn.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        return_spin.setAdapter(dataAdapterreturn);
        return_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemsr = parent.getItemAtPosition(position).toString();
                if (itemsr.equals("Filter")) {
                    Toast.makeText(parent.getContext(), "Selected: " + itemsr, Toast.LENGTH_SHORT).show();

                } else if (itemsr.equals("Departure")) {
                    Toast.makeText(parent.getContext(), "Selected: " + itemsr, Toast.LENGTH_SHORT).show();
                } else if (itemsr.equals("Stop")) {
                    Toast.makeText(parent.getContext(), "Selected: " + itemsr, Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(parent.getContext(), "Selected: " + itemsr, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        Toast.makeText(RoundTripActivity.this, "mag" + originacc + "\n" + destinationacc + "\n" + adultacc + "\n" + childacc + "\n" + infantacc + "\n" + cabinacc + "\n" + depdateacc + "\n" + returndateacc, Toast.LENGTH_LONG).show();
    }

    private void makeJsonObjectRequest() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading please wait ...");
        progressDialog.show();
        try {
            RequestQueue requestQueue = Volley.newRequestQueue(this);

            //Start bottom
            JSONObject objsagment = new JSONObject();
            objsagment.put("Origin", originacc);
            objsagment.put("Destination", destinationacc);
            objsagment.put("FlightCabinClass", cabinacc);
            objsagment.put("PreferredArrivalTime", depdateacc + "T00:00:00");
            objsagment.put("PreferredDepartureTime", depdateacc + "T00:00:00");
            JSONObject objectsegment2 = new JSONObject();
            objectsegment2.put("Origin", destinationacc);
            objectsegment2.put("Destination", originacc);
            objectsegment2.put("FlightCabinClass", cabinacc);
            objectsegment2.put("PreferredDepartureTime", returndateacc + "T00:00:00");
            objectsegment2.put("PreferredArrivalTime", returndateacc + "T00:00:00");

            //bottom array
            JSONArray Arraysagment = new JSONArray();
            Arraysagment.put(objsagment);
            Arraysagment.put(objectsegment2);
            //first object
            JSONObject jsonobjectt = new JSONObject();
            jsonobjectt.put("EndUserIp", "216.10.251.69");
            jsonobjectt.put("TokenId", "f7f8c9ce-1f9a-4367-9e87-9b67bc30005e");
            jsonobjectt.put("AdultCount", adultacc);
            jsonobjectt.put("ChildCount", childacc);
            jsonobjectt.put("InfantCount", infantacc);
            jsonobjectt.put("IsDomestic", "false");
            jsonobjectt.put("DirectFlight", "false");
            jsonobjectt.put("OneStopFlight", "false");
            jsonobjectt.put("JourneyType", "2");
            jsonobjectt.put("PreferredAirlines", null);
            jsonobjectt.put("Sources", null);
            jsonobjectt.put("Segments", Arraysagment);
            final String mRequestBody = jsonobjectt.toString();
            Log.wtf("bodyprint", mRequestBody);

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, urlJsonroundtrip, jsonobjectt, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                    Log.i("LOG_VOLLEY", response.toString());
                    try {
                        JSONObject firstobjs = response.getJSONObject("Response");
                        traceid = firstobjs.getString("TraceId");
                        Log.i("traceid273",traceid.toString());
                        JSONArray resultarray = firstobjs.getJSONArray("Results");
                        JSONArray resulsetarray = resultarray.getJSONArray(0);

                        for (int i = 0; i < resulsetarray.length(); i++)
                        {
                            RoundtripModelclass roundset = new RoundtripModelclass();
                            JSONObject jobjet = resulsetarray.getJSONObject(i);
                            Log.i(TAG, jobjet.toString());
                            roundset.setResultindex_oneward(jobjet.getString("ResultIndex"));
                            JSONObject fares = jobjet.getJSONObject("Fare");
                            Double dfare_return = Double.valueOf(fares.getString("PublishedFare"));
                            String finalfare_r = String.format("%.0f", dfare_return);
                            roundset.setPriceneway(finalfare_r);
                            // roundset.setPriceneway(fares.getString("PublishedFare"));
                            JSONArray sagmentarray = jobjet.getJSONArray("Segments");
                            JSONArray sagmentsubarray = sagmentarray.getJSONArray(0);
                            JSONObject sagmentobj = sagmentsubarray.getJSONObject(0);
                            if (sagmentobj.has("NoOfSeatAvailable"))
                            {
                                roundset.setSeatsleftneway(sagmentobj.getString("NoOfSeatAvailable"));
                            }
                            else
                            {
                                roundset.setSeatsleftneway(" ");
                            }
                            roundset.setStopsneway(sagmentobj.getString("StopPoint"));
                            JSONObject airlineobje = sagmentobj.getJSONObject("Airline");
                            roundset.setFlightnameneway(airlineobje.getString("AirlineName"));
                            roundset.setCodeneway(airlineobje.getString("AirlineCode"));
                            roundset.setNumberneway(airlineobje.getString("FlightNumber"));
                            JSONObject originobject = sagmentobj.getJSONObject("Origin");
                            JSONObject destinationobj = sagmentobj.getJSONObject("Destination");
                            //Split the value
                            String splitdest = originobject.getString("DepTime");
                            String[] textslitdest = splitdest.split("T");
                            String newsplitdest1 = textslitdest[0];
                            String newsplitdest2 = textslitdest[1];
                            String textdepar = newsplitdest2;
                            String sub_textdepa = textdepar.substring(0, newsplitdest2.length() - 3);
                            //this is wrong because i made mistake in xml
                            roundset.setOrigintimeneway(sub_textdepa);
//                                 // onewayset.setArrivingtime(destinaobj.getString("ArrTime"))
                            // onewayset.setDeparturetime(originobject.getString("DepTime"));
                            String splitarive = destinationobj.getString("ArrTime");
                            String[] textslitarivtim = splitarive.split("T");
                            String newsplitarriv = textslitarivtim[0];
                            String newsplitarriv2 = textslitarivtim[1];
                            //substring value
                            String textsub = newsplitarriv2;
                            String sub_text = textsub.substring(0, newsplitarriv2.length() - 3);

                            //this is wrong because i made mistake in xml
                            roundset.setDiparturetimeneway(sub_text);
                            roundleftlist.add(roundset);
                            Log.wtf("printlog", roundset.toString());
                            progressDialog.dismiss();
                        }
                        JSONArray resulsreturnarray = resultarray.getJSONArray(1);
                        for (int j = 0; j < resulsreturnarray.length(); j++)
                        {
                            RoundtripreturnModelclass listright = new RoundtripreturnModelclass();
                            JSONObject jobjet = resulsreturnarray.getJSONObject(j);
                            listright.setResultindex_return(jobjet.getString("ResultIndex"));
                            JSONObject fares = jobjet.getJSONObject("Fare");
                            Double dfare_origin = Double.valueOf(fares.getString("PublishedFare"));
                            //round fare after decimal
                            String finalfare = String.format("%.0f", dfare_origin);
                            listright.setReturnroundtriponewayprice(finalfare);
                            // listright.setReturnroundtriponewayprice(fares.getString("PublishedFare"));
                            JSONArray sagmentarray = jobjet.getJSONArray("Segments");
                            JSONArray sagmentsubarray = sagmentarray.getJSONArray(0);
                            JSONObject sagmentobj = sagmentsubarray.getJSONObject(0);
                            if (sagmentobj.has("NoOfSeatAvailable")) {
                                listright.setReturnroundtriponewayseatsleft(sagmentobj.getString("NoOfSeatAvailable"));
                            } else {
                                listright.setReturnroundtriponewayseatsleft(" ");
                            }
                            listright.setReturnroundtriponewaynumberofstops(sagmentobj.getString("StopPoint"));
                            JSONObject airlineobje = sagmentobj.getJSONObject("Airline");
                            listright.setReturnflightnamearrive(airlineobje.getString("AirlineName"));
                            listright.setReturnflightcodearrive(airlineobje.getString("AirlineCode"));
                            listright.setReturnflightnumberarrive(airlineobje.getString("FlightNumber"));
                            JSONObject originobject = sagmentobj.getJSONObject("Origin");
                            JSONObject destinationobj = sagmentobj.getJSONObject("Destination");
                            //split the value
                            String splitdest = originobject.getString("DepTime");
                            String[] textslitdest = splitdest.split("T");
                            String newsplitdest1 = textslitdest[0];
                            String newsplitdest2 = textslitdest[1];
                            //substring value
                            String textsubreturn = newsplitdest2;
                            String sub_return = textsubreturn.substring(0, newsplitdest2.length() - 3);
                            listright.setReturnflightonewaytimearrive(sub_return);
//                                  // onewayset.setArrivingtime(destinaobj.getString("ArrTime"))
                            // onewayset.setDeparturetime(originobject.getString("DepTime"));
                            String splitarive = destinationobj.getString("ArrTime");
                            String[] textslitarivtim = splitarive.split("T");
                            String newsplitarriv = textslitarivtim[0];
                            String newsplitarriv_2 = textslitarivtim[1];
                            //for substring
                            String txtsub_return2 = newsplitarriv_2;
                            String sub_return2 = txtsub_return2.substring(0, newsplitarriv_2.length() - 3);
                            //this is wrong because i made mistake in xml
                            listright.setReturnflightonewaydiparturetime(sub_return2);
                            roundrightlist.add(listright);
                            Log.wtf("printlog", listright.toString());
                            progressDialog.dismiss();
                        }
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                    leftadaptor = new RoundtripOriginAdaptor(RoundTripActivity.this, roundleftlist);
                    recyclerViewleft.setAdapter(leftadaptor);
                    leftadaptor.setClickListenleft(RoundTripActivity.this);
                    leftadaptor.notifyDataSetChanged();

                    rightadaptor = new RoundtripReturnAdaptor(RoundTripActivity.this, roundrightlist);
                    recyclerViewright.setAdapter(rightadaptor);
                    rightadaptor.setClickListen(RoundTripActivity.this);
                    rightadaptor.notifyDataSetChanged();
                    progressDialog.dismiss();

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("LOG_VOLLEY", error.toString());
                    progressDialog.dismiss();
                    Toast.makeText(RoundTripActivity.this, "mag" + originacc + "\n" + destinationacc + "\n" + adultacc + "\n" + childacc + "\n" + infantacc + "\n" + cabinacc + "\n" + depdateacc + "\n" + returndateacc, Toast.LENGTH_LONG).show();
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }
            };
            int socketTimeout = 500000; // 30 seconds. You can change it
            RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
            jsonObjectRequest.setRetryPolicy(policy);

            requestQueue.add(jsonObjectRequest);

        } catch (JSONException e)
        {
            e.printStackTrace();
        }
    }
//Right side flights clicked
    @Override
    public void itemClicked(View view, int position) {
        RoundtripreturnModelclass rightmodel = (RoundtripreturnModelclass) rightadaptor.getItem(position);
        Linvisible.setVisibility(View.VISIBLE);
        finalprice = Integer.parseInt(rightmodel.getReturnroundtriponewayprice());
        resutlt_retunr = rightmodel.getResultindex_return();

         flightCodeR=rightmodel.getReturnflightcodearrive();
         flightNameR=rightmodel.getReturnflightnamearrive();
         flightNumberR=rightmodel.getReturnflightnumberarrive();
         flightSeatLeftR=rightmodel.getReturnroundtriponewayseatsleft();
         flightDepartureTimeR=rightmodel.getReturnflightonewaydiparturetime();
         flightPriceR=rightmodel.getReturnroundtriponewayprice();
         flightImageR=rightmodel.getImgagerountreturn();
         flightArrivalTimeR=rightmodel.getReturnflightonewaytimearrive();

        int f = finalprice + priceid;
        text_price.setText(String.valueOf(f));
        if (finalprice > 0 && priceid > 0) {
            Book_btn.setVisibility(View.VISIBLE);
        }
        Toast.makeText(getApplicationContext(), "it is working " + f, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void leftitemclick(View view, int position)
    {
        Linvisible.setVisibility(View.VISIBLE);
        RoundtripModelclass leftmodel = (RoundtripModelclass) leftadaptor.getItem(position);

         flightCode=leftmodel.getCodeneway();
         flightName=leftmodel.getFlightnameneway();
         flightNumber=leftmodel.getNumberneway();
         flightSeatLeft=leftmodel.getSeatsleftneway();
         flightDepartureTime=leftmodel.getDiparturetimeneway();
         flightPrice=leftmodel.getPriceneway();
         flightArrivalTime=leftmodel.getOrigintimeneway();

        priceid = Integer.parseInt(leftmodel.getPriceneway());
        result_oneward = leftmodel.getResultindex_oneward();
        int b = finalprice + priceid;
        text_price.setText(String.valueOf(b));
        if (finalprice > 0 && priceid > 0)
        {
            Book_btn.setVisibility(View.VISIBLE);
        }
        Toast.makeText(getApplicationContext(), "It is working " + b, Toast.LENGTH_SHORT).show();
    }//End of leftitemclick method
}//End of RoundTripActivity class
