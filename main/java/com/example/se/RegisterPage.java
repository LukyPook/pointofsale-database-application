package com.example.se;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.*;

public class RegisterPage extends AppCompatActivity {
    Button cancel, register;
    EditText email, firstName, lastName, password;
    static String customerInfo = "";
    private boolean isLoggedin;
    private static final String FILE_NAME = "text.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        
        register = findViewById(R.id.reg);
        cancel = findViewById(R.id.cancel);
        email = findViewById(R.id.editText_email);
        firstName = findViewById(R.id.editText_firstname);
        lastName = findViewById(R.id.editText_lastname);
        password = findViewById(R.id.editText_password);

        RegisterInfo();
        cancelPage();
    }

    public void save() {
        String outputInformation = "";
        outputInformation += email.getText().toString() + "-" + password.getText().toString() + "-" +
                            firstName.getText().toString() + "-" +lastName.getText().toString();
        customerInfo = outputInformation;
        Account.addDatabase(new Account(email.getText().toString(), password.getText().toString(), firstName.getText().toString()
                        , lastName.getText().toString()));
    }

    public  void RegisterInfo() {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SubmitReg();
            }
        });
    }
    public  void cancelPage() {
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cancel();
            }
        });
    }
    public void SubmitReg() {
        if(!email.getText().toString().contains("@")) {
            Toast.makeText(this, "Please enter a valid e-mail address,", Toast.LENGTH_LONG).show();
            return;
        }
        if(email.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter an email address.", Toast.LENGTH_LONG).show();
            return;
        }
        int length = email.getText().toString().length();
        if(!email.getText().toString().substring(length-4, length).equals(".com")) {
            Toast.makeText(this, "Please enter an e-mail address.", Toast.LENGTH_LONG).show();
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
        if(password.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter a valid password.", Toast.LENGTH_LONG).show();
            return;
        }
        else {
            save();
            Intent intent = new Intent(this, MainScreenLogged.class);
            intent.putExtra("condition", !isLoggedin);
            startActivity(intent);
        }
    }
    public void Cancel() {
        Intent intent = new Intent(this, Login.class);
        intent.putExtra("condition", isLoggedin);
        startActivity(intent);
    }
}
