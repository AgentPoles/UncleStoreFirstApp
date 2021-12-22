package com.mycompany.myapp.bframework;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InformationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InformationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InformationFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView informs;
    FloatingActionButton comment;
    List<Info> InfoLists = new ArrayList<>();
    InfoAdapter infoAdapter;
    String sinfoautho;
    String sinfobody;
    String sinfotitle;
    View r;
    EditText mycommente;
    Dialog neb;
   FloatingActionButton commentredone;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public InformationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InformationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InformationFragment newInstance(String param1, String param2) {
        InformationFragment fragment = new InformationFragment();
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
        View vo = inflater.inflate(R.layout.fragment_information, container, false);
        informs = (RecyclerView)vo.findViewById(R.id.informs);
        comment = (FloatingActionButton) vo.findViewById(R.id.comment);
        comment.setOnClickListener(commentListener);
        infoAdapter = new InfoAdapter(InfoLists);
        RecyclerView.LayoutManager mlayoutManager = new LinearLayoutManager(getContext());
        neb = new Dialog(getActivity());
        neb.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        neb.setContentView(R.layout.comments);
        Info j = new Info("use the framee","Ann");
        InfoLists.add(j);
        MainActivity.myBar.hide();
        infoAdapter.notifyDataSetChanged();
        commentredone = (FloatingActionButton)neb.findViewById(R.id.commentdone);
        commentredone.setOnClickListener(commentredoneListener);
        mycommente = (EditText)neb.findViewById(R.id.mycomment);
        informs.setLayoutManager(mlayoutManager);
        informs.setItemAnimator(new DefaultItemAnimator());
        informs.setAdapter(infoAdapter);
        return vo;
    }
 View.OnClickListener commentredoneListener = new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         if(mycommente.getText()==null||mycommente.getText().toString().equals("")){
             displayu("you have not entered any comment");
             mycommente.setHintTextColor(Color.RED);
             mycommente.setHint("please enter your comment");
         }
         else{
             displayu("comment sent");
             neb.cancel();
             mycommente.setText(null);
         }
     }
 };
    View.OnClickListener commentListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        /*    r = view;
            sinfoautho = "The Founding Father Abboyz..";
            sinfobody = "Abboyz is making the Price of their PureWater #170 per bag Due to Logistics in Home DElivery";
            sinfotitle = "Abboyz is making the Price of their PureWater #170";
            Info info = new Info(sinfotitle,sinfoautho);
            InfoLists.add(info);
            infoAdapter.notifyDataSetChanged();*/
            neb.show();

        }
    };
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
    public void displayu(String ki){
        Toast.makeText(getContext(),ki,Toast.LENGTH_LONG).show();
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
