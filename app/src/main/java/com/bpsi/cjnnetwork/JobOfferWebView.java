package com.bpsi.cjnnetwork;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class JobOfferWebView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taining_web_view);
        WebView mywebview = (WebView) findViewById(R.id.webview);
        mywebview.getSettings().setJavaScriptEnabled(true);
        mywebview.loadUrl("https://www.cjnnow.com/job-offer");


        mywebview.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.endsWith(".pdf")) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));

                    return true;
                }
                return false;
            }
        });
    }
}