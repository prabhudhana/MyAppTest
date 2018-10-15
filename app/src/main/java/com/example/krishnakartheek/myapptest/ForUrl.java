package com.example.krishnakartheek.myapptest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.Log;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForUrl extends AppCompatActivity {
    private static final String TAG = "Dhan";

    TextView textView;

    //final String data="<p> This buy stop order may be executable because the stop price of 7.5 is less than or equal to the last trade or last closing price of 9.6. Please use following to accept the disclosures. <a href=\"https://www.schwab.com/public/schwab/nn/legal_compliance/important_notices/terms.html\">Risk Disclosure Statements for Futures and Options </a></p>";
     String data="<p> We’d love to help you, but the reality is that not every question gets answered.Please vist www.stackexchange.com for more drtails <a href=\"https://stackoverflow.com/questions/25451744/cant-go-back-in-webviews\">click here</p>";
    String urls;
    String mainData;
    Pattern sPattern;
    WebView mWebView;
    ProgressBar progressBar;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_url);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        textView=(TextView)findViewById(R.id.textView);
        //textView.setMovementMethod(LinkMovementMethod.getInstance());
        //Linkify.addLinks(textView,Linkify.ALL);
        textView.setText(Html.fromHtml(data));
        textView.setLinkTextColor(Color.BLUE);

        textView.setLinksClickable(true);

        textView.setMovementMethod(LinkMovementMethod.getInstance());

     /* textView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Uri uri=Uri.parse(data);
              String name= uri.getQueryParameter("link id");
              System.out.println("Data to data   "+name);
              //Matcher m = Pattern.compile("\\?([^)]+)\\?").matcher(data);
             *//* Matcher m = Pattern.compile("\\[(.*?)\\]").matcher(data);
              while (m.find()){
                  name= m.group();
              }*//*
              String answer = data.substring(data.indexOf("[")+1,data.indexOf("]"));
              Toast.makeText(ForUrl.this, answer, Toast.LENGTH_SHORT).show();
          }
      });
*/

        textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Uri uri=Uri.parse(data);
               String name= uri.getQueryParameter("linkid");

                Matcher m = Pattern.compile("\\{([^)]+)\\}").matcher(data);
                while (m.find()){
                   name= m.group();
                }
                Toast.makeText(ForUrl.this, name, Toast.LENGTH_SHORT).show();
                return false;
            }
        });


        extractLinks(data);
        mWebView=(WebView)findViewById(R.id.mwebview);
        mWebView.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String request) {

                view.loadUrl(extractLinks(data));


                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                progressBar.setVisibility(View.GONE);
            }
        });

        mWebView.loadUrl("https://stackoverflow.com/questions/25451744/cant-go-back-in-webviews");



    }


    public String extractLinks(String text) {
        Matcher m = Patterns.WEB_URL.matcher(text);
        if(m.find()) {
            mainData=m.group();
            Log.i(TAG,mainData);


        }

        return mainData;
    }
}
