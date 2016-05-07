package com.example.rudolph.toomanyways;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

/**
 * Created by ivan on 28/04/16.
 */
public class ActWebView extends Activity {

    private WebView webView;

    /**
     * onCreate method
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ly_webview);

        // Create a WebView to display content
        webView = (WebView) findViewById(R.id.webView1);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl(getIntent().getExtras().getString("Url"));

        // Button Back
        Button btnBack = (Button) findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActSettings.usrxptmp <= 2) {
                    // loads MenuBeg intent -> ActMenuBeg.class
                    Intent intentMenuBeg = new Intent(ActWebView.this, ActMenuBeg.class);
                    startActivity(intentMenuBeg);
                    finish();
                } else if (ActSettings.usrxptmp > 2) {
                    // loads ActMenuAdv intent -> MenuAdvanced.class
                     Intent intentMenuAdv = new Intent(ActWebView.this, ActMenuAdv.class);
                     startActivity(intentMenuAdv);
                } else {
                    // reloads intent -> ActSettings.class
                    Intent intentReload = new Intent(ActWebView.this, ActSettings.class);
                    startActivity(intentReload);
                }
            }
        });

        // Button Share
        Button btnSh = (Button) findViewById(R.id.btn_share);
        btnSh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "The status update text");
                startActivity(Intent.createChooser(intent, "Dialog title text"));
            }
        });

        // Button About
        Button btnAb = (Button) findViewById(R.id.btn_abt);
        btnAb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActWebView.this, ActAbout.class);
                startActivity(intent);
            }
        });
    }
}
