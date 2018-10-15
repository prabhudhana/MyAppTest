package com.example.krishnakartheek.myapptest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LisTActivity extends AppCompatActivity {

    ListView listView;

    List<ListModel> listModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lis_t);
        listModel = new ArrayList<>();
        listView=(ListView)findViewById(R.id.listView);

        listModel.add(new ListModel( "Spiderman"));
        listModel.add(new ListModel( "Joker"));
        listModel.add(new ListModel( "Iron Man"));
        listModel.add(new ListModel( "Doctor Strange"));
        listModel.add(new ListModel( "Captain America"));
        listModel.add(new ListModel( "Batman"));
        listModel.add(new ListModel( "Spiderman"));
        listModel.add(new ListModel( "Joker"));
        listModel.add(new ListModel( "Iron Man"));
        listModel.add(new ListModel( "Doctor Strange"));
        listModel.add(new ListModel( "Captain America"));
        listModel.add(new ListModel( "Batman"));
        listModel.add(new ListModel( "Spiderman"));
        listModel.add(new ListModel( "Joker"));
        listModel.add(new ListModel( "Iron Man"));
        listModel.add(new ListModel( "Doctor Strange"));
        listModel.add(new ListModel( "Captain America"));
        listModel.add(new ListModel( "Batman"));
        listModel.add(new ListModel( "Spiderman"));
        listModel.add(new ListModel( "Joker"));
        listModel.add(new ListModel( "Iron Man"));
        listModel.add(new ListModel( "Doctor Strange"));
        listModel.add(new ListModel( "Captain America"));
        listModel.add(new ListModel( "Batman"));
        final MyListAdapter adapter = new MyListAdapter(this, R.layout.list_row, listModel);

        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //setListViewHeightBasedOnChildren(listView);
        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListModel listModels=listModel.get(position);
               // listModels.isChecked=!listModels.isChecked;
                adapter.notifyDataSetChanged();
            }
        });


*/
        //justifyListViewHeightBasedOnChildren(listView);


        listView.setOnTouchListener(new ListView.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;
                    case MotionEvent.ACTION_UP:
                        // Allow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }
                // Handle ListView touch events.
                v.onTouchEvent(event);
                return true;
            }
        });

    }


    public static void justifyListViewHeightBasedOnChildren (ListView listView) {

        ListAdapter adapter = listView.getAdapter();

        if (adapter == null) {
            return;
        }
        ViewGroup vg = listView;
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, vg);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams par = listView.getLayoutParams();
        par.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(par);
        listView.requestLayout();
    }

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
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

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
                    if(counter==listModel.size()){
                        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(context, "Not Success", Toast.LENGTH_SHORT).show();
                    }
                }
            });


            return view;
        }


        @Override
        public int getCount() {
            return listModel.size();
        }
    }
    public static void setListViewHeightBasedOnChildren
            (ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) return;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(),
                View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0) view.setLayoutParams(new
                    ViewGroup.LayoutParams(desiredWidth,
                    LinearLayout.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();

        params.height = totalHeight + (listView.getDividerHeight() *
                (listAdapter.getCount()- 1));

        listView.setLayoutParams(params);
        listView.requestLayout();
    }

}
