package c.example.mainscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class credit_card extends AppCompatActivity {
    Button btn_pay;
    EditText amount, cardname, cardnumber;
    Credit credit;
    FirebaseDatabase database;
    DatabaseReference reference;
    int i = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card);

        credit = new Credit();
        btn_pay = findViewById(R.id.pay_btn);
        amount = findViewById(R.id.pay_amount);
        cardname = findViewById(R.id.card_name);
        cardnumber = findViewById(R.id.card_number);

        reference =database.getInstance().getReference().child("Credit card");
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

        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Amount = amount.getText().toString();
                String Cardname = cardname.getText().toString();
                String Cardnumber = cardnumber.getText().toString();

                if (TextUtils.isEmpty(Amount)){
                    Toast.makeText(getApplicationContext(), "Enter your amount", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Cardname)) {
                    Toast.makeText(getApplicationContext(), "Enter your card name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(Cardnumber)){
                    Toast.makeText(getApplicationContext(), "Enter your card number", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{

                    credit.setAmount(amount.getText().toString());
                    reference.child(String.valueOf(Cardname)).setValue(credit);

                    credit.setCardname(cardname.getText().toString());
                    reference.child(String.valueOf(Cardname)).setValue(credit);

                    credit.setCardnumber(cardnumber.getText().toString());
                    reference.child(String.valueOf(Cardname)).setValue(credit);

                    Toast.makeText(getApplicationContext(), "Pay successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(credit_card.this, services_list.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }
}