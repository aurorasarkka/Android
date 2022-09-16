package com.example.android;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private ImageButton gamebutton1;
    private ImageButton gamebutton2;
    private ImageButton gamebutton3;
    private ImageButton gamebutton4;
    private FloatingActionButton floatingActionButton;
    int rand_int1;
    Animation animation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation1);


        gamebutton1 = findViewById(R.id.imagebutton1);
        gamebutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickEvents(view);
            }
        });
        gamebutton2 = findViewById(R.id.imagebutton2);
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

        //random number generator
        Random rand = new Random();
        rand_int1 = rand.nextInt(3)+1;

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation1);
        ImageView image = (ImageView) findViewById(R.id.imagebutton1);
        image.startAnimation(animation);

    }

    //jokainen kortti -> voi tulla tyhjiä ei löyä joka kerta
    public void handleClickEvents(View view) {
        switch (view.getId()) {
            case R.id.imagebutton1:
                gamebutton1.setVisibility(View.INVISIBLE);
                gamebutton1.startAnimation((animation));
                if(rand_int1 == 1) {
                    gamebutton1.setImageResource(R.mipmap.music_note);
                    gamebutton1.setBackgroundColor(Color.GREEN);
                    gamebutton1.setVisibility(View.VISIBLE);

                }

                break;
            case R.id.imagebutton2:
                gamebutton2.setVisibility(View.INVISIBLE);
                gamebutton2.startAnimation((animation));
                if(rand_int1 == 2) {
                    gamebutton2.setImageResource(R.mipmap.music_note);
                    gamebutton2.setBackgroundColor(Color.GREEN);
                    gamebutton2.setVisibility(View.VISIBLE);

                }
                break;
            case R.id.imagebutton3:
                gamebutton3.setVisibility(View.INVISIBLE);
                gamebutton3.startAnimation((animation));
                if(rand_int1 == 3) {
                    gamebutton3.setImageResource(R.mipmap.music_note);
                    gamebutton3.setBackgroundColor(Color.GREEN);
                    gamebutton3.setVisibility(View.VISIBLE);

                }

                break;
            case R.id.imagebutton4:
                gamebutton4.setVisibility(View.INVISIBLE);
                gamebutton4.startAnimation((animation));
                if(rand_int1 == 4) {
                    gamebutton4.setImageResource(R.mipmap.music_note);
                    gamebutton4.setBackgroundColor(Color.GREEN);
                    gamebutton4.setVisibility(View.VISIBLE);

                }
                break;

            case R.id.fab:
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);

            default:
        }
    }
}