package c.example.mainscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class payment extends AppCompatActivity {
    Button btn_Ok, btn_cancel;
    EditText name, address, phone, notes;
    RadioButton pickup, delivery, cashon, paypal, credit;
    History history;
    Payments payments;
    FirebaseAuth auth;
    FirebaseDatabase database;
    DatabaseReference reference,reference1;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        payments = new Payments();
        history=new History();
        btn_Ok = findViewById(R.id.btnOk);
        btn_cancel= findViewById(R.id.btnCancle);
        name = findViewById(R.id.PersonNameText);
        address = findViewById(R.id.AddressText);
        phone = findViewById(R.id.PhoneText);
        notes = findViewById(R.id.NotesText);
        //delivery= findViewById(R.id.radDelivery);
        //pickup= findViewById(R.id.radPickup);
        cashon= findViewById(R.id.radCOD);
        paypal= findViewById(R.id.radPaypal);
        credit= findViewById(R.id.radCredit);
        auth=FirebaseAuth.getInstance();

        reference =database.getInstance().getReference().child("Payment");
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

        reference1 =database.getInstance().getReference().child("PaymentHistory").child(auth.getCurrentUser().getUid());
//        reference1.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
//                if (datasnapshot.exists()){
//                    i = (int)datasnapshot.getChildrenCount();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                //////
//            }
//        });

        btn_Ok.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String Name = name.getText().toString();
                String Address = address.getText().toString();
                String Phone = phone.getText().toString();
                if (TextUtils.isEmpty(Name)){
                    Toast.makeText(getApplicationContext(), "Enter your name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Address)) {
                    Toast.makeText(getApplicationContext(), "Enter your address", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(Phone)){
                    Toast.makeText(getApplicationContext(), "Enter your phone number", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    //String d1 = delivery.getText().toString();
                    //String d2 = pickup.getText().toString();

                    String p1 = cashon.getText().toString();
                    String p2 = paypal.getText().toString();
                    String p3 = credit.getText().toString();

                    payments.setName(name.getText().toString());
                    history.setName(name.getText().toString());
                   // reference.child(String.valueOf(i + 1)).setValue(payments);

                    payments.setAddress(address.getText().toString());
                    history.setAddress(address.getText().toString());
                    //reference.child(String.valueOf(i + 1)).setValue(payments);

                    payments.setPhone(phone.getText().toString());
                    history.setPhone(phone.getText().toString());
                   // reference.child(String.valueOf(i + 1)).setValue(payments);

                    payments.setNotes(notes.getText().toString());
                    history.setNotes(notes.getText().toString());
                    //reference.child(String.valueOf(i + 1)).setValue(payments);

                    //if (delivery.isChecked()) {
                      //  payments.setDeliveryMethod(d1);
                        //reference.child(String.valueOf(Name)).setValue(payments);
                    //}
                    //if (pickup.isChecked()) {
                      //  payments.setDeliveryMethod(d2);
                        //reference.child(String.valueOf(Name)).setValue(payments);
                    //}
                    if(cashon.isChecked()){
                        payments.setPaymentMethod(p1);
                        history.setPayment(p1);
                        reference.child(String.valueOf(i + 1)).setValue(payments);
                        reference1.setValue(history);

                        Toast.makeText(getApplicationContext(), "Pay successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(payment.this, services_list.class);
                        startActivity(intent);
                        finish();
                        return;
                    }
                    if(paypal.isChecked()){
                        payments.setPaymentMethod(p2);
                        history.setPayment(p2);
                        reference.child(String.valueOf(i + 1)).setValue(payments);
                        reference1.setValue(history);
                        Pal();
                    }
                    if (credit.isChecked()){
                        payments.setPaymentMethod(p3);
                        history.setPayment(p3);
                        reference.child(String.valueOf(i + 1)).setValue(payments);
                        reference1.setValue(history);
                        Card();
                    }


                }
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });

        Spinner spinner = findViewById(R.id.spinner);


        // Create an ArrayAdapter using the string array and default spinner
        // layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.labels_array,
                android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }
    public void onRadioButtonClicked(View view){

        boolean checked = ((RadioButton)view).isChecked();

        switch (view.getId()){
            //case R.id.radDelivery:
              //  if(checked)
                //    Toast.makeText(getApplicationContext(), "Delivery on this address", Toast.LENGTH_SHORT).show();
                //break;
            //case R.id.radPickup:
              //  if(checked)
                //    Toast.makeText(getApplicationContext(), "Pick Up", Toast.LENGTH_SHORT).show();
                //break;
            case R.id.radCOD:
                if(checked)
                    Toast.makeText(getApplicationContext(), "Cash On Delivery", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radPaypal:
                if(checked)
                    Toast.makeText(getApplicationContext(), "Paypal", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radCredit:
                if(checked)
                    Toast.makeText(getApplicationContext(), "Credit Card", Toast.LENGTH_SHORT).show();
                break;

        }
    }
    public void back(){
        Intent intent = new Intent(this, services_list.class);
        startActivity(intent);
    }
    public void Card(){
        Intent intent = new Intent(this, credit_card.class);
        startActivity(intent);
    }
    public void Pal(){
        Intent intent = new Intent(this, paypal.class);
        startActivity(intent);
    }

}
