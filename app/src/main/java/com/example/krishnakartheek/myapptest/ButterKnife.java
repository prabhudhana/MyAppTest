package com.example.krishnakartheek.myapptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;

public class ButterKnife extends AppCompatActivity {
    @BindView(R.id.btnPlaceOrder) Button mBtnPlaceOrder;
    boolean status;

    //Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter_knife);
        butterknife.ButterKnife.bind(this);

       /* button=(Button)findViewById(R.id.btnPlaceOrder);


                button.setEnabled(false);*/

       mBtnPlaceOrder.setVisibility(View.VISIBLE);
       mBtnPlaceOrder.setEnabled(true);


               mBtnPlaceOrder.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {

                       String data= String.valueOf(status);
                       Toast.makeText(ButterKnife.this, data, Toast.LENGTH_SHORT).show();
                   }
               });




    }


}
