package com.example.se;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ShopCheckout extends AppCompatActivity {
    Button can, purchase;
    EditText cardNum, expDate, cvv, firstName, lastName, address;
    TextView tv;
    private boolean isLoggedin;
    private double totalValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_checkout);
        
        isLoggedin = getIntent().getExtras().getBoolean("condition");
        totalValue = getIntent().getExtras().getDouble("total");

        tv = findViewById(R.id.result);
        tv.setText("Total is: $" + totalValue);
        can = findViewById(R.id.btncanpur);
        purchase = findViewById(R.id.btnpur);

        cardNum = findViewById(R.id.cardNumpur);
        expDate = findViewById(R.id.expDatepur);
        cvv = findViewById(R.id.cvvpur);

        firstName = findViewById(R.id.firstNamepur);
        lastName = findViewById(R.id.lastNamepur);
        address = findViewById(R.id.addresspur);

        cancelPage();
        purchase();
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
        if(isLoggedin) {
            Intent intent = new Intent(this, MainScreenLogged.class);
            intent.putExtra("condition", isLoggedin);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, MainScreen.class);
            intent.putExtra("condition", false);
            startActivity(intent);
        }
    }
    public  void purchase() {
        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Purchase();
            }
        });
    }

    public void Purchase() {
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
            if(firstName.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please enter your first name.", Toast.LENGTH_LONG).show();
                return;
            }
            if(lastName.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please enter your last name.", Toast.LENGTH_LONG).show();
                return;
            }
            Intent intent = new Intent(this, MainScreenLogged.class);
            intent.putExtra("condition", isLoggedin);
            Toast.makeText(this, "Thank you for your purchase. It should be shipped to your address within 7 business days.", Toast.LENGTH_LONG).show();
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
            if(firstName.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please enter your first name.", Toast.LENGTH_LONG).show();
                return;
            }
            if(lastName.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please enter your last name.", Toast.LENGTH_LONG).show();
                return;
            }
            Intent intent = new Intent(this, MainScreen.class);
            intent.putExtra("condition", false);
            Toast.makeText(this, "Thank you for your purchase.. It should be shipped to your address within 7 business days.", Toast.LENGTH_LONG).show();
            startActivity(intent);
        }
    }
}
