package com.bpsi.cjnnetwork;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class AssessmentWebView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taining_web_view);
        WebView mywebview = (WebView) findViewById(R.id.webview);
        mywebview.getSettings().setJavaScriptEnabled(true);
        mywebview.loadUrl("https://www.cjnnow.com/assessment");
        mywebview.setWebViewClient(new WebViewClient());
    }
}