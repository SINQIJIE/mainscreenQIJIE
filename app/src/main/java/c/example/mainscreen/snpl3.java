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

public class snpl3 extends AppCompatActivity {
    Button btn_booking3, btn_c3;
    EditText enter_c3;
    FirebaseDatabase database;
    DatabaseReference reference;
    Hairperm hairperm;
    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snpl3);

        hairperm = new Hairperm();
        btn_booking3 = findViewById(R.id.btn_booking3);
        btn_c3 = findViewById(R.id.btn_c3);
        enter_c3 = findViewById(R.id.enter_c3);

        reference =database.getInstance().getReference().child("Hairperm");
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

        btn_c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Comment = enter_c3.getText().toString();
                hairperm.setComment(enter_c3.getText().toString());
                reference.child(String.valueOf(i + 1)).setValue(hairperm);
            }

        });
        btn_booking3.setOnClickListener(new View.OnClickListener() {
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