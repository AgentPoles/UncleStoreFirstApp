package com.mycompany.myapp.bframework;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment implements ColorAdapter.OnGridClickedListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    static List<SpiceUp> spiceUpList = new ArrayList<>();
    static SpiceAdapter spiceAdapter;
    RecyclerView recispice;
    View voespice;
    GridView thegrid;
    int resourceId;
    private ColorAdapter colorAdapter;
    ArrayList<String> commiuy = new ArrayList<>();
    FloatingActionButton spiceeadd, donne, proceed;
    RelativeLayout spicerr, spicernextr;
    SpiceUp spiceUp;
    RecyclerView.LayoutManager mospiceLayoutManager;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
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
        voespice = inflater.inflate(R.layout.fragment_blank2, container, false);
        recispice = (RecyclerView)voespice.findViewById(R.id.spicer);
        spiceAdapter = new SpiceAdapter(spiceUpList);
        spicerr = (RelativeLayout)voespice.findViewById(R.id.spicerr);
        spiceeadd = (FloatingActionButton)voespice.findViewById(R.id.spiceeadd);
        donne = (FloatingActionButton)voespice.findViewById(R.id.donne);
        proceed = (FloatingActionButton)voespice.findViewById(R.id.proceed);
        spicernextr = (RelativeLayout)voespice.findViewById(R.id.spicernextr);
        String waet ="Did you know you can get your egg, indomie and lot more delivered at your door steps?";
        String tracke =" order from";
        String contact = "08138537312";
        String namee = "ABBOYZ";
        mospiceLayoutManager = new GridLayoutManager(getContext(),3,GridLayoutManager.HORIZONTAL,false);
        recispice.setLayoutManager(mospiceLayoutManager);
        recispice.setItemAnimator( new DefaultItemAnimator());
        spiceUp = new SpiceUp(waet,tracke,contact,namee);
        spiceUpList.add(spiceUp);
        spiceeadd.setOnClickListener(spiceeListener);
        donne.setOnClickListener(donneListener);
        proceed.setOnClickListener(proceedListener);
        MainActivity.myBar.show();
        resourceId = R.layout.ingrud;
        thegrid = (GridView)voespice.findViewById(R.id.thegrid);

        colorAdapter = new ColorAdapter(getActivity(),resourceId,commiuy);

        colorAdapter.setOnItemClickedListener(this);
        commiuy.add("#eee6a4");
        commiuy.add("#ffffff");
        commiuy.add("#ff0089");
        commiuy.add("#eaeaed");
        commiuy.add("#e23425");
        commiuy.add("#234524");
        commiuy.add("#345363");
        commiuy.add("#356282");
        commiuy.add("#eae456");
        commiuy.add("#ee3674");
        commiuy.add("#fff08f");
        commiuy.add("#ff0349");
        commiuy.add("#eae23d");
        commiuy.add("#e23895");
        commiuy.add("#234ab4");
        commiuy.add("#345be3");
        commiuy.add("#3521c2");
        commiuy.add("#eae78d");
        colorAdapter.notifyDataSetChanged();
        thegrid.setAdapter(colorAdapter);
        recispice.setAdapter(spiceAdapter);
        spiceAdapter.notifyDataSetChanged();
        return voespice;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
View.OnClickListener spiceeListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
  spicerr.setVisibility(View.VISIBLE);
        spiceeadd.setVisibility(View.GONE);
        donne.setVisibility(View.VISIBLE);
    }
};

    @Override
    public void OnGridClicked(int position) {

    }

    View.OnClickListener donneListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            donne.setImageResource(R.drawable.edit);
            proceed.setVisibility(View.VISIBLE);
        }
    };
    View.OnClickListener proceedListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
      spicerr.setVisibility(View.GONE);
            spicernextr.setVisibility(View.VISIBLE);
        }
    };
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
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

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
