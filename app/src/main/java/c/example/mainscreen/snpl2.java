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

public class snpl2 extends AppCompatActivity {
    Button btn_booking2, btn_c2;
    EditText enter_c2;
    FirebaseDatabase database;
    DatabaseReference reference;
    Color color;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snpl2);

        color = new Color();
        btn_booking2 = findViewById(R.id.btn_booking2);
        btn_c2 = findViewById(R.id.btn_c2);
        enter_c2 = findViewById(R.id.enter_c2);

        reference =database.getInstance().getReference().child("Color");
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

        btn_c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Comment = enter_c2.getText().toString();
                color.setComment(enter_c2.getText().toString());
                reference.child(String.valueOf(i + 1)).setValue(color);
            }

        });

        btn_booking2.setOnClickListener(new View.OnClickListener() {
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