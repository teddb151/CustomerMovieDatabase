package com.fit2081.rooms.provider;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CustomerViewModel extends AndroidViewModel {
    //brings the customer object list and repository into this section of the application
    private CustomerRepository mRepository;
    private LiveData<List<Customer>> mAllCustomers;
//the respository is created and set to the application and then the data in the repository fills the live list
    public CustomerViewModel(@NonNull Application application) {
        super(application);
        mRepository = new CustomerRepository(application);
        mAllCustomers = mRepository.getAllCustomers();
    }
//the live data gets all the customer objecys to be able to pass it onto the ohter sections
    public LiveData<List<Customer>> getAllCustomers() {
        return mAllCustomers;
    }
//gets the insert funcion and insets the customer into the repository
    public void insert(Customer customer) {
        mRepository.insert(customer);
    }
    public void deleteAll(){
        mRepository.deleteAll();
    }

}
