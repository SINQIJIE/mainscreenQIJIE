package c.example.mainscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class contact_us extends AppCompatActivity {
    private EditText inputMail, inputSubject, inputName, inputMessage;
    private Button btnSend;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        inputName = (EditText) findViewById(R.id.your_name);
        inputMail = (EditText) findViewById(R.id.your_email);
        inputSubject = (EditText) findViewById(R.id.your_subject);
        inputMessage = (EditText) findViewById(R.id.your_message);
        btnSend = (Button) findViewById(R.id.post_message);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("contact_us");
                String name = inputName.getText().toString().trim();
                String email = inputMail.getText().toString().trim();
                String subject = inputSubject.getText().toString().trim();
                String message = inputMessage.getText().toString().trim();
                ContactUs helperClass = new ContactUs(name,email, subject, message);
                reference.child(name).setValue(helperClass);
                Toast.makeText(getApplicationContext(), "Send successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}