package c.example.mainscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =(Button) findViewById(R.id.LoginBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlogin();
            }
        });

        button = (Button) findViewById(R.id.RegisterBtn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openregister();
            }
        });


    }

    public void openlogin(){
        Intent intent = new Intent(this, login.class);
                startActivity(intent);
    }
    public void openregister(){
        Intent intent = new Intent(this, register.class);
        startActivity(intent);
    }


}
