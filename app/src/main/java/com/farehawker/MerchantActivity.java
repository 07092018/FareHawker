package com.farehawker;

import android.app.Activity;
import android.util.Log;

import com.razorpay.Checkout;

import org.json.JSONObject;

public class MerchantActivity extends Activity implements PaymentResultListner
{
    private static final String TAG ="MerchantActivity" ;

    @Override
    public void onPaymentSuccess(String razorpayPaymentID) {
        /**
         * Add your logic here for a successfull payment response
         */
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
            jsonObject.put("description","123");
            jsonObject.put("currency","INR");
            jsonObject.put("amount","500");
            checkout.open(activity,jsonObject);


        }
        catch(Exception e)
        {
            Log.i(TAG,"Error in RazorPay checkout",e);
        }
    }
}
