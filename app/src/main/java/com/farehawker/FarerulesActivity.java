package com.farehawker;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
import com.farehawker.Adaptors.Farerules_roundReturn;
import com.farehawker.Adaptors.Farerules_roundorigin;
import com.farehawker.Adaptors.MyBaseActivity;
import com.farehawker.Adaptors.ServicereturnAdaptr;
import com.farehawker.Adaptors.ServiclistAdaptr;
import com.farehawker.Model.Fare_originModel;
import com.farehawker.Model.Fare_returnModel;
import com.farehawker.Model.Servicelistmodel;
import com.farehawker.Model.ServicereturnModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FarerulesActivity extends MyBaseActivity
{
    //Flight Details
    String flightCode;
    String flightName;
    String flightNumber;
    String flightSeatLeft;
    String flightDepartureTime;
    String flightPrice;
    String flightArrivalTime;

    //Return Flight Details
    String flightCodeR;
    String flightNameR;
    String flightNumberR;
    String flightSeatLeftR;
    String flightDepartureTimeR;
    String flightArrivalTimeR;
    String flightPriceR;
    String originR;
    String destinationR;
    String adultR;
    String childR;
    String infantR;
    String cabinR;
    String departureR;
    String retrunR;

    TextView basefare, texas,otherch_text, publisfare;
    TextView terms_cond;
    CheckBox checkBox;
    ListView origin_list;
    ListView return_list;
    String countryTo;
    String resultindex_oneward,resultindex_return,tracidR,infantsR,enduserip_round,tokenid_round;
    int base_o, base_r, tex_o, text_r, total_o, total_r,otherch_o,otherch_r;
    private RecyclerView originrecyclerview, returnRecyclerview;
    private Farerules_roundorigin originadaptr;
    private Farerules_roundReturn returnAdaptr;
    private RecyclerView.LayoutManager orignLayoutManager, returnLayoutmanager;
    List<Fare_returnModel> returnlist;
    List<Fare_originModel> originlist;
    List<ServicereturnModel> returnlistdata = new ArrayList<>();
    ServicereturnAdaptr returnadapterdata;
    List<Servicelistmodel> originlistdata = new ArrayList<>();
    ServiclistAdaptr originadapterdata;
    public static final String JSON_URL = "http://api.tektravels.com/BookingEngineService_Air/AirService.svc/rest/Farequote/";
    public static final String JSON_URLR = "http://api.tektravels.com/BookingEngineService_Air/AirService.svc/rest/Farequote/";
    public static final String SRV_URL = "http://api.tektravels.com/BookingEngineService_Air/AirService.svc/rest/FareRule/";
    public static final String SRO_URL = "http://api.tektravels.com/BookingEngineService_Air/AirService.svc/rest/FareRule/";
    Button continueBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farerules);
        originrecyclerview = (RecyclerView) findViewById(R.id.origin_recyclerview);
        originrecyclerview.setHasFixedSize(true);
        orignLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        originrecyclerview.setLayoutManager(orignLayoutManager);
        originlist = new ArrayList<>();
        Intent intent= getIntent();

        resultindex_oneward = intent.getStringExtra("result_oneward");
        resultindex_return=intent.getStringExtra("result_return");
        tracidR=intent.getStringExtra("traceid");
        adultR=intent.getStringExtra("adultR");
        childR=intent.getStringExtra("childR");
        infantsR=intent.getStringExtra("infantR");
        enduserip_round=intent.getStringExtra("enduserip_round");
        tokenid_round=intent.getStringExtra("tokenid_round");


        originR=intent.getStringExtra("originround");
        destinationR=intent.getStringExtra("destinationround");
        cabinR=intent.getStringExtra("cabinclass");

        //Flight Details
        flightCode=intent.getStringExtra("flightCode");
        flightName=intent.getStringExtra("flightName");
        flightNumber=intent.getStringExtra("flightNumber");
        flightSeatLeft=intent.getStringExtra("flightSeatLeft");
        flightDepartureTime=intent.getStringExtra("flightDepartureTime");
        flightPrice=intent.getStringExtra("flightPrice");
        flightArrivalTime=intent.getStringExtra("flightArrivalTime");

        //Return Flight details
        flightCodeR=intent.getStringExtra("flightCodeR");
        flightNameR=intent.getStringExtra("flightNameR");
        flightNumberR=intent.getStringExtra("flightNumberR");
        flightSeatLeftR=intent.getStringExtra("flightSeatLeftR");
        flightDepartureTimeR=intent.getStringExtra("flightDepartureTimeR");
        flightArrivalTimeR=intent.getStringExtra("flightDepartureTimeR");
        flightPriceR=intent.getStringExtra("flightPriceR");
        flightArrivalTime=intent.getStringExtra("flightArrivalTimeR");
        countryTo=intent.getStringExtra("countryTo");
        final String departureR=intent.getStringExtra("departureround");
        final String retrunR=intent.getStringExtra("returnround");

        Toast.makeText(FarerulesActivity.this,"resultindex is "+resultindex_oneward+"\n"+resultindex_return+"\n"+adultR+"\n"+childR+"\n"+infantsR+"\n"+tracidR,Toast.LENGTH_SHORT).show();

        returnRecyclerview = (RecyclerView) findViewById(R.id.return_recyclerview);
        returnRecyclerview.setHasFixedSize(true);
        returnLayoutmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        returnRecyclerview.setLayoutManager(returnLayoutmanager);
        returnlist = new ArrayList<>();
        makevolleyrequest();
        makevolleyreturn();
        basefare = (TextView) findViewById(R.id.basefare);
        texas = (TextView) findViewById(R.id.texas);
        otherch_text=(TextView)findViewById(R.id.othercharge);
        publisfare = (TextView) findViewById(R.id.publisfare);
        checkBox = (CheckBox) findViewById(R.id.chkWindows);
        terms_cond = (TextView) findViewById(R.id.term_condi);
        continueBooking=findViewById(R.id.roundTripContinueB);
        continueBooking.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                if(!checkBox.isChecked())
                {
                    Toast.makeText(FarerulesActivity.this,"Please accept the Terms and Condition",Toast.LENGTH_LONG).show();
                }

                else
                {

                    Intent intent = new Intent(getApplicationContext(),PassengerDetailsR.class);
                    intent.putExtra("countryTo",countryTo);
                    intent.putExtra("intentId","RoundTrip");
                    intent.putExtra("originround", originR);
                    intent.putExtra("destinationround", destinationR);
                    intent.putExtra("adultround", adultR);
                    intent.putExtra("childround", childR);
                    intent.putExtra("infantsround", infantsR);
                    intent.putExtra("cabinclass", cabinR);
                    intent.putExtra("departureround", departureR);
                    intent.putExtra("returnround", retrunR);

                    //Flight Details
                    intent.putExtra("enduserip_round",enduserip_round);
                    intent.putExtra("tokenid_round",tokenid_round);
                    intent.putExtra("flightPrice",flightPrice);
                    intent.putExtra("flightPriceR",flightPriceR);

                    //First FLight Details
                    intent.putExtra("flightPrice",flightPrice);
                    intent.putExtra("flightDepartureTime",flightDepartureTime);
                    intent.putExtra("flightArrivalTime",flightArrivalTime);
                    intent.putExtra("flightCode",flightCode);
                    intent.putExtra("flightName",flightName);
                    intent.putExtra("flightNumber",flightNumber);

                    //Return FLight Details
                    intent.putExtra("flightPriceR",flightPriceR);
                    intent.putExtra("flightDepartureTimeR",flightDepartureTimeR);
                    intent.putExtra("flightArrivalTimeR",flightArrivalTimeR);
                    intent.putExtra("flightCodeR",flightCodeR);
                    intent.putExtra("flightNameR",flightNameR);
                    intent.putExtra("flightNumberR",flightNumberR);

                    startActivity(intent);
                }
            }
        }
    );
        terms_cond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.servicedialog_layout, null);
                origin_list = (ListView) view.findViewById(R.id.originlist);
                return_list = (ListView) view.findViewById(R.id.returnlist);
                final Dialog mBottomSheetDialog = new Dialog(FarerulesActivity.this, R.style.MaterialDialogSheet);
                mBottomSheetDialog.setContentView(view);
                mBottomSheetDialog.setCancelable(true);
                mBottomSheetDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                mBottomSheetDialog.getWindow().setGravity(Gravity.CENTER);
                mBottomSheetDialog.show();
                termserviceapi();
                termoginserv();
            }
        });
    }//End of onCreate method
    private void makevolleyrequest() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading please wait ...");
        progressDialog.show();
        try {
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            JSONObject objfareF = new JSONObject();
            objfareF.put("EndUserIp", enduserip_round);
            objfareF.put("TokenId", tokenid_round);
            objfareF.put("TraceId", tracidR);
            objfareF.put("ResultIndex", resultindex_oneward);
            final String results = objfareF.toString();
            Log.wtf("relusty", results);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, JSON_URL, objfareF, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    progressDialog.dismiss();
                    try {
                        JSONObject firstobjs = response.getJSONObject("Response");
                        Log.i("Response_141", firstobjs.toString());
                        String responsstatus = firstobjs.getString("ResponseStatus");
                        Log.wtf("resstatus", responsstatus);
                        if (!responsstatus.equals("1")) {
                            new AlertDialog.Builder(FarerulesActivity.this)
                                    .setMessage("Your session is expired please press ok")
                                    //.setPositiveButton("Yes",null)
                                    .setNeutralButton("                               OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent intent = new Intent(FarerulesActivity.this, FlightbookingActivity.class);
                                            startActivity(intent);
                                        }
                                    })
                                    .show();
                        }
                        JSONObject resultobject = firstobjs.getJSONObject("Results");
                        JSONObject Faresr = resultobject.getJSONObject("Fare");
                        Double base = Double.valueOf(Faresr.getString("BaseFare"));
                        base_o = base.intValue();
                        Log.wtf("valuea", String.valueOf(base_o));
                        int bs = base_o + base_r;
                        basefare.setText(String.valueOf(bs));

                        Double tex = Double.valueOf(Faresr.getString("Tax"));
                        tex_o = tex.intValue();
                        Log.wtf("valuev", String.valueOf(tex_o));
                        int tx = tex_o + text_r;
                        texas.setText(String.valueOf(tx));


                        Double otherch = Double.valueOf(Faresr.getString("OtherCharges"));
                        otherch_o = otherch.intValue();
                        Log.wtf("valuev", String.valueOf(otherch_o));
                        int othr = otherch_o + otherch_r;
                        otherch_text.setText(String.valueOf(othr));
                        Double total = Double.valueOf(Faresr.getString("PublishedFare"));
                        total_o = total.intValue();
                        int pub = total_o + total_r;
                        Log.wtf("values", String.valueOf(total_o));
                        publisfare.setText(String.valueOf(pub));
                        JSONArray sagmentarr = resultobject.getJSONArray("Segments");
                        JSONArray sagmentinnner = sagmentarr.getJSONArray(0);
                        for (int i = 0; i < sagmentinnner.length(); i++) {
                            Fare_originModel origindata = new Fare_originModel();
                            JSONObject jobjet = sagmentinnner.getJSONObject(i);
                            origindata.setCheckin_origin(jobjet.getString("Baggage"));
                            origindata.setCabin_origin(jobjet.getString("CabinBaggage"));
                            origindata.setOrigin_dura(jobjet.getString("Duration") + "m");

                            JSONObject airline = jobjet.getJSONObject("Airline");
                            origindata.setOfcode1(airline.getString("AirlineCode"));
                            origindata.setO_fname1(airline.getString("AirlineName"));
                            origindata.setOnumber1(airline.getString("FlightNumber"));

                            JSONObject origin = jobjet.getJSONObject("Origin");
                            //origindata.setOtime1(origin.getString("DepTime"));
                            String splitdest = origin.getString("DepTime");
                            String[] textslitdest = splitdest.split("T");
                            String newsplitdest1 = textslitdest[0];
                            String newsplitdest2 = textslitdest[1];
                            String textdepar = newsplitdest2;
                            String sub_textdepa = textdepar.substring(0, newsplitdest2.length() - 3);
                            //this is wrong because i made mistake in xml
                            origindata.setOtime1(sub_textdepa);
                            JSONObject oriairport = origin.getJSONObject("Airport");
                            origindata.setOcity1(oriairport.getString("CityName"));
                            origindata.setOcode1(oriairport.getString("AirportCode"));
                            origindata.setOterm(oriairport.getString("Terminal"));

                            JSONObject destination = jobjet.getJSONObject("Destination");
                            //origindata.setAtime1(destination.getString("ArrTime"));
                            String splitarive = destination.getString("ArrTime");
                            String[] textslitarivtim = splitarive.split("T");
                            String newsplitarriv = textslitarivtim[0];
                            String newsplitarriv2 = textslitarivtim[1];
                            //substring value
                            String textsub = newsplitarriv2;
                            String sub_text = textsub.substring(0, newsplitarriv2.length() - 3);

                            //this is wrong because i made mistake in xml
                            origindata.setAtime1(sub_text);
                            JSONObject desairport = destination.getJSONObject("Airport");
                            origindata.setAcity1(desairport.getString("CityName"));
                            origindata.setAcode1(desairport.getString("AirportCode"));
                            origindata.setAterm(desairport.getString("Terminal"));
                            originlist.add(origindata);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    originadaptr = new Farerules_roundorigin(FarerulesActivity.this, originlist);
                    originrecyclerview.setAdapter(originadaptr);
                    originadaptr.notifyDataSetChanged();
                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("LOG_VOLLEY", error.toString());
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
            jsonObjectRequest.setRetryPolicy(policy);
            requestQueue.add(jsonObjectRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }//End of makevolleyrequest method
    private void makevolleyreturn() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading please wait ...");
        progressDialog.show();
        try {
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            JSONObject objfareF = new JSONObject();
            objfareF.put("EndUserIp", enduserip_round);
            objfareF.put("TokenId", tokenid_round);
            objfareF.put("TraceId", tracidR);
            objfareF.put("ResultIndex", resultindex_return);
            final String results = objfareF.toString();
            Log.wtf("relusty",results);
        JsonObjectRequest jsonObjectreturn = new JsonObjectRequest(Request.Method.POST, JSON_URLR,objfareF, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressDialog.dismiss();
                try {
                    JSONObject firstobjsR = response.getJSONObject("Response");
                    String responsstatus = firstobjsR.getString("ResponseStatus");
                    if (!responsstatus.equals("1")) {
                        new AlertDialog.Builder(FarerulesActivity.this)
                                .setMessage("Your session is expired please press ok")
                                //.setPositiveButton("Yes",null)
                                .setNeutralButton("                               OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(FarerulesActivity.this, FlightbookingActivity.class);
                                        startActivity(intent);
                                    }
                                })
                                .show();
                    }
                    JSONObject resultobjectR = firstobjsR.getJSONObject("Results");
                    JSONObject FaresrR = resultobjectR.getJSONObject("Fare");

                    Double baseR = Double.valueOf(FaresrR.getString("BaseFare"));
                    base_r = baseR.intValue();
                    Log.wtf("valuea", String.valueOf(base_r));
                    int bs = base_o + base_r;
                    basefare.setText(String.valueOf(bs));
                    // basefare.setText(String.valueOf(n));

                    Double texR = Double.valueOf(FaresrR.getString("Tax"));
                    text_r = texR.intValue();
                    Log.wtf("valuet", String.valueOf(text_r));
                    int tx = tex_o + text_r;
                    texas.setText(String.valueOf(tx));
                    // texas.setText((tex_o+text_r));

                    Double otherchr = Double.valueOf(FaresrR.getString("OtherCharges"));
                    otherch_r = otherchr.intValue();
                    Log.wtf("valuev", String.valueOf(otherch_r));
                    int othrr = otherch_o + otherch_r;
                    otherch_text.setText(String.valueOf(othrr));



                    Double tt = Double.valueOf(FaresrR.getString("PublishedFare"));
                    total_r = tt.intValue();
                    Log.wtf("valuet", String.valueOf(total_r));
                    //publisfare.setText((total_o+total_r));
                    int pub = total_o + total_r;
                    Log.wtf("values", String.valueOf(total_o));
                    publisfare.setText(String.valueOf(pub));

                    JSONArray sagmentarrR = resultobjectR.getJSONArray("Segments");
                    JSONArray sagmentinnnerR = sagmentarrR.getJSONArray(0);
                    for (int i = 0; i < sagmentinnnerR.length(); i++) {
                        Fare_returnModel returndata = new Fare_returnModel();
                        JSONObject jobjetR = sagmentinnnerR.getJSONObject(i);
                        returndata.setCheckin_return(jobjetR.getString("Baggage"));
                        returndata.setCabin_return(jobjetR.getString("CabinBaggage"));
                        returndata.setReturn_dura(jobjetR.getString("Duration") + "m");

                        JSONObject airlineR = jobjetR.getJSONObject("Airline");
                        returndata.setRfcode1(airlineR.getString("AirlineCode"));
                        returndata.setR_name1(airlineR.getString("AirlineName"));
                        returndata.setRnumber1(airlineR.getString("FlightNumber"));

                        JSONObject originR = jobjetR.getJSONObject("Origin");
                        //origindata.setOtime1(origin.getString("DepTime"));
                        String splitdest = originR.getString("DepTime");
                        String[] textslitdestR = splitdest.split("T");
                        String newsplitdest1R = textslitdestR[0];
                        String newsplitdest2R = textslitdestR[1];
                        String textdeparR = newsplitdest2R;
                        String sub_textdepaR = textdeparR.substring(0, newsplitdest2R.length() - 3);
                        //this is wrong because i made mistake in xml
                        returndata.setRotime1(sub_textdepaR);
                        JSONObject oriairportR = originR.getJSONObject("Airport");
                        returndata.setR0city1(oriairportR.getString("CityName"));
                        returndata.setR0code1(oriairportR.getString("AirportCode"));
                        returndata.setR0term(oriairportR.getString("Terminal"));

                        JSONObject destinationR = jobjetR.getJSONObject("Destination");
                        //origindata.setAtime1(destination.getString("ArrTime"));
                        String splitariveR = destinationR.getString("ArrTime");
                        String[] textslitarivtimR = splitariveR.split("T");
                        String newsplitarrivR = textslitarivtimR[0];
                        String newsplitarriv2R = textslitarivtimR[1];
                        //substring value
                        String textsubR = newsplitarriv2R;
                        String sub_textR = textsubR.substring(0, newsplitarriv2R.length() - 3);

                        //this is wrong because i made mistake in xml
                        returndata.setRatime1(sub_textR);
                        JSONObject desairportR = destinationR.getJSONObject("Airport");
                        returndata.setRacity1(desairportR.getString("CityName"));
                        returndata.setRacode1(desairportR.getString("AirportCode"));
                        returndata.setRaterm(desairportR.getString("Terminal"));
                        returnlist.add(returndata);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                returnAdaptr = new Farerules_roundReturn(FarerulesActivity.this, returnlist);
                returnRecyclerview.setAdapter(returnAdaptr);
                returnAdaptr.notifyDataSetChanged();
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
            jsonObjectreturn.setRetryPolicy(policy);
            requestQueue.add(jsonObjectreturn);
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }//End of makevolleyreturn method
    private void termoginserv() {
        try {
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            JSONObject objfareF = new JSONObject();
            objfareF.put("EndUserIp", enduserip_round);
            objfareF.put("TokenId", tokenid_round);
            objfareF.put("TraceId", tracidR);
            objfareF.put("ResultIndex", resultindex_oneward);
            final String results = objfareF.toString();
            Log.wtf("relusty",results);
        JsonObjectRequest jsononewardserReq = new JsonObjectRequest(Request.Method.POST, SRO_URL,objfareF, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject firstobjsservo = response.getJSONObject("Response");
                    String responsstatus = firstobjsservo.getString("ResponseStatus");
                    if (!responsstatus.equals("1")) {
                        new AlertDialog.Builder(FarerulesActivity.this)
                                .setMessage("Your session is expired please press ok")
                                //.setPositiveButton("Yes",null)
                                .setNeutralButton("                               OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(FarerulesActivity.this, FlightbookingActivity.class);
                                        startActivity(intent);
                                    }
                                })
                                .show();
                    }
                    JSONArray fareruleservo = firstobjsservo.getJSONArray("FareRules");
                    for (int r = 0; r < fareruleservo.length(); r++) {
                        JSONObject serobjo = fareruleservo.getJSONObject(r);
                        Servicelistmodel origindata = new Servicelistmodel();
                        origindata.setSairline(serobjo.getString("Airline"));
                        origindata.setSorigin(serobjo.getString("Origin"));
                        origindata.setSdestination(serobjo.getString("Destination"));
                        origindata.setSdetails(serobjo.getString("FareRuleDetail"));
                        originlistdata.add(origindata);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                originadapterdata = new ServiclistAdaptr(FarerulesActivity.this, originlistdata);
                origin_list.setAdapter(originadapterdata);
                originadapterdata.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("LOG_VOLLEY", error.toString());

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
            jsononewardserReq.setRetryPolicy(policy);
            requestQueue.add(jsononewardserReq);
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }//End of termoginserv method
    private void termserviceapi() {
        //seconde list
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading please wait ...");
        progressDialog.show();
        try {
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            JSONObject objfareF = new JSONObject();
            objfareF.put("EndUserIp", enduserip_round);
            objfareF.put("TokenId", tokenid_round);
            objfareF.put("TraceId", tracidR);
            objfareF.put("ResultIndex", resultindex_return);
            final String results = objfareF.toString();
            Log.wtf("relusty",results);
        JsonObjectRequest jsonserviceRequest = new JsonObjectRequest(Request.Method.POST, SRV_URL,objfareF, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressDialog.dismiss();
                try {
                    JSONObject firstobjsserv = response.getJSONObject("Response");
                    String responsstatus = firstobjsserv.getString("ResponseStatus");
                    if (!responsstatus.equals("1")) {
                        new AlertDialog.Builder(FarerulesActivity.this)
                                .setMessage("Your session is expired please press ok")
                                //.setPositiveButton("Yes",null)
                                .setNeutralButton("                               OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(FarerulesActivity.this, FlightbookingActivity.class);
                                        startActivity(intent);
                                    }
                                })
                                .show();
                    }
                    JSONArray fareruleserv = firstobjsserv.getJSONArray("FareRules");
                    for (int s = 0; s < fareruleserv.length(); s++) {
                        JSONObject serobj = fareruleserv.getJSONObject(s);
                        ServicereturnModel returndata = new ServicereturnModel();
                        returndata.setRairline(serobj.getString("Airline"));
                        returndata.setRorigin(serobj.getString("Origin"));
                        returndata.setRdestination(serobj.getString("Destination"));
                        returndata.setRdetails(serobj.getString("FareRuleDetail"));
                        returnlistdata.add(returndata);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                returnadapterdata = new ServicereturnAdaptr(FarerulesActivity.this, returnlistdata);
                return_list.setAdapter(returnadapterdata);
                returnadapterdata.notifyDataSetChanged();
                progressDialog.dismiss();
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
            jsonserviceRequest.setRetryPolicy(policy);
        requestQueue.add(jsonserviceRequest);
    }catch (JSONException e) {
        e.printStackTrace();
    }

    }//End of termserviceapi method
}//End of FarerulesActivity class
