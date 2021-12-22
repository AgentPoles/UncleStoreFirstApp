package com.mycompany.myapp.bframework;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Myaccount extends AppCompatActivity {
    TextView businameeee, busiemail, transaction, advert, rank, business;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myaccount);
        Toolbar toolbarc = (Toolbar) findViewById(R.id.toolbara);
        setSupportActionBar(toolbarc);
        busiemail =(TextView)findViewById(R.id.busiemail);
        businameeee =(TextView)findViewById(R.id.businameeee);
        transaction = (TextView)findViewById(R.id.transactions);
        advert = (TextView)findViewById(R.id.adverts);
        business = (TextView)findViewById(R.id.business);
        businameeee.setSelected(true);
        busiemail.setSelected(true);
        if(MainActivity.iname!=null) {
//            busiemail.setText(MainActivity.iemail);
//            businameeee.setText(MainActivity.iname);

        }
        if(MainActivity.ibusiness!=-1) {
//            business.setText(String.valueOf(MainActivity.ibusiness));
//            transaction.setText(String.valueOf(MainActivity.itransaction));
//            advert.setText(String.valueOf(MainActivity.iadvert));
        }
    }
}
