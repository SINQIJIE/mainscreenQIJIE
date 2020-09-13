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

public class snpl7 extends AppCompatActivity {
    Button btn_booking7, btn_c7;
    EditText enter_c7;
    FirebaseDatabase database;
    DatabaseReference reference;
    Package2 package2;
    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snpl7);

        package2 = new Package2();
        btn_booking7 = findViewById(R.id.btn_booking7);
        btn_c7 = findViewById(R.id.btn_c7);
        enter_c7 = findViewById(R.id.enter_c7);

        reference =database.getInstance().getReference().child("Package2");
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
        btn_c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Comment = enter_c7.getText().toString();
                package2.setComment(enter_c7.getText().toString());
                reference.child(String.valueOf(i + 1)).setValue(package2);
            }
        });
        btn_booking7.setOnClickListener(new View.OnClickListener() {
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