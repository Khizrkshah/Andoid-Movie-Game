package com.example.guessthemoviegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText playerNameField;
    public static String sharedPrefName = "com.example.guessthemoviegame.sharedpref";
    public static String keyGenre = "Genre";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerNameField = findViewById(R.id.playerNameField);
        sharedPreferences = getSharedPreferences(sharedPrefName,MODE_PRIVATE);
    }

    public void startButtonClicked(View view) {
        if(playerNameField.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this, "Please Enter a name before starting!", Toast.LENGTH_LONG).show();
        }else{
            Intent intent = new Intent(MainActivity.this,GameActivity.class);
            intent.putExtra("playerName",playerNameField.getText().toString());
            startActivity(intent);
        }
    }

    public void settingsButtonClicked(View view) {
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    public void highscoresButtonClicked(View view) {
        Intent intent = new Intent(MainActivity.this,HighScoresActivity.class);
        startActivity(intent);
    }
}