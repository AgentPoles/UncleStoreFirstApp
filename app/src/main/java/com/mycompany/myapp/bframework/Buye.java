package com.mycompany.myapp.bframework;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BusinessFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BusinessFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Buye extends Fragment implements BusiAdapter.OnRecycleViewItemClicker {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    FloatingActionButton addoi;
    RecyclerView reci;
    View voer;
    RecyclerView.LayoutManager moLayoutManager;
    TextView invitee, oonumber;
    Intent intrent;
    int span;
    public String totle;
    public String motto;
    Busi bosi;
    Dialog ro;
    static List<Busi> bosiList = new ArrayList<>();
    static BusiAdapter bosiAdapter;
    TabLayout trabss;
    Fragment fragmenti;
    private int[] tabIcons = {
            R.drawable.buy,
            R.drawable.delivery
    };
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Buye() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BusinessFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Buye newInstance(String param1, String param2) {
        Buye fragment = new Buye();
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

        voer = inflater.inflate(R.layout.sorder, container, false);
                addoi = (FloatingActionButton)voer.findViewById(R.id.addoi);
        reci = (RecyclerView)voer.findViewById(R.id.reci);
        addoi.setOnClickListener(addoiListener);
        bosiAdapter = new BusiAdapter(bosiList);
        bosiAdapter.setOnItemclickedListener(this);
        span = 2;
        MainActivity.myBar.show();
        ro = new Dialog(getActivity());
        ro.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        ro.setContentView(R.layout.youto);
        intrent = new Intent(getActivity(),OrderHomee.class);
        RecyclerView.LayoutManager merLayoutManger = new GridLayoutManager(getContext(),2,GridLayoutManager.HORIZONTAL,false);
        reci.setLayoutManager(merLayoutManger);
        reci.setItemAnimator( new DefaultItemAnimator());
        totle = "ABBOYZ";
        motto = " delivery on the go..";
        bosi = new Busi(totle,motto,false);
        bosiList.add(bosi);
        bosiAdapter.notifyDataSetChanged();
        reci.setAdapter(bosiAdapter);
        oonumber = (TextView)ro.findViewById(R.id.oonumber);
        Linkify.addLinks(oonumber,Linkify.PHONE_NUMBERS);
        invitee = (TextView)voer.findViewById(R.id.invitee);
        invitee.setSelected(true);

//        reci.setOnTouchListener(reciListener);
        return  voer;
    }

    View.OnTouchListener reciToucher = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    };
    View.OnClickListener addoiListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ro.show();
        }
    };

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);
    }

    @Override
    public void OnRecycleViewItemclicked(int position) {
        startActivity(intrent);
    }
    //    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
}
