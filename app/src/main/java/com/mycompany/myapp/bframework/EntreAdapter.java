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
public class EntreAdapter extends RecyclerView.Adapter<EntreAdapter.dxViewHolder> {
    List<Entre> entreList;
    int y;
    static   int je;
    Entre entre;
    OnRecycleViewItemClicker Listener;
    public static String username, useraddress, useremail, usernumber, goodsname, goodprice, count;
    public class dxViewHolder extends RecyclerView.ViewHolder{
       TextView demandname;
        View vbe;
        RelativeLayout wholeentre;
        public dxViewHolder(View view){
            super(view);
            vbe = view;
            demandname = (TextView)vbe.findViewById(R.id.demandname);

            wholeentre = (RelativeLayout)vbe.findViewById(R.id.wholeentre);
            view.setClickable(true);
        }
    }
    public EntreAdapter (List<Entre> dentre){
        this.entreList = dentre;
        y = this.getItemCount();
    }

    @Override
    public dxViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View celteme = LayoutInflater.from(parent.getContext()).inflate(R.layout.entrepren,parent,false);
        return new dxViewHolder(celteme);
    }

    @Override
    public void onBindViewHolder(dxViewHolder holder, int position) {
        entre = entreList.get(position);
        je = position;
        holder.demandname.setText(entre.getUsername());

        holder.wholeentre.setOnClickListener(wholeSubListener);


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
            return entreList.size();
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
