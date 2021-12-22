package com.mycompany.myapp.bframework;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 12/10/2017.
 */
public class PriceAdapter extends ArrayAdapter<Price> {
    int resource;
    TextView smallname, smallprice;
    ImageView smallordeere;
    int posi;
    OnGridClickedListener Listener;
    public PriceAdapter (Context context, int resourece, List<Price> items){
        super(context,resourece,items);
        this.resource =resourece;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        RelativeLayout gridViewe;
        RelativeLayout orderitselffe;
        Price items = getItem(position);
        String pricorico = items.getValu();
        posi = position;
        if(convertView == null){
            gridViewe = new RelativeLayout(getContext());
            String Inflator = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater li;
            li = (LayoutInflater)getContext().getSystemService(Inflator);
            li.inflate(resource,gridViewe,true);
        }
        else{
            gridViewe = (RelativeLayout) convertView;
        }
        smallordeere = (ImageView)gridViewe.findViewById(R.id.smallordere);
        smallname = (TextView)gridViewe.findViewById(R.id.smallname);
        smallprice = (TextView)gridViewe.findViewById(R.id.smallprice);
        smallname.setText(items.getName());
        orderitselffe = (RelativeLayout)gridViewe.findViewById(R.id.orderitselffe);
        smallordeere.setImageResource(items.getResourceid());
        smallprice.setText(items.getValu());
        orderitselffe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Listener.OnGridClicked(position);
            }
        });
        return gridViewe;
    }

    public interface OnGridClickedListener{
        public void OnGridClicked(int position);
    }
    public void setOnItemClickedListener (OnGridClickedListener listener){
        this.Listener = listener;
    }
}
