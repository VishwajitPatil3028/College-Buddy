package com.example.collegebuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    ImageView img;
    TextView txt;
    private Handler handler;
    private  Runnable callback;

    View lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        img = findViewById(R.id.imageClg);
        txt = findViewById(R.id.app_name);

        lottieAnimationView = findViewById(R.id.lottie);

        img.animate().translationY(1600).setDuration(1000).setStartDelay(4000);
        txt.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(1200).setDuration(1000).setStartDelay(4000);

        handler = new Handler();
        callback = new Runnable()
        {
            @Override
            public void run ()
            {
                startActivity(new Intent(getApplicationContext(), DashBoardBranch.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        };
        handler.postDelayed(callback,4000);

    }

    @Override
    protected void onPause()
    {
        super.onPause();
        handler.removeCallbacks(callback);
    }

}