package com.example.se;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

public class Donate extends AppCompatActivity {
    EditText editfirstName, editlastName, editEmail, editAmount;
    Button cancel, payMethods;
    private boolean isLoggedin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        isLoggedin = getIntent().getExtras().getBoolean("condition");

        cancel = findViewById(R.id.cancel);
        payMethods = findViewById(R.id.paymethod);
        editfirstName = findViewById(R.id.firstname);
        editlastName = findViewById(R.id.lastname);
        editEmail = findViewById(R.id.email);
        editAmount = findViewById(R.id.donateamount);

        CancelPage();
        PaymentMethods();
        editEmail.getText().toString().length();

    }

    public  void CancelPage() {
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCancel();
            }
        });
    }


    public void openPayments() {
        if(!editEmail.getText().toString().trim().contains("@")) {
            Toast.makeText(this, "Please enter a valid e-mail address.", Toast.LENGTH_LONG).show();
            return;
        }
        if(editEmail.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Please enter an e-mail address.", Toast.LENGTH_LONG).show();
            return;
        }
        int length = editEmail.getText().toString().trim().length();
        if(!editEmail.getText().toString().substring(length-4, length).equals(".com")) {
            Toast.makeText(this, "Please enter an e-mail address.", Toast.LENGTH_LONG).show();
            return;
        }
        if(editfirstName.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Please enter your first name.", Toast.LENGTH_LONG).show();
            return;
        }
        if(editlastName.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Please enter your last name.", Toast.LENGTH_LONG).show();
            return;
        }
        if(editAmount.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Please enter a donation amount.", Toast.LENGTH_LONG).show();
            return;
        }

        if(Double.parseDouble(editAmount.getText().toString()) <= 0) {
            Toast.makeText(this, "Please enter amount more then $0", Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent = new Intent(this, DonatePaymentMethods.class);
        intent.putExtra("condition", isLoggedin);
        intent.putExtra("donation", Double.parseDouble(editAmount.getText().toString()));
        intent.putExtra("firstname", editfirstName.getText().toString());
        intent.putExtra("lastname", editlastName.getText().toString());
        intent.putExtra("email", editEmail.getText().toString());

        startActivity(intent);
    }
    public  void PaymentMethods() {
        payMethods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPayments();
            }
        });
    }


    public void openCancel() {
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
}
