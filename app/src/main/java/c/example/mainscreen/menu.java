package c.example.mainscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class menu extends AppCompatActivity {
    private ImageView image, image1, image2, image3, image4, image5, image6;
    private TextView email;
    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //get firebase auth instance
        auth = FirebaseAuth.getInstance();
        //get current user
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(menu.this, login.class));
                    finish();
                }
            }
        };
        image = (ImageView) findViewById(R.id.logout);
        image1= (ImageView) findViewById(R.id.about_as);
        image2= (ImageView) findViewById(R.id.services_list);
        image3= (ImageView) findViewById(R.id.contact_us);
        image4= (ImageView) findViewById(R.id.booking);
        image5= (ImageView) findViewById(R.id.faq);
        image6= (ImageView) findViewById(R.id.history);
        email = (TextView) findViewById(R.id.email);

        email.setText(user.getEmail());
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutus();
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serviceslist();
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactus();
            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                book();
            }
        });
        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Faq();
            }
        });
        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BHistory();
            }
        });


        //image6.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View view) {
              //  history();
            //}
        //});
    }
    //history
    //
    //faq
    public void Faq(){
        startActivity(new Intent(menu.this, FAQ.class));
    }
    //booking
    public void book(){
        startActivity(new Intent(menu.this, bookingtime.class));
    }
    //contactus
    public void contactus() {
        startActivity(new Intent(menu.this, contact_us.class));
    }
    //faq
    public void serviceslist() {
        startActivity(new Intent(menu.this, services_list.class));
    }
    //aboutus
    public void aboutus() {
        startActivity(new Intent(menu.this, about_us.class));
    }
    //sign out method
    public void signOut() {
        startActivity(new Intent(menu.this, login.class));
    }
    //history
//    public void BHistory() { startActivity(new Intent(menu.this,BookingHistory.class));
//   }
    public void BHistory() { startActivity(new Intent(menu.this,PaymentDetail.class));
    }

    
    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }
    @Override
    public void onStop() {
        super.onStop();
        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }

}