package com.example.krishnakartheek.myapptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CheckBoxWithTextView extends AppCompatActivity {
    String[] names = {"Tom fbhdskjfbndkjs kfjkdsjfkdsj dkdjfdsjffdsvdvgfg Dick sdefdsfdsfdsfdsgdsg gsdgfgdfg Dick sdefdsfdsfdsfdsgdsg gsdgfgdfg", "Dick sdefdsfdsfdsfdsgdsg gsdgfgdfg", "Keanu dsgfsdgfgdfgfgdfgdgfdgdfg", "Harry", "Katrina", "Peter", "Julia", "Emma"};

    CheckBox[] checkBox;
    int checkBoxID=101;
    TextView[] textView;
    LinearLayout linearLayout;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box_with_text_view);
        linearLayout=(LinearLayout)findViewById(R.id.linear);
        relativeLayout=(RelativeLayout)findViewById(R.id.relative);
        checkBox=new CheckBox[names.length];
        textView=new TextView[names.length];





        for(int i=0;i<names.length;i++){
            checkBox[i]=new CheckBox(this);
            checkBox[i].setId(checkBoxID);




            textView[i]=new TextView(this);
            textView[i].setText("Hello");


            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.RIGHT_OF, checkBox[i].getId());

            textView[i].setLayoutParams(params);
            textView[i].setPadding(0,15,0,0);

            relativeLayout.addView(checkBox[i]);
            relativeLayout.addView(textView[i]);
        }









    }
}
