package com.farehawker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class International_Roundtrip extends AppCompatActivity
{
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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


    }
}
