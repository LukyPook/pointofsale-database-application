package com.example.se;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class DonorInformation extends AppCompatActivity {
    TextView tv;
    Button cancel, find, mainscreen;
    private boolean isLoggedin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_information);
        
        isLoggedin = getIntent().getExtras().getBoolean("condition");

        tv = findViewById(R.id.tvinfo);
        cancel = findViewById(R.id.cancel);
        find = findViewById(R.id.find);
        mainscreen = findViewById(R.id.mainscreen);

        Cancel();
        Find();
        ReturnMain();

    }
    public  void Cancel() {
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancel();
            }
        });
    }
    public void cancel() {
        Intent intent = new Intent(this, AdminAccessPage.class);
        intent.putExtra("condition", false);
        startActivity(intent);
    }

    public  void Find() {
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Donations> dbase = Donations.returnList();
                String temp = "";
                for (int i = 0; i < dbase.size(); i++) {
                    temp += dbase.get(i).firstName + " " + dbase.get(i).lastName + "\n";
                    temp += "$" + dbase.get(i).donation + "\n";
                    temp += dbase.get(i).email + "\n";
                    temp += "\n";
                    tv.setText(temp);
                }

            }
        });
    }
    public  void ReturnMain() {
        mainscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retmain();

            }
        });
    }
    public void retmain() {
        Intent intent = new Intent(this, MainScreen.class);
        intent.putExtra("condition", false);
        startActivity(intent);
    }
}
