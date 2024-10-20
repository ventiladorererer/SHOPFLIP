package com.wdit.shopflip;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class Splash_Screen extends AppCompatActivity {
    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH =3580;
    TextView com_name, com_moto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        com_name =findViewById(R.id.text_company_name);
        com_moto =findViewById(R.id.text_company_moto);

        boolean isFirstRun = getSharedPreferences ("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!isFirstRun) {
                    startActivity(new Intent(Splash_Screen.this, Signin_Screen.class));
                    finish();
                } else{
                    startActivity(new Intent(Splash_Screen.this,Welcome_Screen.class));
                    getSharedPreferences("PREFERENCE",MODE_PRIVATE).edit().putBoolean("isFirstRun",false).commit();
                    finish();
                }
        }

        }, SPLASH_DISPLAY_LENGTH);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.fade);
        com_name.startAnimation(animation);
        com_moto.startAnimation(animation);







    }
}