package com.example.android;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private ImageButton gamebutton1;
    private ImageButton gamebutton2;
    private ImageButton gamebutton3;
    private ImageButton gamebutton4;
    private FloatingActionButton floatingActionButton;
    private TextView scoreText;
    int rand_int1;
    Animation animation;
    int score;
    private static final String KEY_HS = "HighScore: ";
    private static final String MY_SCORE = "Score";
    SharedPreferences myPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation1);
        myPreferences = PreferenceManager.getDefaultSharedPreferences(GameActivity.this);
        score = myPreferences.getInt(KEY_HS, 0);
        scoreText = findViewById(R.id.scorebox);
        scoreText.setText(this.getString(R.string.score) + " : " + score);

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
        rand_int1 = rand.nextInt(3) + 1;

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation1);
        ImageView image = (ImageView) findViewById(R.id.imagebutton1);


    }

    //jokainen kortti
    public void handleClickEvents(View view) {
        switch (view.getId()) {
            case R.id.imagebutton1:
                gamebutton1.setVisibility(View.INVISIBLE);
                gamebutton1.startAnimation((animation));
                if (rand_int1 == 1) {
                    gamebutton1.setImageResource(R.mipmap.music_note);
                    gamebutton1.setBackgroundColor(Color.GREEN);
                    gamebutton1.setVisibility(View.VISIBLE);
                    score = score+1;
                    scoreText.setText(this.getString(R.string.score) + " : " + score);
                    SharedPreferences.Editor myEditor = myPreferences.edit();
                    myEditor.putInt(KEY_HS, score);
                    myEditor.commit();

                }

                break;
            case R.id.imagebutton2:
                gamebutton2.setVisibility(View.INVISIBLE);
                gamebutton2.startAnimation((animation));
                if (rand_int1 == 2) {
                    gamebutton2.setImageResource(R.mipmap.music_note);
                    gamebutton2.setBackgroundColor(Color.GREEN);
                    gamebutton2.setVisibility(View.VISIBLE);
                    score = score+1;
                    scoreText.setText(this.getString(R.string.score) + " : " + score);
                    SharedPreferences.Editor myEditor = myPreferences.edit();
                    myEditor.putInt(KEY_HS, score);
                    myEditor.commit();


                }
                break;
            case R.id.imagebutton3:
                gamebutton3.setVisibility(View.INVISIBLE);
                gamebutton3.startAnimation((animation));
                if (rand_int1 == 3) {
                    gamebutton3.setImageResource(R.mipmap.music_note);
                    gamebutton3.setBackgroundColor(Color.GREEN);
                    gamebutton3.setVisibility(View.VISIBLE);
                    score = score+1;
                    scoreText.setText(this.getString(R.string.score) + " : " + score);
                    SharedPreferences.Editor myEditor = myPreferences.edit();
                    myEditor.putInt(KEY_HS, score);
                    myEditor.commit();
                }


                break;
            case R.id.imagebutton4:
                gamebutton4.setVisibility(View.INVISIBLE);
                gamebutton4.startAnimation((animation));
                if (rand_int1 == 4) {
                    gamebutton4.setImageResource(R.mipmap.music_note);
                    gamebutton4.setBackgroundColor(Color.GREEN);
                    gamebutton4.setVisibility(View.VISIBLE);
                    score = score+1;
                    scoreText.setText(this.getString(R.string.score) + " : " + score);
                    SharedPreferences.Editor myEditor = myPreferences.edit();
                    myEditor.putInt(KEY_HS, score);
                    myEditor.commit();

                }


                break;

            case R.id.fab:
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
                /*SharedPreferences myPreferences
                        = PreferenceManager.getDefaultSharedPreferences(GameActivity.this);
                SharedPreferences.Editor editor = myPreferences.edit();
                editor.putInt("KEY_HS",highestScore);
                editor.apply();*/


                break;


            default:


        }
    }
}

