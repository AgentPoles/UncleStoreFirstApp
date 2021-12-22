package com.mycompany.myapp.bframework;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CommentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CommentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CommentFragment extends Fragment implements FirstCommentAdapter.OnRecycleViewItemClicker {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView recomment;
    View vocomment;
    ActionBar jh;
    RecyclerView.LayoutManager mcommentLayoutManager;
    TextView inviteeco;
    Intent intrento;
    int span;
   static int oy = 0;
    public String totle;
    public String motto;
    Busi bosi;
  public  static List<Comment> ryy;
    static List<CommentHolder> cemmentList = new ArrayList<>();
    static FirstCommentAdapter cemmentAdapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CommentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CommentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CommentFragment newInstance(String param1, String param2) {
        CommentFragment fragment = new CommentFragment();
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
        // Inflate
        //
        //
        //
        // the layout for this fragment
        vocomment = inflater.inflate(R.layout.fragment_comment, container,false);
        recomment = (RecyclerView)vocomment.findViewById(R.id.recicommment);
        intrento = new Intent(getActivity(),InnerCommet.class);
        inviteeco = (TextView)vocomment.findViewById(R.id.inviteeco);
        cemmentAdapter= new FirstCommentAdapter(cemmentList);
        cemmentAdapter.setOnItemclickedListener(this);
//        Comment jy = new Comment("theFrame","david","i want more money rjrjrjjfjjfffjfjjffjfjf","19/01/2018","9.15pm");
//        CommentHolder mu = new CommentHolder(jy.getTowho(),2,jy);
//        Comment jye = new Comment("theFrames","david","i want more money rjrjrjjfjjfffjfjjffjfjf","19/01/2018","9.15pm");
//        CommentHolder mue = new CommentHolder(jye.getTowho(),2,jye);
//        Comment jyr = new Comment("theFramed","david","i want more money rjrjrjjfjjfffjfjjffjfjf","19/01/2018","9.15pm");
//        CommentHolder mur = new CommentHolder(jyr.getTowho(),2,jyr);
//        Comment jyk = new Comment("theFrame","morey","i want more money rjrjrjjfjjfffjfjjffjfjf","19/01/2018","9.15pm");
//        CommentHolder muk = new CommentHolder(jyk.getTowho(),2,jyk);
//        Comment jykl = new Comment("theFrame","morey","i want more money rjrjrjjfjjfffjfjjffjfjf","19/01/2018","9.15pm");
//        CommentHolder mukl = new CommentHolder(jykl.getTowho(),2,jykl);
//        Comment jyrw = new Comment("theFramed","davro","i want more moneyjdkdkdkkdk i am happy rjrjrjjfjjfffjfjjffjfjf","19/01/2018","9.15pm");
//        CommentHolder murw = new CommentHolder(jyrw.getTowho(),2,jyrw);
//        Comment jyrs= new Comment("theFramed","davawwd","i want more moneybut all of Jesus rjrjrjjfjjfffjfjjffjfjf","19/01/2018","9.15pm");
//        CommentHolder murs = new CommentHolder(jyrs.getTowho(),2,jyrs);
//
//        sortit(mu,cemmentList);
//        sortit(mur,cemmentList);
//        sortit(mue,cemmentList);
//        sortit(muk,cemmentList);
//        sortit(mukl,cemmentList);
//        sortit(murs,cemmentList);
//        sortit(murw,cemmentList);
         MainActivity.myBar.hide();
//        cemmentAdapter.notifyDataSetChanged();
        cemmentAdapter.notifyDataSetChanged();
        RecyclerView.LayoutManager merLayoutManger = new LinearLayoutManager(getActivity());
        recomment.setLayoutManager(merLayoutManger);
        recomment.setItemAnimator(new DefaultItemAnimator());
        inviteeco.setSelected(true);
        recomment.setAdapter(cemmentAdapter);

        return vocomment;
    }
 public static void  running(){
//    cemmentAdapter.notifyDataSetChanged();
}
    @Override
    public void OnRecycleViewItemclicked(int position) {
        CommentHolder hoolder = cemmentList.get(position);
        Toast.makeText(getContext(), String.valueOf(hoolder.getCommentsa().size()), Toast.LENGTH_LONG).show();
      ryy =   hoolder.getCommentsa();
        intrento.putExtra("position",position);
        startActivity(intrento);


    }

    public static void sortit( CommentHolder comment, List<CommentHolder> commentHolders){
        if(commentHolders.isEmpty()){
            commentHolders.add(comment);
        }
        else{
            for(int z = 0; z<commentHolders.size();z++){
                if(commentHolders.get(z).getTheName().equals(comment.getTheName())){
                    commentHolders.get(z).updatecoomentsa(comment.getTheComment());
                     oy =1;
                    break;
                }
            }
            if(oy==0){
                commentHolders.add(comment);
            }
            else {
                oy =0;
            }
        }
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
