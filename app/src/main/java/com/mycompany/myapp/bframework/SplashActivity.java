package com.mycompany.myapp.bframework;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Paul on 1/13/2018.
 */
public class SplashActivity extends AppCompatActivity{

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

                    startActivity(new Intent(SplashActivity.this, MainActivity.class));

        finish();

            // close splash activity



    }

}
