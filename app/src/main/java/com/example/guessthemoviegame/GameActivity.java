package com.example.guessthemoviegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.time.Year;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    ImageView posterView;
    Button button1;
    Button button2;
    Button button3;
    String movieYear;
    String posterUrl = "https://m.media-amazon.com/images/M/MV5BN2FjNmEyNWMtYzM0ZS00NjIyLTg5YzYtYThlMGVjNzE1OGViXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_SX300.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        posterView = findViewById(R.id.posterView);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        movieYear = "2021";
        Picasso.get().load(posterUrl).into(posterView);
        button1.setText(movieYear);
        button2.setText(movieYear);
        button3.setText(movieYear);
        int random1 = new Random().nextInt((3 - 1) + 1) + 1;
        int random2 = new Random().nextInt((3 - 1) + 1) + 1;

        while(random2 == random1){
            random2 = new Random().nextInt((3 - 1) + 1) + 1;
        }

        if(random1 == 1){
            int rand = yearDiffGen();
            button1.setText(String.valueOf(Integer.parseInt(movieYear) + rand));
            Log.d("button1", String.valueOf(rand));
        }else if(random1 == 2){
            int rand = yearDiffGen();
            button2.setText(String.valueOf(Integer.parseInt(movieYear) + rand));
        }else {
            int rand = yearDiffGen();
            button3.setText(String.valueOf(Integer.parseInt(movieYear) + rand));
        }

        if(random2 == 1){
            int rand = yearDiffGen();
            button1.setText(String.valueOf(Integer.parseInt(movieYear) + rand));
        }else if(random2 == 2){
            int rand = yearDiffGen();
            button2.setText(String.valueOf(Integer.parseInt(movieYear) + rand));
        }else {
            int rand = yearDiffGen();
            button3.setText(String.valueOf(Integer.parseInt(movieYear) + rand));
        }

    }

    public void buttonOneClicked(View view) {
        if(button1.getText().toString().equals(movieYear)){
            Toast.makeText(GameActivity.this, "Correct!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(GameActivity.this, "Wrong!", Toast.LENGTH_LONG).show();
        }
    }

    public void buttonTwoClicked(View view) {
        if(button2.getText().toString().equals(movieYear)){
            Toast.makeText(GameActivity.this, "Correct!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(GameActivity.this, "Wrong!", Toast.LENGTH_LONG).show();
        }
    }

    public void buttonThreeClicked(View view) {
        if(button3.getText().toString().equals(movieYear)){
            Toast.makeText(GameActivity.this, "Correct!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(GameActivity.this, "Wrong!", Toast.LENGTH_LONG).show();
        }
    }

    public void nextButtonClicked(View view){
        Intent intent = new Intent(GameActivity.this,GameActivity.class);
        startActivity(intent);
    }

    public int yearDiffGen(){
        int r = new Random().nextInt((3 - (-5)) + 1) + (-5);
        while(r == 0)
        {
            r = new Random().nextInt((3 - (-5)) + 1) + (-5);
        }
        return r;
    }
}