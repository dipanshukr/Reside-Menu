package com.kumar.dipanshu.residemenu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class OptionActivity extends AppCompatActivity implements View.OnClickListener {

    Button horizontalReside, verticalReside, cornerReside;
    Intent intent;
    AdView mAdView;
    InterstitialAd interstitialAd;
    FloatingActionButton gitHubFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        MobileAds.initialize(this, getString(R.string.App_ID));
        showBannerAds();
        loadInterstitialAds();
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        }

        horizontalReside = (Button) findViewById(R.id.horizontalResideButton);
        verticalReside = (Button) findViewById(R.id.verticalResideButton);
        cornerReside = (Button) findViewById(R.id.cornerResideButton);

        gitHubFab = (FloatingActionButton) findViewById(R.id.gitHubFabButton);
        gitHubFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://github.com/dipanshukr/Reside_Menu";
                Intent intentGithub = new Intent(Intent.ACTION_VIEW);
                intentGithub.setData(Uri.parse(url));
                startActivity(intentGithub);
            }
        });

        horizontalReside.setOnClickListener(this);
        verticalReside.setOnClickListener(this);
        cornerReside.setOnClickListener(this);
    }

    private void loadInterstitialAds() {
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.Interstitial_ad_id));
        interstitialAd.loadAd(new AdRequest.Builder().build());
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                interstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });
    }

    private void showBannerAds() {
        mAdView = (AdView) findViewById(R.id.bannerAd);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.horizontalResideButton:
                intent = new Intent(OptionActivity.this, MainActivity.class);
                intent.putExtra(Constant.OPTION, Constant.HORIZONTAL_RESIDE);
                startActivity(intent);
                break;
            case R.id.verticalResideButton:
                intent = new Intent(OptionActivity.this, MainActivity.class);
                intent.putExtra(Constant.OPTION, Constant.VERTICAL_RESIDE);
                startActivity(intent);
                break;
            case R.id.cornerResideButton:
                intent = new Intent(OptionActivity.this, MainActivity.class);
                intent.putExtra(Constant.OPTION, Constant.CORNER_RESIDE);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        }
    }
}