package org.injiri.healthyfarmer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AgrovetshopActivity extends AppCompatActivity {

    WebView webView;
    String siteUrl = "https://fortest254.000webhostapp.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agrovetshop);

        webView = findViewById(R.id.agrovet_webview);

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(siteUrl);

        WebSettings webSetting = webView.getSettings();
        webSetting.setBuiltInZoomControls(true);
        webSetting.setJavaScriptEnabled(true);

    }

}
