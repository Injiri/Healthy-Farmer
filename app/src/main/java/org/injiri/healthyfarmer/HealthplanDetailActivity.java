package org.injiri.healthyfarmer;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class HealthplanDetailActivity extends AppCompatActivity {

    WebView videosWebView;
    String prefix ="file:///android_asset/www/";
    final String postfix ="app.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthplan_detail);

        videosWebView = findViewById(R.id.videos_webview);

        videosWebView.setWebViewClient(new WebViewClient());
        videosWebView.loadUrl(prefix+postfix);

        WebSettings webSetting = videosWebView.getSettings();
        webSetting.setBuiltInZoomControls(true);
        webSetting.setJavaScriptEnabled(true);

    }

}
