package com.paulwoodiii.browseragain;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText addressBar;
    Button backButton;
    Button forwardButton;
    Button goButton;
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addressBar = (EditText) findViewById(R.id.addressBar);
        backButton = (Button) findViewById(R.id.back);
        forwardButton = (Button) findViewById(R.id.forward);
        goButton = (Button) findViewById(R.id.go);
        web = (WebView) findViewById(R.id.web);

        backButton.setOnClickListener(this);
        forwardButton.setOnClickListener(this);
        goButton.setOnClickListener(this);

        WebViewClient client = new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                addressBar.setText(url);
            }
        };
        web.setWebViewClient(client);
    }

    @Override
    public void onClick(View v) {
        System.out.println("Clicked: " + v);
        if (v == backButton) {
            web.goBack();
        } else if (v == forwardButton) {
            web.goForward();
        } else if (v == goButton) {
            String url  = addressBar.getText().toString();
            if (!url.startsWith("http")){
                url = "http://" + url;
            }
            web.loadUrl(url);
        }
    }

    public void onUpdate(){

    }

}
