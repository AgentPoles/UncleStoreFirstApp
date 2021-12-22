package com.mycompany.myapp.bframework;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    TextView signind, signup, myAccount, load,loadb, loadc;
    Dialog m;
    private onlogin menol;
    private onregister regol;
    public static String DATA = "data";
   ImageView unlock;
    EditText unname, unpassi;
    unlocki croll;
    public static String nname, npassword;
    SharedPreferences mySharepreferences;
    SharedPreferences.Editor thisEditor;
    ScaleAnimation Rollout, Rollin;
    TranslateAnimation translatea, translateb, translatec;
    Intent i, j;

    TextView noaccount;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.content_main, container, false);
        signind = (TextView)v. findViewById(R.id.signind);
        signup = (TextView)v. findViewById(R.id.signup);
        load = (TextView)v.findViewById(R.id.load);
        loadb = (TextView)v.findViewById(R.id.loadb);
        MainActivity.myBar.show();
        loadc = (TextView)v.findViewById(R.id.loadc);
        i = new Intent(getActivity(), Signupe.class);
        j = new Intent(getActivity(), Myaccount.class);
        myAccount = (TextView)v. findViewById(R.id.myaccount);
      signind.setOnTouchListener(inTouchlistener);
        translatea = new TranslateAnimation(0,0,0,10);
        translateb = new TranslateAnimation(0,0,0,-10);
        translatec = new TranslateAnimation(0,0,0,10);
        Rollout = new ScaleAnimation(1,1,0,1);
        Rollin = new ScaleAnimation(1,1,1,0);
        Rollin.setDuration(400);
        Rollout.setDuration(400);
        translatea.setDuration(100);
        translateb.setDuration(100);
        translatea.setStartOffset(200);
        translateb.setRepeatCount(4);
        translatea.setRepeatCount(4);
        translatec.setDuration(100);
        translateb.setStartOffset(300);
        translatec.setRepeatCount(4);
        translatec.setStartOffset(400);
       signup.setOnTouchListener(upTouchlistener);
      myAccount.setOnTouchListener(accountTouchlistener);
        m = new Dialog(getActivity());
        m.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        m.getWindow().setLayout(350, 430);
        m.setContentView(R.layout.signin);
        unlock = (ImageView)m.findViewById(R.id.unlock);
        unname = (EditText)m.findViewById(R.id.unname);
        unpassi = (EditText)m.findViewById(R.id.unpassi);
        noaccount = (TextView) m.findViewById(R.id.noaccount);
        unlock.setOnClickListener(unlockListener);
//        unlock.setOnClickListener(unlockClickListener);
        return  v;
    }
    View.OnClickListener unlockListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           String ooi =  unname.getText().toString();
            String ooim  = unpassi.getText().toString();
            if(ooi.equals(null)){
                displaya("please enter email");
                unname.setTextColor(Color.RED);
            }
            else{
                if(ooim.equals(null)){
                    displaya("please enter password");
                    unpassi.setTextColor(Color.RED);
                }
            }
                 croll.unlock(ooi, ooim);
        }
    };
 View.OnClickListener unlockClickListener = new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         nname = unname.getText().toString();
         npassword = unpassi.getText().toString();
         menol.trylogin();
//         if(!unname.getText().toString().equals(Signupe.mySharedPreference.getString("yourname","puremadnessws"))){
//             displaya(Signupe.mySharedPreference.getString("yourname",null));
//             displaya("sorry dear you are not registered");
//         }
//         else {
//             if(!unpassi.getText().toString().equals(Signupe.mySharedPreference.getString("yourpassword","sososocrazoic"))){
//                 displaya("wrong password entered");
//             }
//             else{
//                 displaya("Friend, Welcome to the Framework!/n Mr Poles is glad that you're here");
//                 m.cancel();
//             }
//         }
     }
 };


    public interface unlocki{
        public void unlock(String a, String b);
    }
   View.OnTouchListener inTouchlistener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            load.startAnimation(translatea);
            loadb.startAnimation(translateb);
            loadc.startAnimation(translatec);
            CountDownTimer timer = new CountDownTimer(1000,1500) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    m.show();
                }
            }.start();

            return true;
        }
    };
    View.OnTouchListener upTouchlistener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            load.startAnimation(translatea);
            loadb.startAnimation(translateb);
            loadc.startAnimation(translatec);
            CountDownTimer timer = new CountDownTimer(1000,1500) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    startActivityForResult(i,1);
                }
            }.start();

            return false;
        }
    };
    View.OnTouchListener accountTouchlistener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            load.startAnimation(translatea);
            loadb.startAnimation(translateb);
            loadc.startAnimation(translatec);
            CountDownTimer timer = new CountDownTimer(1000,1500) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    startActivity(j);
                }
            }.start();

            return false;
        }
    };

 public void displaya(String k){
     Toast.makeText(getContext(),k,Toast.LENGTH_LONG).show();
 }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

//    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);
        try{
            regol =(onregister)activity;
            croll = (unlocki)activity;
        }
        catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+"must implement interface");
        }
        try{
            menol = (onlogin)activity;
        }
        catch (ClassCastException o){
            throw new ClassCastException( activity.toString() + "must implement onlogin");
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1){
            if(resultCode==2){

         regol.registered();
            }
        }
    }
    public interface onregister{
        public void registered();
    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    public interface onlogin{
        public void trylogin();
    }
}
