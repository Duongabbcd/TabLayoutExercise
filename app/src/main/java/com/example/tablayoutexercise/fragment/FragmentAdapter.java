package com.example.tablayoutexercise.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class FragmentAdapter extends FragmentStatePagerAdapter {
    private int numPage = 3;
    public FragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0 : return  new FragmentSuperCar() ;
            case 1 : return  new FragmentHyperCar() ;
            case 2 : return new FragmentMotorCycle();
            default:return new FragmentSuperCar() ;
        }
    }

    @Override
    public int getCount() {
        return numPage;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0 : return  "SuperCar" ;
            case 1 : return  "HyperCar" ;
            case 2 : return "MotorCycle";
            default:return "SuperCar" ;
        }
    }
}
