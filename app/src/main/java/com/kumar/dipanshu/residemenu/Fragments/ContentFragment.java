package com.kumar.dipanshu.residemenu.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kumar.dipanshu.residemenu.R;

public class ContentFragment extends Fragment {

    public ContentFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_content, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView gitHub = (ImageView) view.findViewById(R.id.gitHubImageView);
        TextView codeGitHub = (TextView) view.findViewById(R.id.gitHubTextView);

        gitHub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://github.com/dipanshukr/Reside_Menu";
                Intent intentGithub = new Intent(Intent.ACTION_VIEW);
                intentGithub.setData(Uri.parse(url));
                startActivity(intentGithub);
            }
        });
        codeGitHub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://github.com/dipanshukr/Reside_Menu";
                Intent intentGithub = new Intent(Intent.ACTION_VIEW);
                intentGithub.setData(Uri.parse(url));
                startActivity(intentGithub);
            }
        });
    }
}