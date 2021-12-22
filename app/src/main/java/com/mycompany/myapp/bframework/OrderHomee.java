package com.mycompany.myapp.bframework;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderHomee extends AppCompatActivity implements PriceAdapter.OnGridClickedListener {
PriceAdapter priceAdapter;
    GridView orderhomee;
    int resourceId;
    Dialog showee;
    ImageView whattobuy;
    TextView orderBringee, ortitle, orsub, titleo, subtitleo, mottoo, oprico, oname, oinfo;
    ArrayList<Price> prices = new ArrayList<Price>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderhomepage);
        resourceId = R.layout.orderitself;
        orderhomee = (GridView)findViewById(R.id.orderhomee);
        orderhomee.setScrollY(View.FOCUS_DOWN);
        priceAdapter = new PriceAdapter(this, resourceId,prices);
        orderBringee = (TextView)findViewById(R.id.orderbringee);
        ortitle = (TextView)findViewById(R.id.ortitle);
        orsub = (TextView)findViewById(R.id.orsub);
        Price r = new Price("bag of purewater","#150",R.mipmap.dele);
        Price s = new Price("one egg","#40",R.mipmap.theframee);
        Price t = new Price("one small indomie","#60",R.mipmap.clienter);
        prices.add(r);
        prices.add(s);
        prices.add(t);
        priceAdapter.notifyDataSetChanged();
        priceAdapter.setOnItemClickedListener(this);
        orderBringee.setOnTouchListener(orderBringeeListener);

        orderhomee.setAdapter(priceAdapter);
    }
    View.OnTouchListener orderBringeeListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

            return false;
        }
    };

    @Override
    public void OnGridClicked(int position) {
        Price fer = priceAdapter.getItem(position);
        Busi fre = BusinessFragment.bosiList.get(BusiAdapter.je);
        showee = new Dialog(this);
        showee.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        showee.setContentView(R.layout.afterorder);
        showee.show();
        titleo = (TextView)showee.findViewById(R.id.aftertitle);
        titleo.setText(fre.getBusititle());
        whattobuy = (ImageView)showee.findViewById(R.id.whatobuy);
        whattobuy.setImageResource(fer.getResourceid());
        subtitleo = (TextView)showee.findViewById(R.id.aftersubi);
        subtitleo.setText(fre.getSubBusi());
        oprico = (TextView)showee.findViewById(R.id.afterprico);
        oprico.setText(fer.getValu());
        oname = (TextView)showee.findViewById(R.id.nameo);
        oname.setText(fer.getName());

    }
}
