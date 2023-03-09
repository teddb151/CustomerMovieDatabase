package com.fit2081.rooms.provider;
import android.app.Application;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CustomerRepository  {

    private CustomerDao mCustomerDao;
    private LiveData<List<Customer>> mAllCustomers;

    CustomerRepository(Application application) {
        //sets the customer database to equal the customer DAO
        CustomerDatabase db = CustomerDatabase.getDatabase(application);
        mCustomerDao = db.customerDao();
        //adds the customer DAO
        mAllCustomers = mCustomerDao.getAllCustomer();
    }
    //adds all the cusotmers to the customer object list
    LiveData<List<Customer>> getAllCustomers() {
        return mAllCustomers;
    }
    void insert(Customer customer) {
        //uses the databsae writer to add all the customer objects from the DOA to the database
        CustomerDatabase.databaseWriteExecutor.execute(() -> mCustomerDao.addCustomer(customer));
    }

    void deleteAll(){
        //delets the cusotmer object from the DAO
        CustomerDatabase.databaseWriteExecutor.execute(()->{
            mCustomerDao.deleteAllCustomers();
        });
    }
}
