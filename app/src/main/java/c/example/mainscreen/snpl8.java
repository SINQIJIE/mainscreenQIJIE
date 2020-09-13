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

public class snpl8 extends AppCompatActivity {
    Button btn_booking8, btn_c8;
    EditText enter_c8;
    FirebaseDatabase database;
    DatabaseReference reference;
    Package3 package3;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snpl8);

        package3 = new Package3();
        btn_booking8 = findViewById(R.id.btn_booking8);
        btn_c8 = findViewById(R.id.btn_c8);
        enter_c8 = findViewById(R.id.enter_c8);

        reference =database.getInstance().getReference().child("Package3");
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
        btn_c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Comment = enter_c8.getText().toString();
                package3.setComment(enter_c8.getText().toString());
                reference.child(String.valueOf(i + 1)).setValue(package3);
            }
        });
        btn_booking8.setOnClickListener(new View.OnClickListener() {
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