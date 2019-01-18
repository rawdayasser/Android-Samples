package com.example.rawda.widgets_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView = findViewById(R.id.web_view);
        String data = "<html><body>Web View</body></html>";
        //myLoadData(data);
        /////////////file:///android_asset/filename
        //loadFile("file:///android_asset/index.htm");
        webView.loadUrl("https://www.github.com/");
    }
    private void loadFile(String path){
       webView.loadUrl(path);
    }
    private void myLoadData(String data){
        webView.loadData(data, "text/html", "UTF-8");
    }
}
