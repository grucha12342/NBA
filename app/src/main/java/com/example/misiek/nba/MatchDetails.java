package com.example.misiek.nba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MatchDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_details);
        Intent intent = getIntent();
        int listPosition = intent.getIntExtra("PositionOnList", 0);
        TextView textView = findViewById(R.id.intentMsg);
        textView.setText(Integer.toString(listPosition));
    }
}
