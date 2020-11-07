package com.br.super7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class ComoActivity extends AppCompatActivity {
    private WebView webView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_como);
        //
        getSupportActionBar().show();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("COMO APOSTAR");
        getSupportActionBar().setSubtitle("Como funciona o Super Sete");
        //
        // inicio banner
        //AdView mAdView = new AdView(this);
        //mAdView.setAdSize(AdSize.BANNER);
        //mAdView.setAdUnitId("ca-app-pub-2381321693293442/6880206763");
        //mAdView = findViewById(R.id.adView_como);
        //AdRequest adRequest = new AdRequest.Builder()
        //        .build();
        //mAdView.loadAd(adRequest);
        // final banner
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/6880206763");
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mInterstitialAd.loadAd(adRequest);

        // final banner 2
        // setContentView(R.layout.html_layout); //load the layout XML file
        WebView mbrowser = (WebView) findViewById(R.id.activity_main_webview); //get the WebView from the layout XML
        mbrowser.loadUrl("file:///android_asset/comoapostar.html"); //set the HTML
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}