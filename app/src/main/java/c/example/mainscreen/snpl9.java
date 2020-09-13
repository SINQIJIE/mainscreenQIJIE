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

public class snpl9 extends AppCompatActivity {
    Button btn_booking9, btn_c9;
    EditText enter_c9;
    FirebaseDatabase database;
    DatabaseReference reference;
    Package4 package4;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snpl9);

        package4 = new Package4();
        btn_booking9 = findViewById(R.id.btn_booking9);
        btn_c9 = findViewById(R.id.btn_c9);
        enter_c9 = findViewById(R.id.enter_c9);

        reference =database.getInstance().getReference().child("Package4");
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
        btn_c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Comment = enter_c9.getText().toString();
                package4.setComment(enter_c9.getText().toString());
                reference.child(String.valueOf(i + 1)).setValue(package4);
            }
        });
        btn_booking9.setOnClickListener(new View.OnClickListener() {
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