package com.mycompany.myapp.bframework;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Paul on 12/6/2017.
 */
public class FirstCommentAdapter extends RecyclerView.Adapter<FirstCommentAdapter.yxViewHolder> {
    List<CommentHolder> commentHolderList;
    int y;
    static   int je;
    int oyi=0;
    int moyi=0;
    CommentHolder commentHolder;
    OnRecycleViewItemClicker Listener;

    public class yxViewHolder extends RecyclerView.ViewHolder{
        TextView theName;
        ImageView theImage;
        View vm;
        RelativeLayout wholelasubbusinessy;
        public yxViewHolder(View view){
            super(view);
            vm = view;
            theName = (TextView)vm.findViewById(R.id.thename);
            wholelasubbusinessy = (RelativeLayout)vm.findViewById(R.id.wholecomment);
            view.setClickable(true);
        }
    }
    public FirstCommentAdapter (List<CommentHolder> croment){
        this.commentHolderList  = croment;
        y = this.getItemCount();
    }

    @Override
    public yxViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View celtrem = LayoutInflater.from(parent.getContext()).inflate(R.layout.morecomment,parent,false);
        return new yxViewHolder(celtrem);
    }
    View.OnClickListener  onClickView = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };
    @Override
    public void onBindViewHolder(yxViewHolder holder, final int position) {
        commentHolder = commentHolderList.get(position);
        je = position;


       holder.theName.setText(commentHolder.getTheName());
        holder.wholelasubbusinessy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Listener.OnRecycleViewItemclicked(position);
            }
        });


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
            return commentHolderList.size();
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
