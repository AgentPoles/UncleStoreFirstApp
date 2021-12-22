package com.mycompany.myapp.bframework;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class InnerCommet extends AppCompatActivity {
    RecyclerView innerreci;
    FloatingActionButton sendcomment;
    List<Comment> commentList = new ArrayList<>();
    SecondCommentAdapter secondCommentAdapter;
    String sinfoautho;
    String sinfobody;
    String sinfotitle;
    int protition;
    TextView thenameb;
    ActionBar gh;
    View r;
    Intent myIntent;
    Bundle myBundle;
    EditText getcomment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.innercomment);
        myIntent = getIntent();
        myBundle = myIntent.getExtras();
        thenameb = (TextView)findViewById(R.id.thenameb);
        innerreci = (RecyclerView)findViewById(R.id.innerreci);
        sendcomment = (FloatingActionButton)findViewById(R.id.sendcomment);
        sendcomment.setOnClickListener(sendcommentListener);
        secondCommentAdapter = new SecondCommentAdapter(CommentFragment.ryy);
        RecyclerView.LayoutManager mlayoutManager = new LinearLayoutManager(this);
        innerreci.setLayoutManager(mlayoutManager);
        gh = getSupportActionBar();
        gh.hide();
        innerreci.setItemAnimator(new DefaultItemAnimator());
        innerreci.setAdapter(secondCommentAdapter);
        getcomment = (EditText)findViewById(R.id.getcomment);
        protition = myBundle.getInt("position");
        thenameb.setText(CommentFragment.cemmentList.get(protition).getTheName());
    }
       View.OnClickListener sendcommentListener = new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              Comment cot = new Comment(CommentFragment.cemmentList.get(protition).getTheName(), "you",1,getcomment.getText().toString(),"19/01/2018","4.04");
               CommentFragment.ryy.add(cot);
               secondCommentAdapter.notifyDataSetChanged();
               getcomment.setText(null);

           }
       };
}
