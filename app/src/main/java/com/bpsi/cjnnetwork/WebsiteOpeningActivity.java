package com.bpsi.cjnnetwork;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WebsiteOpeningActivity extends AppCompatActivity {
    WebView webView;
    ProgressBar progressBar;
    Intent intent = getIntent();
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website_opening);
//        EdgeToEdge.enable(this);
        try{
            String url = intent.getStringExtra("url");
            Log.d("WebError11111", url );
            webView = findViewById(R.id.websiteView);
            progressBar = findViewById(R.id.prgBar);
            webView.setWebViewClient(new WebViewClient(){
                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    progressBar.setVisibility(View.VISIBLE);
                    super.onPageStarted(view, url, favicon);
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    progressBar.setVisibility(View.GONE);
                    super.onPageFinished(view, url);
                }
            });
            assert url != null;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    webView.loadUrl(url);
                }
            },500);
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
        }
        catch (Exception e){
            Log.e("WebError11111", e.getMessage() );
        }


    }


    public void onBackPressed() {

        if(webView.canGoBack()){
            webView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}
