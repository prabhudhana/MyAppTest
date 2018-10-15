
package com.example.krishnakartheek.myapptest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.text.util.Linkify;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LinkyFyTest extends AppCompatActivity {
    private static final String TAG ="Dhan" ;
    TextView textView;
WebView webView;
    final String mimeType = "text/html";
    final String encoding = "UTF-8";
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linky_fy_test);

         //final String data="<p> This buy stop order may be executable because the stop price of 7.5 is less than or equal to the last trade or last closing price of 9.6. Please use following to accept the disclosures. <a href=\"https://www.schwab.com/public/schwab/nn/legal_compliance/important_notices/terms.html\">Risk Disclosure Statements for Futures and Options </a></p>";
          //String data= "http://www.google.com";
        //data="https://stackoverflow.com/questions/42146279/android-webview-href-not-support-in-html-page";
        //final String data="<a href=\"https://www.schwab.com/public/schwab/nn/legal_compliance/important_notices/terms.html\">Risk Disclosure Statements for Futures and Options </a>";
            String data="https://mobile-ua-service.streetsmartcentral.com/content/common/ox_disclosures.html";
        textView=(TextView)findViewById(R.id.textViewLinkyfy);
        webView=(WebView)findViewById(R.id.webView);

        textView.setMovementMethod(LinkMovementMethod.getInstance());
      // Linkify.addLinks(textView,Linkify.ALL);
        //textView.setText(Html.fromHtml(data));
        textView.setLinkTextColor(Color.BLUE);
        webView.clearCache(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

        /*textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                webView.setWebViewClient(new WebViewClient());
                String data= "http://www.google.com";
                webView.loadUrl(data);
                return false;
            }
        });*/


        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                //dialogProgressBar.setVisibility(View.VISIBLE);
                webView.setVisibility(View.GONE);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                if (url.startsWith("tel:")) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(url));
                    startActivity(intent);
                }else if(url.contains("pdf")){
                   url = "https://docs.google.com/viewer?embedded=true&url="+url;
                    view.loadUrl(url);
                }else{
                    view.loadUrl(url);
                }
                return true;

            }


            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                //dialogProgressBar.setVisibility(View.GONE);
                webView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
                view.loadUrl("file:///android_asset/error.html");
                //dialogProgressBar.setVisibility(View.GONE);
                webView.setVisibility(View.VISIBLE);

            }
        });

        webView.loadUrl(data);
        webView.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event){
                if(event.getAction() == KeyEvent.ACTION_DOWN){
                    WebView webView = (WebView) v;
                    switch(keyCode){
                        case KeyEvent.KEYCODE_BACK:
                            if(webView.canGoBack()){
                                webView.goBack();
                                return true;
                            }
                            break;
                    }
                }
                return false;
            }
        });
    }



/*

        CharSequence sequence = Html.fromHtml(data);
        SpannableStringBuilder strBuilder = new SpannableStringBuilder(sequence);
        UnderlineSpan[] underlines = strBuilder.getSpans(0, 10, UnderlineSpan.class);
        for(UnderlineSpan span : underlines) {
            int start = strBuilder.getSpanStart(span);
            int end = strBuilder.getSpanEnd(span);
            int flags = strBuilder.getSpanFlags(span);
            ClickableSpan myActivityLauncher = new ClickableSpan() {
                public void onClick(View view) {
                    Log.e(TAG, "on click");
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data));
                    startActivity(intent);
                }
            };
            strBuilder.setSpan(myActivityLauncher, start, end, flags);
        }
        textView.setText(strBuilder);
        textView.setLinksClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

*/



       // webView.loadDataWithBaseURL(null, data, "text/html", "utf-8", "");
        //String data="<p> This buy stop order may be executable because the stop price of 7.5 is less than or equal to the last trade or last closing price of 9.6. Please use following to accept the disclosures. <a href=\"https://www.schwab.com/public/schwab/nn/legal_compliance/important_notices/terms.html\">Risk Disclosure Statements for Futures and Options </a></p>";

       // webView.loadDataWithBaseURL("", data, mimeType, encoding, "");
       // webView.loadData(data,mimeType,encoding);





    }

