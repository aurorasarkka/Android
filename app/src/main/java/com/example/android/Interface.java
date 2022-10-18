package com.example.android;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

//http://avoindata.prh.fi/bis/v1?totalResults=false&maxResults=70&resultsFrom=0&name=saimaan&companyRegistrationFrom=2000-01-01

public class Interface extends AppCompatActivity {

    private Button searchBtn;
    public static final String TAG = "Testi #2";
    private EditText searchText;
    private RequestQueue requestQueue;
    private String url;
    private RecyclerView recyclerView;
    private RecycleAdapter adapter;
    private List<Company> itemList = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);

        recyclerView = (RecyclerView) findViewById(R.id.cardList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        searchText = findViewById(R.id.editText);

        searchBtn = findViewById(R.id.searchBtn);
        Log.i(TAG, "activating ");
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchTerm = String.valueOf(searchText.getText());


                url = "http://avoindata.prh.fi/bis/v1?totalResults=false&maxResults=70&resultsFrom=0&name=" + searchTerm + "&companyRegistrationFrom=2014-01-01";
                retrieveJSON();






            }


        });

    }


    private void retrieveJSON() {
        requestQueue = Volley.newRequestQueue(this);
        Log.i(TAG, url);


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {


                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.i(TAG, url);
                            ArrayList<Company> companies = new ArrayList<Company>();
                            Company currentCompany = new Company();

                            JSONArray responseItems = (JSONArray) response.getJSONArray("results");
                            for (int i = 0; i < responseItems.length(); i++) {
                                JSONObject obj = responseItems.getJSONObject(i);
                                String A = obj.getString("businessId");
                                String B = obj.getString("name");
                                String C = obj.getString("registrationDate");
                                String D = obj.getString("companyForm");
                                currentCompany.setBusinessId(A);
                                currentCompany.setName(B);
                                currentCompany.setRegistrationDate(C);
                                currentCompany.setCompanyForm(D);

                                Log.e(TAG, A + " " + B + " " + C + D);
                                companies.add(currentCompany);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        setupView();
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        Log.e(TAG, "ErrorResponse");

                    }


                });
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(20 * 1000, 1, 1.0f));
        requestQueue.add(jsonObjectRequest);
        Log.e(TAG, "Menee läpi");
    }
    private void setupView(){
        adapter = new RecycleAdapter((ArrayList<Company>) itemList);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }








}









