package com.bpsi.cjnnetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TainingWebView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taining_web_view);
        WebView mywebview = (WebView) findViewById(R.id.webview);
        mywebview.getSettings().setJavaScriptEnabled(true);
        mywebview.loadUrl("https://www.cjnnow.com/training");
        mywebview.setWebViewClient(new WebViewClient());
    }
}