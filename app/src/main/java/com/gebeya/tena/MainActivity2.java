package com.gebeya.tena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gebeya.tena.ui.LoginActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void form_document(View view) {

        Intent I = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(I);
    }
}