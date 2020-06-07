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

public class DetailsBHKWActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bhkw);

        Toolbar toolbar = findViewById(R.id.toolbar_details_bhkw_activity);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.ic_action_arrow_left);
            getSupportActionBar().setTitle("");
        }

        // Setting the Item image
        ImageView imageItem = findViewById(R.id.bhkw_image_details);
        imageItem.setImageResource(getIntent().getExtras().getInt("image"));

        // Setting the Item BHKW Name details
        TextView houseNumberItem = findViewById(R.id.bhkw_name_details);
        houseNumberItem.setText(getIntent().getExtras().getString("BHKWName"));

        // Setting the Item Counter Number details
        TextView counterNumberItem = findViewById(R.id.bhkw_number_detail);
        counterNumberItem.setText(getIntent().getExtras().getString("BHKWCounterNumber"));

        TextView addressItem = findViewById(R.id.bhkw_location_textView);
        addressItem.setText(getIntent().getExtras().getString("location"));

        final Button cancelButton = findViewById(R.id.bhkw_cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), cancelButton.getText() + " button pressed", Toast.LENGTH_SHORT).show();

                EditText kwhMeasurementEditText = findViewById(R.id.bhkw_kwhEditText);
                kwhMeasurementEditText.getText().clear();
            }
        });

        final Button confirmButton = findViewById(R.id.bhkw_confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText kwhMeasurementEditText = findViewById(R.id.bhkw_kwhEditText);
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