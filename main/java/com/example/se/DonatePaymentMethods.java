package com.example.se;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

public class DonatePaymentMethods extends AppCompatActivity {
    Button can, donate;
    EditText cardNum, expDate, cvv;
    private boolean isLoggedin;
    private double donation;
    private String firstName;
    private String lastName;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate_payment_methods);

        isLoggedin = getIntent().getExtras().getBoolean("condition");
        donation = getIntent().getExtras().getDouble("donation");
        firstName = getIntent().getExtras().getString("firstname");
        lastName = getIntent().getExtras().getString("lastname");
        email = getIntent().getExtras().getString("email");

        can = findViewById(R.id.btncan);
        donate = findViewById(R.id.btndon);
        cardNum = findViewById(R.id.cardNum);
        expDate = findViewById(R.id.expDate);
        cvv = findViewById(R.id.cvv);

        cancelPage();
        donate();
    }

    public void cancelPage() {
        can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cancel();
            }
        });
    }

    public void Cancel() {
        Intent intent = new Intent(this, Donate.class);
        intent.putExtra("condition", isLoggedin);
        startActivity(intent);

    }
    public  void donate() {
        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Donate();
            }
        });
    }

    public void Donate() {
        if(isLoggedin) {
            if(cardNum.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please enter your credit card number", Toast.LENGTH_LONG).show();
                return;
            }
            if(expDate.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please enter the expiry date on your card.", Toast.LENGTH_LONG).show();
                return;
            }
            if(cvv.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please enter your cvv number on the back of your card.", Toast.LENGTH_LONG).show();
                return;
            }
            Donations.addDatabase(new Donations(firstName, lastName, donation, email)); //add to database
            Intent intent = new Intent(this, MainScreenLogged.class);
            intent.putExtra("condition", isLoggedin);
            Toast.makeText(this, "Thank you for your donation.", Toast.LENGTH_LONG).show();
            startActivity(intent);
        }
        else {
            if(cardNum.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please enter your credit card number", Toast.LENGTH_LONG).show();
                return;
            }
            if(expDate.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please enter the expiry date on your card.", Toast.LENGTH_LONG).show();
                return;
            }
            if(cvv.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please enter your cvv number on the back of your card.", Toast.LENGTH_LONG).show();
                return;
            }
            Donations.addDatabase(new Donations(firstName, lastName, donation, email)); //add to database
            Intent intent = new Intent(this, MainScreen.class);
            intent.putExtra("condition", false);
            Toast.makeText(this, "Thank you for your donation.", Toast.LENGTH_LONG).show();
            startActivity(intent);
        }
    }
}
