package com.farehawker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.razorpay.Checkout;

import org.json.JSONObject;

public class MerchantActivity extends Activity implements PaymentResultListner
{
    private static final String TAG ="MerchantActivity" ;
    float totalFare;
    @Override
    public void onCreate( Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Intent intent =getIntent();
        String s=intent.getStringExtra("totalFare");
        float f=Float.parseFloat(s);
        totalFare=Float.parseFloat(intent.getStringExtra("totalFare"));

        startPayment();
    }

    @Override
    public void onPaymentSuccess(String razorpayPaymentID) {
        /**
         * Add your logic here for a successfull payment response
         */
        Toast.makeText(MerchantActivity.this,"Payment successfull",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPaymentError(int code, String response) {
        /**
         * Add your logic here for a failed payment response
         */
    }
    public  void startPayment()
    {
        Checkout checkout = new Checkout();
        checkout.setImage(R.drawable.farehawker_logo);
        final Activity activity= this;
        try
        {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name","FareHawker");
            jsonObject.put("description","");
            jsonObject.put("currency","INR");
            totalFare=100*totalFare;
            jsonObject.put("amount",totalFare);
            checkout.open(activity,jsonObject);


        }
        catch(Exception e)
        {
            Log.i(TAG,"Error in RazorPay checkout",e);
        }
    }
}
