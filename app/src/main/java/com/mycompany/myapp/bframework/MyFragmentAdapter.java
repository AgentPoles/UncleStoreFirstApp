package com.mycompany.myapp.bframework;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Paul on 11/23/2017.
 */
public class MyFragmentAdapter extends FragmentStatePagerAdapter {

    private static int positio;
//   private List<Fragment> fragments;
    public MyFragmentAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new BusinessFragment();
            case 2:
                return new InformationFragment();
            case 3:
                return new BlankFragment();
           case 4:
             return new CommentFragment();
          case 5:
                return new Spicer();
            case 6:
                return new Spicernexts();
        }
        return null;
    }

    @Override
    public int getCount(){
     return 7;
    }

    @Override
    public CharSequence getPageTitle(int position) {
switch (position){
    case 0: return "Home";
    case 1: return "Business";
    case 2: return "Information";
    case 3: return "FrameSpice";
    case 4: return "Interact";
    case 5: return "Spicer";
    case 6: return "Spicenext";
}
        return null;
    }

}
