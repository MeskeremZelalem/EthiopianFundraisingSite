package com.gebeya.tena;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity implements Animator.AnimatorListener{

    protected ImageView splashLogo;
    protected Animation fadeAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


    splashLogo = findViewById(R.id.splash_logo);
    fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.fade);
        splashLogo.startAnimation(fadeAnimation);

        new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            Intent i = new Intent(SplashActivity.this, SignUpActivity.class);
            startActivity(i);
            finish();
        }
    },3000);


}

    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {

    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }
}