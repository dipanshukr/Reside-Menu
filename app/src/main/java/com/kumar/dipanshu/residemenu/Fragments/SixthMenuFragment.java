package com.kumar.dipanshu.residemenu.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.kumar.dipanshu.residemenu.R;

public class SixthMenuFragment extends Fragment implements View.OnClickListener {


    public SixthMenuFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sixth_menu, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button share = (Button) view.findViewById(R.id.shareButton);
        Button about = (Button) view.findViewById(R.id.aboutButton);

        share.setOnClickListener(this);
        about.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shareButton:
                Toast.makeText(getContext(), "You clicked SHARE", Toast.LENGTH_SHORT).show();
                break;
            case R.id.aboutButton:
                Toast.makeText(getContext(), "You clicked ABOUT", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}