package com.example.se;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Login extends AppCompatActivity {
    EditText editName,editPassword;
    Button btnLogin;
    Button btnRegister;
    Button btnReturn;
    private boolean isLoggedin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        isLoggedin = getIntent().getExtras().getBoolean("condition");

        editName = findViewById(R.id.editText_loginID);
        editPassword = findViewById(R.id.editText_pw);
        btnLogin = findViewById(R.id.btn_Login);
        btnRegister = findViewById(R.id.btn_Register);
        btnReturn = findViewById(R.id.btn_Return);
        
        Register();
        Cancel();
        Login();
    }

    public  void Login() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogIn();
            }
        });
    }
    public void LogIn() {
        boolean var = false;
        ArrayList<Account> dbase = Account.returnList();
        for(int i = 0; i < dbase.size(); i++) {
            if(editName.getText().toString().equals(dbase.get(i).email) && editPassword.getText().toString().equals(dbase.get(i).password)) {
                var = true;
            }
        }
        if(var) {
            Intent intent = new Intent(this, MainScreenLogged.class);
            intent.putExtra("condition", var);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Incorrect e-mail address or password.", Toast.LENGTH_LONG).show();
            getIntent().putExtra("condition", var);
            return;
        }
    }

    public  void Register() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegisterForm();

            }
        });
    }
    public void openRegisterForm() {
        Intent intent = new Intent(this, RegisterPage.class);
        intent.putExtra("condition", isLoggedin);
        startActivity(intent);
    }

    public  void Cancel() {
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returntoMain();

            }
        });
    }
    public void returntoMain() {
        Intent intent = new Intent(this, MainScreen.class);
        intent.putExtra("condition", isLoggedin);
        startActivity(intent);
    }
}
