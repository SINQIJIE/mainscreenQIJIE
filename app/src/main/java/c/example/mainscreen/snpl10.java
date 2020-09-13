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

public class snpl10 extends AppCompatActivity {
    Button btn_booking10, btn_c10;
    EditText enter_c10;
    FirebaseDatabase database;
    DatabaseReference reference;
    Package5 package5;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snpl10);

        package5 = new Package5();
        btn_booking10 = findViewById(R.id.btn_booking10);
        btn_c10 = findViewById(R.id.btn_c10);
        enter_c10 = findViewById(R.id.enter_c10);

        reference =database.getInstance().getReference().child("Package5");
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

        btn_c10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Comment = enter_c10.getText().toString();
                package5.setComment(enter_c10.getText().toString());
                reference.child(String.valueOf(i + 1)).setValue(package5);
            }
        });
        btn_booking10.setOnClickListener(new View.OnClickListener() {
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