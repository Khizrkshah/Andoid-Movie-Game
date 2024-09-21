package com.example.guessthemoviegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class SettingsActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    public static String sharedPrefName = "com.example.guessthemovie.sharedpref";
    public static String keyGenre = "genre";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_actvity);
        radioGroup = findViewById(R.id.radioGroup);
        sharedPreferences = getSharedPreferences(sharedPrefName,MODE_PRIVATE);

    }

    public void saveButtonClicked(View view) {
        switch (radioGroup.getCheckedRadioButtonId()){
            case R.id.radioButtonAction:
                sharedPreferences.edit().putString(keyGenre,"Action").apply();
                break;
            case R.id.radioButtonAdventure:
                sharedPreferences.edit().putString(keyGenre,"Adventure").apply();
                break;
            case R.id.radioButtonComedy:
                sharedPreferences.edit().putString(keyGenre,"Comedy").apply();
                break;
            case R.id.radioButtonHorror:
                sharedPreferences.edit().putString(keyGenre,"Horror").apply();
                break;
            default:
                sharedPreferences.edit().putString(keyGenre,"Drama").apply();
                break;
        }

        Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
        startActivity(intent);
    }
}