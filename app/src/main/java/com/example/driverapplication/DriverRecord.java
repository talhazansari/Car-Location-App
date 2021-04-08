package com.example.driverapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DriverRecord extends AppCompatActivity {
    ImageView ivPhone, ivLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_record);
        initializer();
        Intent getIntent = getIntent();
        String cell = getIntent.getStringExtra("DriverCell");
        String address = getIntent.getStringExtra("DriverAddress");
        ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + cell));
                startActivity(intent);
            }
        });

        ivLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + address));
                startActivity(intent);
            }
        });
    }


    private void initializer()
    {
        ivPhone = findViewById(R.id.ivPhone);
        ivLocation = findViewById(R.id.ivLocation);
    }
}