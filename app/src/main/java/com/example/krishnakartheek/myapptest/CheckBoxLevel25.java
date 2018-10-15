package com.example.krishnakartheek.myapptest;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class CheckBoxLevel25 extends AppCompatActivity {

    TextView webURL;

    LinearLayout linearLayout;
    String[] names = {"https://www.schwab.com/public/schwab/nn/legal_compliance/important_notices/terms.html", "<p> This buy stop order may be executable because the stop price of 7.5 is less than or equal to the last trade or last closing price of 9.6. Please use following to accept the disclosures. <a href=\\\"https://www.schwab.com/public/schwab/nn/legal_compliance/important_notices/terms.html\\\">Risk Disclosure Statements for Futures and Options </a></p>", "Keanu", "Harry", "Katrina", "Peter", "Julia"};
    CheckBox[] ch;
    TextView[] tv;
    RadioButton radioButton;
    int chId = 1000;
    private int counter=0;
     TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box_level25);

        textView = (TextView) findViewById(R.id.textCheck);

        linearLayout = (LinearLayout) findViewById(R.id.linear);
        ch = new CheckBox[names.length];
        tv = new TextView[names.length];
        webURL=(TextView)findViewById(R.id.phonenumber);
        final SpannableString ss = new SpannableString("http://www.my.url.com?hey=nice");
        Linkify.addLinks(ss , Linkify.WEB_URLS);

        webURL.setText(ss);
        webURL.setMovementMethod(LinkMovementMethod.getInstance());

       // textViewUrl.setClickable(true);
        //textViewUrl.setText(Html.fromHtml("<a href=\\\"https://www.schwab.com/public/schwab/nn/legal_compliance/important_notices/terms.html\\\">Risk Disclosure Statements for Futures and Options </a>"));
        //Linkify.addLinks(textViewUrl,Linkify.WEB_URLS);

        for (int i = 0; i < names.length; i++) {
           // radioButton = new RadioButton(this);
            //radioButton.setText("Hello");

            ch[i] = new CheckBox(this);
            tv[i] = new TextView(this);

            ch[i].setId(chId++);
            System.out.println("CHID :: " + chId);
            System.out.println("I :: " + i);

            ch[i].setGravity(Gravity.LEFT);
            Linkify.addLinks(tv[i],Linkify.WEB_URLS);
            tv[i].setText(Html.fromHtml(names[i]));
           // tv[i].setMovementMethod(LinkMovementMethod.getInstance());
            linearLayout.addView(ch[i]);
            linearLayout.addView(tv[i]);
          //  linearLayout.addView(radioButton);
        }

        for (int i = 0; i < names.length; i++) {
            final int j = i;
            final TextView textView;
            textView = (TextView) findViewById(R.id.textCheck);
            ch[j].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    if (isChecked) {
                    counter++;

                        Toast.makeText(CheckBoxLevel25.this, "Checked", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(CheckBoxLevel25.this, "Un checked", Toast.LENGTH_SHORT).show();
                        counter--;
                    }

                    if(counter==names.length){
                        textView.setText("Place Order");
                        textView.setBackgroundColor(Color.BLUE);
                    }else {
                        textView.setText("");
                        textView.setBackgroundColor(Color.TRANSPARENT);
                    }

                }
            });






            }
        final RadioGroup rgpLevel = (RadioGroup) findViewById(R.id.levelRadioGroup);

        RadioButton[] radioButtons;
        radioButtons=new RadioButton[names.length];

        for(int k=0;k<names.length;k++){
            radioButtons[k]=new RadioButton(this);
            radioButtons[k].setText(names[k]);

            rgpLevel.addView(radioButtons[k]);
            //linearLayout.addView(rgpLevel);
        }
        rgpLevel.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rgpLevel.getCheckedRadioButtonId()!= -1){
                    Toast.makeText(CheckBoxLevel25.this, "Checked", Toast.LENGTH_SHORT).show();
                    textView.setText("");
                }else{
                    Toast.makeText(CheckBoxLevel25.this, "Not Checked", Toast.LENGTH_SHORT).show();

                }
            }
        });




























        }
    }

