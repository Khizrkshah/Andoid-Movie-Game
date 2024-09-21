package com.example.guessthemoviegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HighScoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);
    }

    public void mainMenuClicked(View view){
        Intent intent = new Intent(HighScoresActivity.this,MainActivity.class);
        startActivity(intent);
    }
}