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

public class snpl12 extends AppCompatActivity {
    Button btn_booking12, btn_c12;
    EditText enter_c12;
    FirebaseDatabase database;
    DatabaseReference reference;
    Package7 package7;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snpl12);

        package7 = new Package7();
        btn_booking12 = findViewById(R.id.btn_booking12);
        btn_c12 = findViewById(R.id.btn_c12);
        enter_c12 = findViewById(R.id.enter_c12);

        reference =database.getInstance().getReference().child("Package7");
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

        btn_c12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Comment = enter_c12.getText().toString();
                package7.setComment(enter_c12.getText().toString());
                reference.child(String.valueOf(i + 1)).setValue(package7);
            }
        });
        btn_booking12.setOnClickListener(new View.OnClickListener() {
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