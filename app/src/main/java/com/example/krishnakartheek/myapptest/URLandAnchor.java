package com.example.krishnakartheek.myapptest;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

public class URLandAnchor extends AppCompatActivity {
    String data = "<p> This buy stop order may be executable because the stop price of 7.5 is less than or equal to the last trade or last closing price of 9.6. https://www.google.com Please use following to accept the disclosures. <a href=\"https://stackoverflow.com/questions/25451744/cant-go-back-in-webviews\">click here<a> asdhugsfdhuf  <a href=\"https://www.google.com\">click here<a></p>";
    TextView textView;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urland_anchor);
        textView = (TextView) findViewById(R.id.text_url);
        textView.setLinkTextColor(Color.BLUE);
        textView.setText(data);
        Linkify.addLinks(textView,Linkify.ALL);



        webView = (WebView) findViewById(R.id.webView_url);
        //setTextViewHTML(textView,data);
        webView.setWebViewClient(new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {


            view.loadUrl(url);

            return true;
        }
        }

        );
    }
    private final void applyLink(final String url, int start, int end, Spannable text)
    {
        URLSpan span = new URLSpan(url)
        {
            @Override
            public void onClick(View widget)
            {
                //_onLinkClickListener.onLinkClicked(url);
                Toast.makeText(URLandAnchor.this, "HAi", Toast.LENGTH_SHORT).show();
            }
        };

        text.setSpan(span, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

   /* protected void setTextViewHTML(TextView text, String html) {
        CharSequence sequence = Html.fromHtml(html);
        SpannableStringBuilder strBuilder = new SpannableStringBuilder(sequence);
        URLSpan[] urls = strBuilder.getSpans(0, sequence.length(), URLSpan.class);
        for (URLSpan span : urls) {

            makeLinkClickable(strBuilder, span);
        }
        text.setText(strBuilder);
        Linkify.addLinks(text,Linkify.ALL);
        text.setMovementMethod(LinkMovementMethod.getInstance());
    }

    protected void makeLinkClickable(SpannableStringBuilder strBuilder, final
     span) {
        int start = strBuilder.getSpanStart(span);
        int end = strBuilder.getSpanEnd(span);
        int flags = strBuilder.getSpanFlags(span);
        ClickableSpan clickable = new ClickableSpan() {
            public void onClick(View view) {
                String url = span.getURL();
                webView.loadUrl(url);
            }
        };
        strBuilder.setSpan(clickable, start, end, flags);
        strBuilder.removeSpan(span);
    }
*/



}
