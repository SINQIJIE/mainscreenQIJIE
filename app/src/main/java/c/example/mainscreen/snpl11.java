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

public class snpl11 extends AppCompatActivity {
    Button btn_booking11, btn_c11;
    EditText enter_c11;
    FirebaseDatabase database;
    DatabaseReference reference;
    Package6 package6;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snpl11);

        package6 = new Package6();
        btn_booking11 = findViewById(R.id.btn_booking11);
        btn_c11 = findViewById(R.id.btn_c11);
        enter_c11 = findViewById(R.id.enter_c11);

        reference =database.getInstance().getReference().child("Package6");
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

        btn_c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Comment = enter_c11.getText().toString();
                package6.setComment(enter_c11.getText().toString());
                reference.child(String.valueOf(i + 1)).setValue(package6);
            }
        });
        btn_booking11.setOnClickListener(new View.OnClickListener() {
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