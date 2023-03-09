package com.fit2081.rooms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fit2081.rooms.provider.Customer;
import com.fit2081.rooms.provider.CustomerViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
private List<Customer> movies;
    TextView tv;


    private CustomerViewModel mCustomerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  tv = findViewById(R.id.tv_id);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        CustomerAdapter adapter = new CustomerAdapter();

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//sets up hte view model class which then observes the new data.
        mCustomerViewModel = new ViewModelProvider(this).get(CustomerViewModel.class);
        mCustomerViewModel.getAllCustomers().observe(this, newData -> {
            //uses hte adapter creates to project the data
            adapter.setCustomers(newData);
            adapter.notifyDataSetChanged();
          //  tv.setText(newData.size() + "");
        });
    }


    public void onAddClick(View v) {
         TextView titleTv;
         TextView genreTv;
         TextView costTv;
         TextView keywordsTv;
         TextView countryTv;
         TextView yearTv;
         String title, genre, cost, keywords, country, year;

        titleTv = findViewById(R.id.txtName);
        genreTv = findViewById(R.id.txtGenre);
        costTv = findViewById(R.id.txtCost);
        keywordsTv = findViewById(R.id.txtKeywords);
        countryTv = findViewById(R.id.txtCountry);
        yearTv = findViewById(R.id.txtYear);

         title = titleTv.getText().toString();
        genre = genreTv.getText().toString();
        cost = costTv.getText().toString();
        keywords = keywordsTv.getText().toString();
        country = countryTv.getText().toString();
        year = yearTv.getText().toString();
        //creates the customer objects from the textviews and then adds them to the view model
        Customer c = new Customer(title, genre, country, keywords, Integer.parseInt(cost), Integer.parseInt(year));
        mCustomerViewModel.insert(c);

    }

    public void onCountClick(View v) {
        mCustomerViewModel.deleteAll();

    }
}
