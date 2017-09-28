package com.example.artur.europemapapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class EuropeMapActivity extends AppCompatActivity {

    private WebView webView;

    public class WebAppInterface {
        /** Show a toast from svg */
        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(EuropeMapActivity.this, toast, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_europe_map);
        webView = (WebView) findViewById(R.id.wv_europe_map);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new WebAppInterface(), "Android");
        webView.getSettings().setDefaultTextEncodingName("utf-8");
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl("file:///android_asset/Europe.html");
    }
}