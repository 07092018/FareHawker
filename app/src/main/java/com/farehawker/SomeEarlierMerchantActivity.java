package com.farehawker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.razorpay.Checkout;

public class SomeEarlierMerchantActivity extends Activity
{
    String totalFare;
    Intent intent;
    @Override
    public void onCreate( Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        Checkout.preload(getApplicationContext());
        intent=getIntent();
        totalFare=intent.getStringExtra("totalFare");
        intent = new Intent(SomeEarlierMerchantActivity.this,MerchantActivity.class);
        intent.putExtra("totalFare",totalFare);
        startActivity(intent);
    }//End of onCreate method
}//End of SomeEarlierMerchantActivity class
