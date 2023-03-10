package com.fit2081.rooms.provider;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CustomerDao {
//creates the different queries which are used for the getting the data from the databse
    @Query("select * from customers")
    LiveData<List<Customer>> getAllCustomer();

    @Query("select * from customers where MovieName=:name")
    List<Customer> getCustomer(String name);

    @Insert
    void addCustomer(Customer customer);

    @Query("delete from customers where MovieName= :name")
    void deleteCustomer(String name);

    @Query("delete FROM customers")
    void deleteAllCustomers();
}
