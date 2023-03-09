package com.fit2081.rooms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fit2081.rooms.provider.Customer;

import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder> {

    private List<Customer> mCustomers;

    public CustomerAdapter() {

    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflates the recycler view with customer view holder
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);

        return new CustomerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        //sets the holder in the customer adapter to the values
        holder.nameTv.setText(mCustomers.get(position).getName());
        holder.GenreTv.setText(mCustomers.get(position).getGenre());

    }


    @Override
    public int getItemCount() {
        //gets the amount of items
        if (mCustomers == null)
            return 0;
        else
            return mCustomers.size();
    }
//creates the funciton of set customers to the list of customers we have here
    public void setCustomers(List<Customer> newData) {
        mCustomers=newData;
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTv;
        public TextView GenreTv;

        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.name_id);
            GenreTv = itemView.findViewById(R.id.genre_id);

        }
    }
}
