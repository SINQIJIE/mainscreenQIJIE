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

public class snpl13 extends AppCompatActivity {
    Button btn_booking13, btn_c13;
    EditText enter_c13;
    FirebaseDatabase database;
    DatabaseReference reference;
    Package8 package8;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snpl13);

        package8 = new Package8();
        btn_booking13 = findViewById(R.id.btn_booking13);
        btn_c13 = findViewById(R.id.btn_c13);
        enter_c13 = findViewById(R.id.enter_c13);

        reference =database.getInstance().getReference().child("Package8");
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
        btn_c13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Comment = enter_c13.getText().toString();
                package8.setComment(enter_c13.getText().toString());
                reference.child(String.valueOf(i + 1)).setValue(package8);
            }
        });
        btn_booking13.setOnClickListener(new View.OnClickListener() {
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