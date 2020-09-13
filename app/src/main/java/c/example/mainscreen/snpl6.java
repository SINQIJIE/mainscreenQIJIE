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

public class snpl6 extends AppCompatActivity {
    Button btn_booking6, btn_c6;
    EditText enter_c6;
    FirebaseDatabase database;
    DatabaseReference reference;
    Package1 package1;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snpl6);

        package1 = new Package1();
        btn_booking6 = findViewById(R.id.btn_booking6);
        btn_c6 = findViewById(R.id.btn_c6);
        enter_c6 = findViewById(R.id.enter_c6);

        reference =database.getInstance().getReference().child("Package1");
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
        btn_c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Comment = enter_c6.getText().toString();
                package1.setComment(enter_c6.getText().toString());
                reference.child(String.valueOf(i + 1)).setValue(package1);
            }
        });
        btn_booking6.setOnClickListener(new View.OnClickListener() {
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