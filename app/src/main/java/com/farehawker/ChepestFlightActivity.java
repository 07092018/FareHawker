//Test
package com.farehawker;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.farehawker.Adaptors.AppController;
import com.farehawker.Adaptors.RecyclerViewChepListAdapter;
import com.farehawker.Model.OfferModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ChepestFlightActivity extends AppCompatActivity
{
    private List<OfferModel> grceryList = new ArrayList<OfferModel>();
    private RecyclerView ceryRecyclerView;
    private static final String urlvertical="https://demo0977760.mockable.io/bestoffers";
    private RecyclerViewChepListAdapter ryceryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chepest_flight);
        if (getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        ceryRecyclerView = findViewById(R.id.idRecyclerviewnew_lList);
        // add a divider after each item for more clarity
//       ceryRecyclerView.addItemDecoration(new DividerItemDecoration(ChepestFlightActivity.this, LinearLayoutManager.VERTICAL));
        ryceryAdapter = new RecyclerViewChepListAdapter(grceryList, getApplicationContext());
        LinearLayoutManager lLayoutManager = new LinearLayoutManager(ChepestFlightActivity.this, LinearLayoutManager.VERTICAL, false);
        ceryRecyclerView.setLayoutManager(lLayoutManager);
        ceryRecyclerView.setAdapter(ryceryAdapter);
        populategroceryList();
    }
    private void populategroceryList(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading please wait ...");
        progressDialog.show();
        JsonArrayRequest stringRequest = new JsonArrayRequest(Request.Method.GET,urlvertical,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject myobj=response.getJSONObject(i);
                                OfferModel offermodchep = new OfferModel();
                                offermodchep.setProductFrom(myobj.getString("Origin"));
                                offermodchep.setProductTo(myobj.getString("Destination"));
                                offermodchep.setProductPrice(myobj.getString("Fare"));
                                offermodchep.setProductImage(myobj.getString("image"));
                                grceryList.add(offermodchep);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            progressDialog.dismiss();
                        }
                        ryceryAdapter.notifyDataSetChanged();
                        progressDialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        //Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
        AppController.getInstance().addToRequestQueue(stringRequest);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId()==android.R.id.home);
        finish();
        return super.onOptionsItemSelected(item);
    }
}
