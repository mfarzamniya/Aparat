package com.example.aparat.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.aparat.R;
import com.example.aparat.databinding.ActivityPrivacyPolicyBinding;

public class PrivacyPolicyActivity extends AppCompatActivity {

    ActivityPrivacyPolicyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrivacyPolicyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.webview.loadUrl("https://android-learn.ir");
        binding.webview.getSettings().setJavaScriptEnabled(true);

        binding.webview.setWebViewClient(new MyWebview());
    }

    public class MyWebview extends WebViewClient {

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
        }
    }



}