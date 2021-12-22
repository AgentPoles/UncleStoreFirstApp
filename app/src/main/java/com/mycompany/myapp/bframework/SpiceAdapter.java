package com.mycompany.myapp.bframework;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Paul on 1/11/2018.
 */
public class SpiceAdapter extends RecyclerView.Adapter<SpiceAdapter.SpiViewHolder> {
        List<SpiceUp> spiceList;
        int y;
static   int je;
        SpiceUp spiceUp;
//        OnRecycleViewItemClicker Listener;
public static String whatwedo, track, spicename, spicecontract;
    public int spico;
public class SpiViewHolder extends RecyclerView.ViewHolder{
    TextView whatwe, track, spicenamee,spicecontacto;

    View vb;
    public SpiViewHolder(View view){
        super(view);
        vb = view;
        whatwe = (TextView)vb.findViewById(R.id.whatwedo);
        track = (TextView)vb.findViewById(R.id.track);
        spicenamee = (TextView) vb.findViewById(R.id.spicename);
        spicecontacto = (TextView) vb.findViewById(R.id.spicecontact);
        view.setClickable(true);

    }
}
    public SpiceAdapter (List<SpiceUp> dbusi){
        this.spiceList = dbusi;
        y = this.getItemCount();
    }

    @Override
    public SpiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View celtems = LayoutInflater.from(parent.getContext()).inflate(R.layout.spice,parent,false);
        return new SpiViewHolder(celtems);
    }
    View.OnClickListener  onClickView = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };
    @Override
    public void onBindViewHolder(SpiViewHolder holder, int position) {
        spiceUp = spiceList.get(position);
        je = position;
        holder.whatwe.setText(spiceUp.getWhatwedo());
        holder.spicenamee.setText(spiceUp.getSpicename());
        holder.track.setText(spiceUp.getTrack());
        holder.spicecontacto.setText(spiceUp.getSpicecontact());



    }
    View.OnClickListener wholeSubListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };
    @Override
    public int getItemCount() {
        try{
            return spiceList.size();
        }
        catch(Exception e) {
            return 0;
        }
    }
public interface OnRecycleViewItemClicker{
    public void OnRecycleViewItemclicked(int position);
}
    public void setOnItemclickedListener(OnRecycleViewItemClicker listener){

    }
}


