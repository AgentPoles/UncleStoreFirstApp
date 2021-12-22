package com.mycompany.myapp.bframework;

import android.support.v7.widget.RecyclerView;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Paul on 11/29/2017.
 */
public class SecondCommentAdapter extends RecyclerView.Adapter<SecondCommentAdapter.pyViewHolder> {
    private List<Comment> cromentLists;
    int i;

    public class  pyViewHolder extends RecyclerView.ViewHolder {
        public TextView datebs, titlebs, titlegs, thenamegs, thenamebs, dategs, timebs, timegs;
        RelativeLayout lred, lbluebs, lgreens;
        View view;
        public pyViewHolder(View viewr) {

            super(viewr);
            view =viewr;
            titlebs = (TextView) view.findViewById(R.id.titlebs);
            datebs = (TextView) view.findViewById(R.id.datebs);
            dategs = (TextView) view.findViewById(R.id.dategs);
            timebs = (TextView) view.findViewById(R.id.timebs);
            timegs = (TextView) view.findViewById(R.id.timegs);
            titlegs = (TextView) view.findViewById(R.id.titlegs);
            thenamebs = (TextView) view.findViewById(R.id.thenamebs);
            thenamegs = (TextView) view.findViewById(R.id.thenamegs);

            lbluebs = (RelativeLayout) view.findViewById(R.id.lbluebs);
            lgreens = (RelativeLayout) view.findViewById(R.id.lgreens);



        }
    }
    public SecondCommentAdapter(List<Comment> scromentLists){
        this.cromentLists = scromentLists;
        i= this.getItemCount();
    }

    @Override
    public pyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemViews = LayoutInflater.from(parent.getContext()).inflate(R.layout.reciocomment, parent, false);
        return new pyViewHolder(itemViews);
    }

    @Override
    public void onBindViewHolder(pyViewHolder holder, int position) {
        Comment comment = cromentLists.get(position);
        holder.titlebs.setText(comment.getBody());
        holder.titlegs.setText(comment.getBody());
        holder.thenamebs.setText(comment.getFromwho());
        holder.thenamegs.setText(comment.getFromwho());
        holder.dategs.setText(comment.getDatre());
        holder.datebs.setText(comment.getDatre());
        holder.timebs.setText(comment.getTimre());
        holder.timegs.setText(comment.getTimre());
        holder.lbluebs.setVisibility(holder.view.VISIBLE);
        holder.lgreens.setVisibility(holder.view.GONE);
        if (comment.getTypi() == 1) {
            holder.lgreens.setVisibility(holder.view.VISIBLE);
            holder.lbluebs.setVisibility(holder.view.GONE);
        }


    }

    @Override
    public int getItemCount() {
        try {
            return cromentLists.size();
        } catch (Exception e) {
        }
        return 0;
    }
}

