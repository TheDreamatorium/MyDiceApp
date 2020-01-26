package com.example.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView diceImageView1 = findViewById(R.id.imageViewDice1);
        final ImageView diceImageView2 = findViewById(R.id.imageViewDice2);

        final int randomBound = 5;

        final int [] diceImages = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

        int myBox = 10;
        float myFloatBox = 4.2f;
        double myDoublebox = 3.34578923;

        Button btnRoll = findViewById(R.id.btnRollTheDice);

        final MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.dice_sound);

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rndObj = new Random();

                diceImageView1.setImageResource(diceImages[rndObj.nextInt(randomBound)]);
                diceImageView2.setImageResource(diceImages[rndObj.nextInt(randomBound)]);

                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(diceImageView1);

                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(diceImageView2);

                mp.start();
            }
        });
    }
}
