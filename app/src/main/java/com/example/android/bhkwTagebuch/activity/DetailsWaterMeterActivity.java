package com.example.android.bhkwTagebuch.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.bhkwTagebuch.R;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DetailsWaterMeterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_meter);

        Toolbar toolbar = findViewById(R.id.toolbar_details_activity);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.ic_action_arrow_left);
            getSupportActionBar().setTitle("");
        }

        // Setting the Item image
        ImageView imageItem = findViewById(R.id.image_details);
        imageItem.setImageResource(getIntent().getExtras().getInt("image"));

        // Setting the Item House Number details
        TextView houseNumberItem = findViewById(R.id.waterMeter_name_details);
        houseNumberItem.setText(getIntent().getExtras().getString("waterMeterName"));

        // Setting the Item Counter Number details
        TextView counterNumberItem = findViewById(R.id.water_number_detail);
        counterNumberItem.setText(getIntent().getExtras().getString("waterMeterNumber"));

        TextView addressItem = findViewById(R.id.location_textView);
        addressItem.setText(getIntent().getExtras().getString("location"));

        final Button cancelButton = findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), cancelButton.getText() + " button pressed", Toast.LENGTH_SHORT).show();

                EditText kwhMeasurementEditText = findViewById(R.id.kwhEditText);
                kwhMeasurementEditText.getText().clear();
            }
        });

        final Button confirmButton = findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText kwhMeasurementEditText = findViewById(R.id.kwhEditText);
                String kwhMeasurement = kwhMeasurementEditText.getText().toString();
                Double kwhMeasurementValue = 0.0;

                if (!kwhMeasurement.isEmpty()) {
                    kwhMeasurementValue = Double.parseDouble(kwhMeasurementEditText.getText().toString());

                    Toast.makeText(getApplicationContext(), confirmButton.getText() + " button pressed: " + kwhMeasurementValue, Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(getApplicationContext(), "Insert kWh before to confirm", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}