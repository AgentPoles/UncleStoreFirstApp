package com.mycompany.myapp.bframework;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.FrameLayout;
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

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Polee extends AppCompatActivity {
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
       * user interaction before hiding the system UI.
     */
    TextView weee, wename;
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;
     FrameLayout frat;
    Dialog chirob;
    TextView hi;
    Intent dff;
    ActionBar ambar;
    String userid;
    EditText ednameb, ednumberb, edemailb, edaddressb, confpassyb, passyb;
    LinearLayout ally,brote, namel, emaill, addressl, numberl;
    ImageView finisgnb;
    public static String mnameb, maddressb, memailb, mnumberb, mpasswordb, madvertnob, mbusnumb, mtransnumb;
    TranslateAnimation gr, grm;
    ScaleAnimation vff;
    ImageView passyclickb;
    String poemailb, popasswordb;
Dialog vorifyb, wtt;
    Intent ui;
    Toast toast;
    public static String smname, smaddress, smemail, smnumber, smpassword;
    public static  int smadvertno, smbusnum, smtransnum;
    TextView loed,loedb, loedc;
    LinearLayout authe;
    ImageView ve, visibility;
    FirebaseAuth mAuthb;
    FirebaseDatabase mrdatabase;
    DatabaseReference mer, mret;
    int mk;
    RotateAnimation rety;
   int backer =0;
    EditText vemailb;
    ScaleAnimation Rollout, Rollin;
    TranslateAnimation translatea, translateb, translatec;
    int j =0;
    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
//    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
//                actionBar.show();
            }
//            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
//            hide();
        }
    };
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
//                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_polee);
       ambar = getSupportActionBar();
        ambar.hide();
        mVisible = true;
//        mControlsView = findViewById(R.id.fullscreen_content_controls);
        mContentView = findViewById(R.id.fullscreen_content);
        frat = (FrameLayout)findViewById(R.id.frat);
        ui = new Intent(Polee.this, MainActivity.class);
        ally = (LinearLayout)findViewById(R.id.ally);
        dff = new Intent(Polee.this,Introc.class);
      brote = (LinearLayout)findViewById(R.id.brote);
        namel = (LinearLayout)findViewById(R.id.namel);
        emaill = (LinearLayout)findViewById(R.id.emaill);
        addressl = (LinearLayout)findViewById(R.id.addressl);
        numberl = (LinearLayout)findViewById(R.id.numberl);
        ednameb = (EditText)findViewById(R.id.ednameb);

//        mySharedPreference = getSharedPreferences(HomeFragment.DATA,MODE_PRIVATE);
//        myEditor = mySharedPreference.edit();
        authe = (LinearLayout) findViewById(R.id.authe);
        chirob = new Dialog(this);
        chirob.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        chirob.setContentView(R.layout.passpi);
        confpassyb = (EditText)chirob.findViewById(R.id.confpassyb);
        passyb = (EditText)chirob.findViewById(R.id.passyb);
        mk = passyb.getInputType();
        visibility = (ImageView)chirob.findViewById(R.id.visibility);
        passyclickb = (ImageView)chirob.findViewById(R.id.passyclickb);
        passyclickb.setOnClickListener(passyclickbListener);
        mAuthb = FirebaseAuth.getInstance();
        edaddressb = (EditText)findViewById(R.id.edaddressb);
        ednumberb = (EditText)findViewById(R.id.ednumberb);
        hi = (TextView)findViewById(R.id.hi);
        edemailb = (EditText)findViewById(R.id.edemailb);
        finisgnb = (ImageView) findViewById(R.id.finisignb);
        visibility.setOnClickListener(visibilityClicker);
        loed = (TextView)findViewById(R.id.loed);
        loedb = (TextView)findViewById(R.id.loedb);
        loedc = (TextView)findViewById(R.id.loedc);
        vorifyb = new Dialog(this);
        vorifyb.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        vorifyb.setContentView(R.layout.verifyb);
        ve = (ImageView) vorifyb.findViewById(R.id.ve);
        ve.setOnClickListener(vListener);
        vemailb =(EditText)vorifyb.findViewById(R.id.vemailb);
        gr = new TranslateAnimation(400,0,0,0);
        gr.setDuration(1000);
         grm = new TranslateAnimation(0,0,800,0);
        grm.setDuration(1500);
         rety = new RotateAnimation(0,360,50,50);
        rety.setDuration(1000);

         vff = new ScaleAnimation(0,1,0,1);
         vff.setDuration(300);

        mrdatabase = FirebaseDatabase.getInstance();
        mer = mrdatabase.getReference("Users");
        mret = mrdatabase.getReference("EconValue");
        translateb = new TranslateAnimation(0,0,0,-20);
        translatec = new TranslateAnimation(0,0,0,20);
        translatea = new TranslateAnimation(0,0,0,20);
        Rollout = new ScaleAnimation(1,1,0,1);
        Rollin = new ScaleAnimation(1,1,1,0);
        Rollin.setDuration(400);
        Rollout.setDuration(400);

        translatea.setDuration(100);
        translateb.setDuration(100);
        translatea.setStartOffset(200);
        translateb.setRepeatCount(500);
        translatea.setRepeatCount(500);
        translatec.setDuration(100);
        translateb.setStartOffset(300);
        translatec.setRepeatCount(500);
        translatec.setStartOffset(400);

        CountDownTimer timer = new CountDownTimer(6000,300) {
            @Override
            public void onTick(long l) {

            }


            @Override
            public void onFinish() {
                 hi.setVisibility(View.INVISIBLE);
                frat.setVisibility(View.GONE);

                startActivityForResult(dff,0);
              displaye("swipe left");
            }

            }.start();
        finisgnb.setOnClickListener(finisgnbListener);
                // Set up the user interaction to manually show or hide the system UI.
        mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                toggle();
            }
        });







        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
//        findViewById(R.id.dummy_button).setOnTouchListener(mDelayHideTouchListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0){
            if(resultCode==4){
                hi.setVisibility(View.VISIBLE);
                ally.setVisibility(View.VISIBLE);
                ally.startAnimation(gr);
                CountDownTimer timers = new CountDownTimer(1500,200) {
                    @Override
                    public void onTick(long l) {

                    }


                    @Override
                    public void onFinish() {
                        finisgnb.setVisibility(View.VISIBLE);

                        finisgnb.startAnimation(vff);
                        finisgnb.startAnimation(rety);
                        brote.setVisibility(View.VISIBLE);
                        brote.startAnimation(grm);
                    }

                }.start();
            }
        }
    }

    View.OnClickListener vListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            vorifyb.cancel();
            poemailb= vemailb.getText().toString();
            popasswordb = mpasswordb;
            verification(poemailb,popasswordb);
        }
    };
    View.OnClickListener visibilityClicker = new View.OnClickListener() {
        @Override

        public void onClick(View view) {
            if (j == 0) {
                passyb.setInputType(InputType.TYPE_CLASS_NUMBER);
                confpassyb.setInputType(InputType.TYPE_CLASS_NUMBER);
                j=1;
            }
            else {
            if (j==1) {
                passyb.setInputType(mk);
                confpassyb.setInputType(mk);
                j = 0;
            }
            }
        }
    };
    public void verification(String a, String b){
        poemailb = a;
        popasswordb = b;
        loed.startAnimation(translatea);
        loedb.startAnimation(translateb);
        loedc.startAnimation(translatec);
        mAuthb.createUserWithEmailAndPassword(poemailb,popasswordb).
                addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            displaye("Account Creation Succesfull");
                            translatea.cancel();
                            translateb.cancel();
                            translatec.cancel();
                            if(TextUtils.isEmpty(userid)) {
                                userid = mAuthb.getUid();
                                displaye(userid);
                                smname = ednameb.getText().toString();
                                smemail = edemailb.getText().toString();
                                smaddress = edaddressb.getText().toString();
                                smnumber = ednumberb.getText().toString();
                                User user = new User(smname,popasswordb,poemailb, smnumber, smaddress);
                                Transaction jt = new Transaction(0, 0, 0);
                                mer.child(userid).setValue(user);
                                mret.child(userid).setValue(jt);
                                displaye("Account Creation you're logged in");
                                ednumberb.setText(null);
                                edemailb.setText(null);
                                edaddressb.setText(null);
                                ednameb.setText(null);
                                authe.setVisibility(View.INVISIBLE);
                                ui.putExtra("theid",userid);
                                startActivity(ui);
                            }
                        }
                        else {

                            FirebaseAuthException g = (FirebaseAuthException)task.getException();
                            displaye(g.toString());
                            translatea.cancel();
                            translateb.cancel();
                            translatec.cancel();
                            vemailb.setText(poemailb);
                            vorifyb.show();
                        }
                    }
                });
    }
    View.OnClickListener passyclickbListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(passyb.getText()==null||passyb.getText().toString().equals("")){
                displaye("please enter password");
            }
            else{
                if(passyb.getText().toString().length()<6){
                    displaye("please password should be 6 or more Characters");
                    passyb.setTextColor(Color.RED);

                }
                else{
                    if(!passyb.getText().toString().equals(confpassyb.getText().toString())){
                        displaye("First and second password do not match");
                         displaye(String.valueOf(passyb.getText().toString().length()));}
                    else{
                        mpasswordb = passyb.getText().toString();
                        passyb.setText(null);
                        confpassyb.setText(null);
                        chirob.cancel();
                        verification(memailb,mpasswordb);
                        namel.setVisibility(View.INVISIBLE);
                        addressl.setVisibility(View.INVISIBLE);
                        emaill.setVisibility(View.INVISIBLE);
                        numberl.setVisibility(View.INVISIBLE);
                        finisgnb.setVisibility(View.INVISIBLE);
                        hi.setVisibility(View.INVISIBLE);
                        authe.setVisibility(View.VISIBLE);
                       backer = 1;
                    }

                }
            }
        }
    };
    View.OnClickListener finisgnbListener =  new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            if (ednameb.getText() == null || ednameb.getText().toString().equals("")) {
                displaye("no name entered");
                ednameb.setSelected(true);
                ednameb.requestFocus();
                ednameb.setHintTextColor(Color.RED);
            } else {
                if (edemailb.getText() == null || edemailb.getText().toString().equals("")) {
                    displaye("no email address entered");
                    edemailb.setSelected(true);
                    edemailb.requestFocus();
                    ednameb.setHintTextColor(Color.RED);
                } else {
                    if (ednumberb.getText() == null || ednumberb.getText().toString().equals("")) {
                        displaye("no mobile number entered");
                        ednumberb.setSelected(true);
                        ednumberb.requestFocus();

                        ednumberb.setHintTextColor(Color.RED);
                    } else {

                        if (ednumberb.getText().toString().length() != 11) {
                            displaye(String.valueOf(ednumberb.getText().toString().length()));
                            displaye("wrong number count");
                            ednumberb.setTextColor(Color.RED);
                        } else {
                            if (edaddressb.getText() == null || edaddressb.getText().toString().equals("")) {
                                displaye("no address entered");
                                edaddressb.setSelected(true);
                                edaddressb.requestFocus();

                                ednumberb.setHintTextColor(Color.RED);

                            } else {


                                mnameb = ednameb.getText().toString();
                                maddressb = edaddressb.getText().toString();
                                mnumberb = ednumberb.getText().toString();
                                memailb = edemailb.getText().toString();
                                chirob.show();

                            }
                        }
                    }
                }
            }
        }

};

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(backer==1){
            authe.setVisibility(View.GONE);
            namel.setVisibility(View.VISIBLE);
            addressl.setVisibility(View.VISIBLE);
            emaill.setVisibility(View.VISIBLE);
            numberl.setVisibility(View.VISIBLE);
            finisgnb.setVisibility(View.VISIBLE);
            hi.setVisibility(View.VISIBLE);
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
                                Polee.this.finish();
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

    public void displaye(String m){
        Toast.makeText(this,m,Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
//        mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    @SuppressLint("InlinedApi")
    private void show() {
        // Show the system bar
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mVisible = true;

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }
}
