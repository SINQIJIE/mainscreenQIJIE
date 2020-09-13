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

public class snpl14 extends AppCompatActivity {
    Button btn_booking14, btn_c14;
    EditText enter_c14;
    FirebaseDatabase database;
    DatabaseReference reference;
    Package9 package9;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snpl14);

        package9 = new Package9();
        btn_booking14 = findViewById(R.id.btn_booking14);
        btn_c14 = findViewById(R.id.btn_c14);
        enter_c14 = findViewById(R.id.enter_c14);

        reference =database.getInstance().getReference().child("Package9");
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
        btn_c14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Comment = enter_c14.getText().toString();
                package9.setComment(enter_c14.getText().toString());
                reference.child(String.valueOf(i + 1)).setValue(package9);
            }
        });
        btn_booking14.setOnClickListener(new View.OnClickListener() {
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