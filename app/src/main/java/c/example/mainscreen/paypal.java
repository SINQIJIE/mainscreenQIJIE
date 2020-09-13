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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class paypal extends AppCompatActivity {
    private EditText email, password;
    private Button btnpay;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paypal);
        auth = FirebaseAuth.getInstance();

        btnpay = findViewById(R.id.btnClickPay);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        btnpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Palemail = email.getText().toString();
                final String Palpassword = password.getText().toString();
                if (TextUtils.isEmpty(Palemail)) {
                    Toast.makeText(getApplicationContext(), "Please enter your paypal email to process", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Palpassword)) {
                    Toast.makeText(getApplicationContext(), "Please enter your password for paypal", Toast.LENGTH_SHORT).show();
                    return;
                }
                //progressBar.setVisibility(View.VISIBLE);
                auth.signInWithEmailAndPassword(Palemail, Palpassword)
                        .addOnCompleteListener(paypal.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {

                                    if (Palpassword.length() < 6) {
                                        password.setError(getString(R.string.minimum_password));
                                    } else {
                                        Toast.makeText(paypal.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Toast.makeText(getApplicationContext(), "Pay successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(paypal.this, services_list.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
            }
        });

    }
}