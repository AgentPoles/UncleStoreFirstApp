package com.mycompany.myapp.bframework;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Set;

import de.hdodenhof.circleimageview.CircleImageView;

public class Signupe extends AppCompatActivity{
    CircleImageView finisign;
   EditText edname, ednumber, edemail, edaddress, confpassy, passy;
    Dialog chirho;
    EditText vemail;
    ImageView v;
    TextView loid , loidb, loidc, authoo;
    Dialog vorify;
    TranslateAnimation translatea, translateb, translatec;
    ScaleAnimation Rollout, Rollin;
    String poemail, popassword;
    String userid;
    FirebaseAuth mAuth;
    FirebaseDatabase fdmb;
    DatabaseReference mdatabaseFirebase;
    int backer =0;
    LinearLayout namem, addressem, emailm, numberm;
   public static SharedPreferences mySharedPreference;
    public static String mname, maddress, memail, mnumber, mpassword, madvertno, mbusnum, mtransnum;
    SharedPreferences.Editor myEditor;
    ImageView passyclick;
    Set<String> toyi;
    Set<String> nameo;
    ArrayList<String> jarvis;
    Array ot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupe);
        edname = (EditText)findViewById(R.id.edname);
        mySharedPreference = getSharedPreferences(HomeFragment.DATA,MODE_PRIVATE);
        myEditor = mySharedPreference.edit();
        edaddress = (EditText)findViewById(R.id.edaddress);
        ednumber = (EditText)findViewById(R.id.ednumber);
        edemail = (EditText)findViewById(R.id.edemail);
        Toolbar toolbard = (Toolbar) findViewById(R.id.toolbare);
        edname.setHintTextColor(Color.DKGRAY);
        edemail.setHintTextColor(Color.DKGRAY);
        edaddress.setHintTextColor(Color.DKGRAY);
        ednumber.setHintTextColor(Color.DKGRAY);
        loid = (TextView)findViewById(R.id.loid);
        loidb = (TextView)findViewById(R.id.loidb);
        loidc = (TextView)findViewById(R.id.loidc);
        authoo = (TextView)findViewById(R.id.authoo);
        setSupportActionBar(toolbard);
//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        mAuth = FirebaseAuth.getInstance();

        fdmb = FirebaseDatabase.getInstance();
        mdatabaseFirebase = fdmb.getReference("Users");

       finisign = (CircleImageView) findViewById(R.id.finisign);
        finisign.setOnClickListener(finisignListener);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        vorify = new Dialog(this);
        vorify.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        vorify.setContentView(R.layout.verify);
       namem = (LinearLayout)findViewById(R.id.namem);
        emailm = (LinearLayout)findViewById(R.id.emailm);
        addressem = (LinearLayout)findViewById(R.id.addressm);
        numberm = (LinearLayout)findViewById(R.id.numberm);
        vemail =(EditText)vorify.findViewById(R.id.vemail);
        v = (ImageView) vorify.findViewById(R.id.v);
        v.setOnClickListener(vListener);
        chirho = new Dialog(this);
        chirho.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        chirho.setContentView(R.layout.dialogx);
        confpassy = (EditText)chirho.findViewById(R.id.confpassy);
        passy = (EditText)chirho.findViewById(R.id.passy);
        passyclick = (ImageView) chirho.findViewById(R.id.passyclick);
        passyclick.setOnClickListener(passyclickListener);
        translatea = new TranslateAnimation(0,0,0,20);
        translateb = new TranslateAnimation(0,0,0,-20);
        translatec = new TranslateAnimation(0,0,0,20);
        Rollout = new ScaleAnimation(1,1,0,1);
        Rollin = new ScaleAnimation(1,1,1,0);
        Rollin.setDuration(400);
        Rollout.setDuration(400);
        translatea.setDuration(100);
        translateb.setDuration(100);
        translatea.setStartOffset(200);
        translateb.setRepeatCount(500);
        translatea.setRepeatCount(500);
        translatec.setDuration(500);
        translateb.setStartOffset(300);
        translatec.setRepeatCount(4);
        translatec.setStartOffset(400);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    View.OnClickListener vListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            vorify.cancel();
            poemail = vemail.getText().toString();
            popassword = mpassword;
            verification(poemail,popassword);
        }
    };
    public void verification(String a, String b){
        poemail = a;
        popassword = b;
        loid.startAnimation(translatea);
        loidb.startAnimation(translateb);
        loidc.startAnimation(translatec);
         mAuth.createUserWithEmailAndPassword(poemail,popassword).
                addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            displaye("good");
                            translatea.cancel();
                            translateb.cancel();
                            translatec.cancel();
  if(TextUtils.isEmpty(userid)) {
      userid = mAuth.getUid();

      mname = edname.getText().toString();
      memail = edemail.getText().toString();
      maddress = edaddress.getText().toString();
      mnumber = ednumber.getText().toString();
      User user = new User(mname, poemail, mnumber, maddress);
      Transaction jt = new Transaction(0, 0, 0);
      mdatabaseFirebase.child(userid).setValue(user);
      mdatabaseFirebase.child(userid).setValue(jt);
      displaye("Account Creation you're logged in");
  }
                            authoo.setVisibility(View.GONE);
                            emailm.setVisibility(View.VISIBLE);
                            namem.setVisibility(View.VISIBLE);
                            addressem.setVisibility(View.VISIBLE);
                            numberm.setVisibility(View.VISIBLE);
                            finisign.setVisibility(View.VISIBLE);
                            passy.setText(null);
                            confpassy.setText(null);
                            chirho.cancel();
                            ednumber.setText(null);
                            edemail.setText(null);
                            edaddress.setText(null);
                            backer = 0;
                            finish();
                        }
                        else {

                            FirebaseAuthException g = (FirebaseAuthException)task.getException();
                            displaye(g.toString());
                            translatec.cancel();
                            translateb.cancel();
                            translatea.cancel();
                            vemail.setText(poemail);
                            vorify.show();
                        }
                    }
                });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(backer==1){
            authoo.setVisibility(View.GONE);
            namem.setVisibility(View.VISIBLE);
            addressem.setVisibility(View.VISIBLE);
            emailm.setVisibility(View.VISIBLE);
            numberm.setVisibility(View.VISIBLE);
            finisign.setVisibility(View.VISIBLE);
            backer=0;
        }
        else {
            if(backer==0){
                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("sure to leave the framework?")
                        .setCancelable(false)
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Signupe.this.finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        }
    }
    View.OnClickListener passyclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(passy.getText()==null||passy.getText().toString().equals("")){
                displaye("please enter password");
            }
            else{
                if(passy.getText().toString().length()<6){
                    displaye("please password should be 6 or more Characters");
                    passy.setTextColor(Color.RED);

                }
                else{

                    if(!passy.getText().toString().equals(confpassy.getText().toString())){
                        displaye("First and second password do not match");}

                        else{
                        mpassword = passy.getText().toString();

                        verification(memail,mpassword);
                        emailm.setVisibility(View.INVISIBLE);
                        namem.setVisibility(View.GONE);
                        addressem.setVisibility(View.INVISIBLE);
                        numberm.setVisibility(View.INVISIBLE);
                        finisign.setVisibility(View.GONE);
                        authoo.setVisibility(View.VISIBLE);
                        backer =1;
                        }

                }
            }
        }
    };





    View.OnClickListener finisignListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(edname.getText()==null||edname.getText().toString().equals("")) {
                displaye("no name entered");
                edname.setSelected(true);
                edname.requestFocus();
                edname.setHint("enter name");
                edname.setHintTextColor(Color.RED);
            }
                else {
                     if(edemail.getText()==null||edemail.getText().toString().equals("")){
                         displaye("no email address entered");
                         edemail.setSelected(true);
                         edemail.requestFocus();
                         edemail.setHint("enter email");
                         edname.setHintTextColor(Color.RED);
                     }
                else {
                         if(ednumber.getText() == null||ednumber.getText().toString().equals("")){
                             displaye("no mobile number entered");
                             ednumber.setSelected(true);
                             ednumber.requestFocus();
                             ednumber.setHint("enter mobile number");
                             ednumber.setHintTextColor(Color.RED);
                         }
                         else{
                             if(ednumber.getText().toString().length()!=11){
                                 displaye(String.valueOf(ednumber.getText().toString().length()));
                                 displaye("wrong number count");
                                 ednumber.setTextColor(Color.RED);
                             }
                             else {
                                 if (edaddress.getText() == null || edaddress.getText().toString().equals("")) {
                                     displaye("no address entered");
                                     edaddress.setSelected(true);
                                     edaddress.requestFocus();
                                     edaddress.setHint("enter Address");
                                     ednumber.setHintTextColor(Color.RED);

                                 } else {


                                     mname = edname.getText().toString();
                                 maddress = edaddress.getText().toString();
                                     mnumber = ednumber.getText().toString();
                                     memail = edemail.getText().toString();
                                     chirho.show();

                                 }
                             }
                         }
                     }
            }

        }
    };
    public void displaye(String m){
        Toast.makeText(this,m,Toast.LENGTH_LONG).show();
    }
}
