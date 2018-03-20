package com.kumar.dipanshu.residemenu.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kumar.dipanshu.residemenu.R;

public class SecondMenuFragment extends Fragment {

    public SecondMenuFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second_menu, container, false);
    }

}