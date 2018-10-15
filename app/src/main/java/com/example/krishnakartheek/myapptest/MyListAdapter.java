/*
package com.example.krishnakartheek.myapptest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

class MyListAdapter extends ArrayAdapter<ListModel> {
    List<ListModel> listModel;

    int counter=0;

    //activity context
    Context context;
    int list_row;

    public MyListAdapter(Context context, int list_row, List<ListModel> listModel) {
        super(context,list_row,listModel);

        this.context=context;
        this.list_row=list_row;
        this.listModel=listModel;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater=LayoutInflater.from(context);

        View view=layoutInflater.inflate(list_row,null,false);

        ListModel listModelC=listModel.get(position);
        TextView textView=view.findViewById(R.id.textCheck);
        final CheckBox checkBox=view.findViewById(R.id.checked_textview);

        textView.setText(listModelC.getData());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    counter++;
                }else{
                    counter--;
                }
            }
        });


        return view;
    }
}
*/
