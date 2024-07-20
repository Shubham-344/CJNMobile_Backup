package com.bpsi.cjnnetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bpsi.cjnnetwork.databinding.ActivityJobDescriptionBinding;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class JobDescription extends AppCompatActivity {
    private ActivityJobDescriptionBinding binding;
//    PDFView pdfViewer;
//    String pdfName = "https://dev.cjnnow.com/jobdetails/jobpdf/1710662914gxrM2WRSSv.pdf";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding= ActivityJobDescriptionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String pdfName = getIntent().getStringExtra("DocLink");
        Log.d("API_TAG", pdfName);
            // initializing our pdf view.
//            pdfViewer = findViewById(R.id.pdfViewer);
//            try{
//                Log.d("API_TAG", "in pdf viewer");
//                pdfViewer.fromUri(Uri.parse(pdfurl)).pages(0, 2, 1, 3, 3, 3)
//                        .enableSwipe(true)
//                        .swipeHorizontal(false)
//                        .enableDoubletap(true)
//                        .defaultPage(0)
//                        .enableAnnotationRendering(false)
//                        .password(null)
//                        .scrollHandle(null)
//                        .enableAntialiasing(true)
//                        .spacing(0)
//                        .load();
//            }
//            catch (Exception e){
//                Log.d("API_TAG", e.getMessage());
//            }
        WebView webView = (WebView) findViewById(R.id.pdfViewerWebView);
//        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://docs.google.com/gview?embbeded=true&url=https://dev.cjnnow.com/jobdetails/jobpdf/"+pdfName);

    }

    }
