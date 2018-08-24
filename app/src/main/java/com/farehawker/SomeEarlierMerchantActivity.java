package com.farehawker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.razorpay.Checkout;

public class SomeEarlierMerchantActivity extends Activity
{
    @Override
    public void onCreate( Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Checkout.preload(getApplicationContext());
        Intent intent = new Intent(SomeEarlierMerchantActivity.this,MerchantActivity.class);
        startActivity(intent);

    }
}
