package com.example.bottomnavigationproject2.ui.naver;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bottomnavigationproject2.R;
import com.example.bottomnavigationproject2.ui.daum.DaumFragment;

public class NaverFragment extends Fragment {

    private NaverViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(NaverViewModel.class);
        View root = inflater.inflate(R.layout.fragment_naver, container, false);

        final WebView webView=root.findViewById(R.id.web_naver);
        webView.setWebViewClient(new MyWebViewClient());
        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                webView.loadUrl(s);
            }
        });
        return root;
    }
     class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {//웹뷰 안에서 웹페이지 보여줌
            return super.shouldOverrideUrlLoading(view, request);
        }


        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
        }
    }
}