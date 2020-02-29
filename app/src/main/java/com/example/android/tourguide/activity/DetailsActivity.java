package com.example.android.tourguide.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.tourguide.R;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

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

        // Setting the Item name
        TextView nameItem = findViewById(R.id.name_details);
        nameItem.setText(getIntent().getExtras().getString("name"));

        TextView addressItem = findViewById(R.id.location_textView);
        addressItem.setText(getIntent().getExtras().getString("location"));

        TextView descriptionItem = findViewById(R.id.description_details);
        descriptionItem.setText(getIntent().getExtras().getString("description"));

        final Button bookButton = findViewById(R.id.book);
        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), bookButton.getText() + " button pressed", Toast.LENGTH_SHORT).show();
            }
        });

        final Button checkButton = findViewById(R.id.availabilty);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), checkButton.getText() + " button pressed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}