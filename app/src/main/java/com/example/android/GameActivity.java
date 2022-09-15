package com.example.android;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;
public class GameActivity extends AppCompatActivity {

    private ImageButton gamebutton1;
    private ImageButton gamebutton2;
    private ImageButton gamebutton3;
    private ImageButton gamebutton4;
    private FloatingActionButton floatingActionButton;

    public class generateRandom {
        public void main(String args[]) {

            Random rand = new Random();


            int rand_int1 = rand.nextInt(4);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        gamebutton1 = findViewById(R.id.imagebutton1);
        gamebutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickEvents(view);
            }
        });
        gamebutton2 = findViewById(R.id.imagebutton4);
        gamebutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickEvents(view);
            }
        });
        gamebutton3 = findViewById(R.id.imagebutton3);
        gamebutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickEvents(view);
            }
        });
        gamebutton4 = findViewById(R.id.imagebutton4);
        gamebutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickEvents(view);
            }
        });

        floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickEvents(view);
            }
        });

    }


    public void handleClickEvents(View view) {
        switch (view.getId()) {
            case R.id.imagebutton1:
                gamebutton1.setVisibility(View.INVISIBLE);
                break;
            case R.id.imagebutton2:
                gamebutton2.setVisibility(View.INVISIBLE);
                break;
            case R.id.imagebutton3:
                gamebutton3.setVisibility(View.INVISIBLE);
                break;
            case R.id.imagebutton4:
                gamebutton4.setVisibility(View.INVISIBLE);
                break;

            case R.id.fab:
                finish();
                startActivity(getIntent());

            default:
        }
    }
}