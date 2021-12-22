package com.mycompany.myapp.bframework;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Paul on 12/6/2017.
 */
public class BusiAdapter extends RecyclerView.Adapter<BusiAdapter.PxViewHolder> {
    List<Busi> busiList;
    int y;
  static   int je;
    Busi busi;
    OnRecycleViewItemClicker Listener;
    public static String buisititle, buisisub;
    public class PxViewHolder extends RecyclerView.ViewHolder{
        TextView bustitle, subusi;
         CheckBox rated;
        View vb;
        RelativeLayout wholelasubbusiness;
        public PxViewHolder(View view){
            super(view);
            vb = view;
            bustitle = (TextView)vb.findViewById(R.id.bustitle);
            subusi = (TextView)vb.findViewById(R.id.busmotto);
            rated = (CheckBox)vb.findViewById(R.id.rated);
            wholelasubbusiness = (RelativeLayout)vb.findViewById(R.id.wholelasubbusiness);
            view.setClickable(true);
            view.setOnClickListener(onClickView);
        }
    }
    public BusiAdapter (List<Busi> dbusi){
        this.busiList = dbusi;
        y = this.getItemCount();
    }

    @Override
    public PxViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View celtem = LayoutInflater.from(parent.getContext()).inflate(R.layout.subbusiness,parent,false);
        return new PxViewHolder(celtem);
    }
 View.OnClickListener  onClickView = new View.OnClickListener() {
     @Override
     public void onClick(View view) {

     }
 };
    @Override
    public void onBindViewHolder(PxViewHolder holder, int position) {
         busi = busiList.get(position);
        je = position;
        holder.subusi.setText(busi.getSubBusi());
        holder.bustitle.setText(busi.getBusititle());
        holder.wholelasubbusiness.setOnClickListener(wholeSubListener);
        buisititle = busi.getBusititle().toString();
        buisisub = busi.getSubBusi().toString();

    }
  View.OnClickListener wholeSubListener = new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          Listener.OnRecycleViewItemclicked(je);
      }
  };
    @Override
    public int getItemCount() {
        try{
            return busiList.size();
        }
        catch(Exception e) {
            return 0;
        }
    }
    public interface OnRecycleViewItemClicker{
        public void OnRecycleViewItemclicked(int position);
    }
    public void setOnItemclickedListener(OnRecycleViewItemClicker listener){
        this.Listener =  listener;
    }
}
