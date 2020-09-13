package c.example.mainscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class services_list extends AppCompatActivity {
    private Button btn_snpla, btn_snplb, btn_snplc, btn_snpld, btn_snple, btn_snplf,  btn_snplg,
            btn_snplh, btn_snpli, btn_snplj, btn_snplk, btn_snpll, btn_snplm,  btn_snpln;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_list);
        btn_snpla = (Button) findViewById(R.id.btn_snpl1);
        btn_snplb = (Button) findViewById(R.id.btn_snpl2);
        btn_snplc = (Button) findViewById(R.id.btn_snpl3);
        btn_snpld = (Button) findViewById(R.id.btn_snpl4);
        btn_snple = (Button) findViewById(R.id.btn_snpl5);
        btn_snplf = (Button) findViewById(R.id.btn_snpl6);
        btn_snplg = (Button) findViewById(R.id.btn_snpl7);
        btn_snplh = (Button) findViewById(R.id.btn_snpl8);
        btn_snpli = (Button) findViewById(R.id.btn_snpl9);
        btn_snplj = (Button) findViewById(R.id.btn_snpl10);
        btn_snplk = (Button) findViewById(R.id.btn_snpl11);
        btn_snpll = (Button) findViewById(R.id.btn_snpl12);
        btn_snplm = (Button) findViewById(R.id.btn_snpl13);
        btn_snpln = (Button) findViewById(R.id.btn_snpl14);


        btn_snpla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensnpl1();
            }
        });

        btn_snplb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensnpl2();
            }
        });
        btn_snplc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensnpl3();
            }
        });
        btn_snpld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensnpl4();
            }
        });
        btn_snple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensnpl5();
            }
        });
        btn_snplf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensnpl6();
            }
        });
        btn_snplg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensnpl7();
            }
        });
        btn_snplh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensnpl8();
            }
        });
        btn_snpli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensnpl9();
            }
        });
        btn_snplj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensnpl10();
            }
        });
        btn_snplk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensnpl11();
            }
        });
        btn_snpll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensnpl12();
            }
        });
        btn_snplm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensnpl13();
            }
        });
        btn_snpln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensnpl14();
            }
        });



    }
    //snpl1
    public void opensnpl1(){
        Intent intent = new Intent(this, snpl1.class);
        startActivity(intent);
    }
    //snpl2
    public void opensnpl2(){
        Intent intent = new Intent (this, snpl2.class);
        startActivity(intent);
    }
    //snpl3
    public void opensnpl3(){
        Intent intent = new Intent (this, snpl3.class);
        startActivity(intent);
    }
    //snpl4
    public void opensnpl4(){
        Intent intent = new Intent (this, snpl4.class);
        startActivity(intent);
    }
    //snpl5
    public void opensnpl5(){
        Intent intent = new Intent (this, snpl5.class);
        startActivity(intent);
    }
    //snpl6
    public void opensnpl6(){
        Intent intent = new Intent (this, snpl6.class);
        startActivity(intent);
    }
    //snpl7
    public void opensnpl7(){
        Intent intent = new Intent (this, snpl7.class);
        startActivity(intent);
    }
    //snpl8
    public void opensnpl8(){
        Intent intent = new Intent (this, snpl8.class);
        startActivity(intent);
    }
    //snpl9
    public void opensnpl9(){
        Intent intent = new Intent (this, snpl9.class);
        startActivity(intent);
    }
    //snpl10
    public void opensnpl10(){
        Intent intent = new Intent (this, snpl10.class);
        startActivity(intent);
    }
    //snpl11
    public void opensnpl11(){
        Intent intent = new Intent (this, snpl11.class);
        startActivity(intent);
    }
    //snpl12
    public void opensnpl12(){
        Intent intent = new Intent (this, snpl12.class);
        startActivity(intent);
    }
    //snpl13
    public void opensnpl13(){
        Intent intent = new Intent (this, snpl13.class);
        startActivity(intent);
    }
    //snpl14
    public void opensnpl14(){
        Intent intent = new Intent (this, snpl14.class);
        startActivity(intent);
    }
}