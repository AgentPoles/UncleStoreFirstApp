package com.mycompany.myapp.bframework;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Spicernexts.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Spicernexts#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Spicernexts extends Fragment implements ColorAdapter.OnGridClickedListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View voer;
    GridView thegrid;
    int resourceId;
    private ColorAdapter colorAdapter;
    ArrayList<String> commiuy = new ArrayList<>();
    private OnFragmentInteractionListener mListener;

    public Spicernexts() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Spicernexts.
     */
    // TODO: Rename and change types and number of parameters
    public static Spicernexts newInstance(String param1, String param2) {
        Spicernexts fragment = new Spicernexts();
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
        voer = inflater.inflate(R.layout.spicernext, container, false);
        resourceId = R.layout.ingrud;
        thegrid = (GridView)voer.findViewById(R.id.thegrid);

        colorAdapter = new ColorAdapter(getActivity(),resourceId,commiuy);

        colorAdapter.setOnItemClickedListener(this);
        commiuy.add("#eee6a4");
        commiuy.add("#ffffff");
        commiuy.add("#ff0089");

        colorAdapter.notifyDataSetChanged();
        thegrid.setAdapter(colorAdapter);
        return voer;
    }

    // TODO: Rename meth.od, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void OnGridClicked(int position) {

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
