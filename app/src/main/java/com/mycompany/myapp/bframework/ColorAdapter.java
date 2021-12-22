package com.mycompany.myapp.bframework;

import android.content.Context;
import android.graphics.Color;
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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 12/10/2017.
 */
public class ColorAdapter extends ArrayAdapter<String> {
    int resource;

    TextView lingride;
    int posi;
    OnGridClickedListener Listener;
    public ColorAdapter (Context context, int resourece, List<String> items){
        super(context,resourece,items);
        this.resource =resourece;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        RelativeLayout gridViewe;
        RelativeLayout lingrid;
        String itrems = getItem(position);
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
     lingrid = (RelativeLayout)gridViewe.findViewById(R.id.lingrid);
        lingrid.setBackgroundColor(Color.parseColor(itrems));
        lingride = (TextView)gridViewe.findViewById(R.id.lingride) ;
        lingride.setBackgroundColor(Color.parseColor(itrems));
        lingrid.setOnClickListener(new View.OnClickListener() {
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
