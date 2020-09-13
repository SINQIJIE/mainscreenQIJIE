package c.example.mainscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PaymentDetail extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private DatabaseReference mRef;
    private PaymentAdapter adapter1;
    private Payments payments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_detail);
        mRecyclerView=(RecyclerView) findViewById(R.id.databook2);

        payments=new Payments();
        mRef= FirebaseDatabase.getInstance().getReference().child("Payment");

        mRef.keepSynced(true);

        mRecyclerView=(RecyclerView) findViewById(R.id.databook2);
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Payments> option = new FirebaseRecyclerOptions.Builder<Payments>().setQuery(mRef,Payments.class).setLifecycleOwner(this).build();


        adapter1= new PaymentAdapter(option);

        mRecyclerView.setAdapter(adapter1);

    }
}