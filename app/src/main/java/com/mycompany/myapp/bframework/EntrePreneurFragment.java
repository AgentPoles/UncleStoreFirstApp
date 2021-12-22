package com.mycompany.myapp.bframework;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EntrePreneurFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EntrePreneurFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EntrePreneurFragment extends Fragment implements EntreAdapter.OnRecycleViewItemClicker {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View vienda;
    Dialog roe;
    RecyclerView recre;
    TextView demandname,eusername, euseraddress,eusernumber, euseremail, egoodscount, egoodsname, egoodsprice, totalcost;
    static List<Entre> entriList = new ArrayList<>();
    static EntreAdapter entroyAdapter;
    private OnFragmentInteractionListener mListener;

    public EntrePreneurFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EntrePreneurFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EntrePreneurFragment newInstance(String param1, String param2) {
        EntrePreneurFragment fragment = new EntrePreneurFragment();
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
        vienda = inflater.inflate(R.layout.fragment_entre_preneur, container, false);
        entroyAdapter = new EntreAdapter(entriList);
        entroyAdapter.setOnItemclickedListener(this);
        recre = (RecyclerView)vienda.findViewById(R.id.recre);
        roe = new Dialog(getActivity());
        roe.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        roe.setContentView(R.layout.intoentrepen);
  MainActivity.myBar.hide();
        eusername = (TextView)roe.findViewById(R.id.eusername);
        euseraddress = (TextView)roe.findViewById(R.id.euseraddress);
        euseremail = (TextView)roe.findViewById(R.id.euseremail);
        eusernumber = (TextView)roe.findViewById(R.id.eusernumber);
        egoodscount = (TextView)roe.findViewById(R.id.egoodscount);
        egoodsname = (TextView)roe.findViewById(R.id.egoodsname);
        egoodsprice = (TextView)roe.findViewById(R.id.egoodsprice);
        totalcost = (TextView)roe.findViewById(R.id.totalcost);
        RecyclerView.LayoutManager nerManager =  new LinearLayoutManager(getContext());
        recre.setItemAnimator(new DefaultItemAnimator());
        recre.setLayoutManager( nerManager );
        recre.setAdapter(entroyAdapter);
        Entre awe = new Entre("God's Holy Grace","St Luthers Hostel Benin and all the Earth","HolySpirit@Heaven.com","11111111111","super pack","90","210");
        entriList.add(awe);
        entroyAdapter.notifyDataSetChanged();
return vienda;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void OnRecycleViewItemclicked(int position) {
        Entre endre = entriList.get(position);
        euseraddress.setText(endre.getUseraddress());
        euseremail.setText(endre.getUseremail());
        eusernumber.setText(endre.getUsernumber());
        eusername.setText(endre.getUsername());
        egoodscount.setText(endre.getCount());
        egoodsname.setText(endre.getGoodsname());
        egoodsprice.setText(endre.getGoodsprice());
        int ry =   Integer.parseInt(endre.getCount());
        int my = Integer.parseInt(endre.getGoodsprice());
        long ot = ry*my;
        totalcost.setText(String.valueOf(ot));
        roe.show();
    }

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
