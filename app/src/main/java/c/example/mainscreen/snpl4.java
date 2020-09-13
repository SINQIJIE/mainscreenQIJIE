package c.example.mainscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class snpl4 extends AppCompatActivity {
    Button btn_booking4, btn_c4;
    EditText enter_c4;
    FirebaseDatabase database;
    DatabaseReference reference;
    Shampoo shampoo;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snpl4);

        shampoo = new Shampoo();
        btn_booking4 = findViewById(R.id.btn_booking4);
        btn_c4 = findViewById(R.id.btn_c4);
        enter_c4 = findViewById(R.id.enter_c4);

        reference =database.getInstance().getReference().child("ShampooService");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                if (datasnapshot.exists()){
                    i = (int)datasnapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //////
            }
        });

        btn_c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Comment = enter_c4.getText().toString();
                shampoo.setComment(enter_c4.getText().toString());
                reference.child(String.valueOf(i + 1)).setValue(shampoo);
            }
        });
        btn_booking4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                booking();
            }
        });
        btn_booking4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                booking();
            }
        });
    }
    public void booking(){
        Intent intent = new Intent(this, bookingtime.class);
        startActivity(intent);
    }
}