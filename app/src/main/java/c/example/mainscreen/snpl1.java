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

public class snpl1 extends AppCompatActivity {
    Button btn_booking1, btn_c1;
    EditText enter_c1;
    FirebaseDatabase database;
    DatabaseReference reference;
    Haircut haircut;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snpl1);

        haircut = new Haircut();
        btn_booking1 = findViewById(R.id.btn_booking1);
        btn_c1 = findViewById(R.id.btn_c1);
        enter_c1 = findViewById(R.id.enter_c1);

        reference =database.getInstance().getReference().child("Haircut");
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

        btn_c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Comment = enter_c1.getText().toString();
                haircut.setComment(enter_c1.getText().toString());
                reference.child(String.valueOf(i + 1)).setValue(haircut);
            }
        });

        btn_booking1.setOnClickListener(new View.OnClickListener() {
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
