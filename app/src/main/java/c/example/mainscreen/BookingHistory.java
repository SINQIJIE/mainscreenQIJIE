package c.example.mainscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.Date;
import java.util.List;

public class BookingHistory extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private DatabaseReference mRefB;
    private HistoryAdapter adapter;
    private Booking booking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_history);
        mRecyclerView = (RecyclerView) findViewById(R.id.databook);


        booking =new Booking();
        mRefB = FirebaseDatabase.getInstance().getReference().child("Booking");


        mRefB.keepSynced(true);

        mRecyclerView=(RecyclerView) findViewById(R.id.databook);
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Booking> option = new FirebaseRecyclerOptions.Builder<Booking>().setQuery(mRefB,Booking.class).setLifecycleOwner(this).build();


        adapter=new HistoryAdapter(option);

        mRecyclerView.setAdapter(adapter);

    }

}