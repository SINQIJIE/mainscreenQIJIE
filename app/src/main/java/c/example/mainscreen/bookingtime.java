package c.example.mainscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class bookingtime extends AppCompatActivity {
    CalendarView dateview;
    Button btnok,btncancel;
    RadioButton time1,time2,time3,time4,time5,time6,time7;
    Booking booking;
    History history;
    FirebaseDatabase database;
    FirebaseAuth auth;
    DatabaseReference reference, reference1;
    int i = 0;
    private static final String TAG = "CalendarActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookingtime);

        booking = new Booking();
        history=new History();
        btnok = findViewById(R.id.ok_btn);
        btncancel= (Button) findViewById(R.id.cancle_btn);
        time1 = findViewById(R.id.rad1);
        time2 = findViewById(R.id.rad2);
        time3 = findViewById(R.id.rad3);
        time4 = findViewById(R.id.rad4);
        time5 = findViewById(R.id.rad5);
        time6 = findViewById(R.id.rad6);
        time7 = findViewById(R.id.rad7);
        dateview = findViewById(R.id.calendarView);

        auth=FirebaseAuth.getInstance();

        reference =database.getInstance().getReference().child("Booking");
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
        dateview.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int a, int a1, int a2) {
                final String date1 = a2 + "/" + (a1+1) + "/" + a;
                Log.d(TAG,"onSelectedDayChange: dd/mm/yyyy:" + 1);
                Toast.makeText(getApplicationContext(),"Date:"+ date1, Toast.LENGTH_SHORT).show();

                btnok.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        booking.setDate(date1);
                        history.setDate(date1);
                       // reference.child(String.valueOf(i+1)).setValue(booking);
                        //String Date = date.getText().toString();

                        //if (TextUtils.isEmpty(Date)) {
                        //    Toast.makeText(getApplicationContext(), "Enter your date", Toast.LENGTH_SHORT).show();
                        //    return;
                        // } else {
                        String t1 = time1.getText().toString();
                        String t2 = time2.getText().toString();
                        String t3 = time3.getText().toString();
                        String t4 = time4.getText().toString();
                        String t5 = time5.getText().toString();
                        String t6 = time6.getText().toString();
                        String t7 = time7.getText().toString();


                        //booking.setDate(date.getText().toString());
                      //  reference.child(String.valueOf(i + 1)).setValue(booking);




                        if (time1.isChecked()) {
                            booking.setTime(t1);
                            history.setTime(t1);
                            reference.child(String.valueOf(i + 1)).setValue(booking);
                           reference1.setValue(history);
                        }
                        if (time2.isChecked()) {
                            booking.setTime(t2);
                            history.setTime(t2);
                            reference.child(String.valueOf(i + 1)).setValue(booking);
                            reference1.setValue(history);
                        }
                        if (time3.isChecked()) {
                            booking.setTime(t3);
                            history.setTime(t3);
                            reference.child(String.valueOf(i + 1)).setValue(booking);
                            reference1.setValue(history);
                        }
                        if (time4.isChecked()) {
                            booking.setTime(t4);
                            history.setTime(t4);
                            reference.child(String.valueOf(i + 1)).setValue(booking);
                            reference1.setValue(history);
                        }
                        if (time5.isChecked()) {
                            booking.setTime(t5);
                            history.setTime(t5);
                            reference.child(String.valueOf(i + 1)).setValue(booking);
                            reference1.setValue(history);
                        }
                        if (time6.isChecked()) {
                            booking.setTime(t6);
                            history.setTime(t6);
                            reference.child(String.valueOf(i + 1)).setValue(booking);
                            reference1.setValue(history);
                        }
                        if (time7.isChecked()) {
                            booking.setTime(t7);
                            history.setTime(t7);
                            reference.child(String.valueOf(i + 1)).setValue(booking);
                            reference1.setValue(history);
                        }

                        pay();


                    }

                });
            }

        });
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back();
            }
        });

    }
    public void back(){
        Intent intent = new Intent(this, services_list.class);
        startActivity(intent);
    }
    public void pay(){
        Intent intent = new Intent(this, payment.class);
        startActivity(intent);
    }
}