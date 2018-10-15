package com.example.krishnakartheek.myapptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String POST_URl="https://jsonplaceholder.typicode.com/posts";
    //String POST_URl="https://www.simplifiedcoding.net/demos/view-flipper/heroes.php";

    //a list to store all the products
    List<Product> productList;

    //the recyclerview
    RecyclerView recyclerView;

    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
       /* productList.add(
                new Product(

                        "Microsoft Surface Pro 4 Core m3 6th Gen - (4 GB/128 GB SSD/Windows 10)"
                        ));
        productList.add(
                new Product(

                        "Microsoft Surface Pro 4 Core m3 6th Gen - (4 GB/128 GB SSD/Windows 10)"
                        ));

        productList.add(
                new Product(

                        "Microsoft Surface Pro 4 Core m3 6th Gen - (4 GB/128 GB SSD/Windows 10)"
                        ));*/


        StringRequest stringRequest=new StringRequest(Request.Method.GET, POST_URl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this, "Response", Toast.LENGTH_SHORT).show();
                try {


                   /* JSONObject obj = new JSONObject(response);
                    JSONArray jsonArray=obj.getJSONArray("heroes");

                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject =  jsonArray.getJSONObject(i);

                        productList.add(new Product(jsonObject.getString("name")));
                        //creating recyclerview adapter
                        ProductAdapter adapter = new ProductAdapter(MainActivity.this, productList);

                        //setting adapter to recyclerview
                        recyclerView.setAdapter(adapter);*/


                    JSONArray jsonArray = new JSONArray(response);

                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject=jsonArray.getJSONObject(i);

                        productList.add(new Product(jsonObject.getString("userId"),
                                jsonObject.getString("id"),
                                jsonObject.getString("title"),
                                jsonObject.getString("body")));
                        //creating recyclerview adapter
                        ProductAdapter adapter = new ProductAdapter(MainActivity.this, productList);

                        //setting adapter to recyclerview
                        recyclerView.setAdapter(adapter);

                        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                            @Override
                            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                                super.onScrollStateChanged(recyclerView, newState);
                                Toast.makeText(MainActivity.this, "OnScrollState Changed", Toast.LENGTH_SHORT).show();

                                int first=linearLayoutManager.findFirstVisibleItemPosition();
                                int last=linearLayoutManager.findLastVisibleItemPosition();

                                Toast.makeText(MainActivity.this, String.valueOf(first)+" "+String.valueOf(last), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                                super.onScrolled(recyclerView, dx, dy);
                                Toast.makeText(MainActivity.this, "OnScrolled", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }


                //  Toast.makeText(MainActivity.this, String.valueOf(i), Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                    TextView textView = (TextView) findViewById(R.id.text);
                    textView.setText("Error    "+e.getMessage().toString());
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();

            }
        });
        Volley.newRequestQueue(this).add(stringRequest);


    }
}