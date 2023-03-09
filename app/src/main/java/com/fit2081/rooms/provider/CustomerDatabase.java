package com.fit2081.rooms.provider;
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {Customer.class}, version = 1)
public abstract class CustomerDatabase extends RoomDatabase {

    public static final String CUSTOMER_DATABASE_NAME = "customer_database";

    public abstract CustomerDao customerDao();

    // marking the instance as volatile to ensure atomic access to the variable
    private static volatile CustomerDatabase INSTANCE;
    //makes sure the number of threads are defined so that they won't be used too much by other functions.
    private static final int NUMBER_OF_THREADS = 4;
    //creates a database executor whereonly the execuotr has access to that specific thread.
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static CustomerDatabase getDatabase(final Context context) {
        //if the thread is null
        if (INSTANCE == null) {
            //syncronises a database class
            synchronized (CustomerDatabase.class) {
                if (INSTANCE == null) {
                    //builds the database
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CustomerDatabase.class, CUSTOMER_DATABASE_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
