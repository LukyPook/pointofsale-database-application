package com.example.se;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class MainScreen extends AppCompatActivity {
    Button btnLogReg, btnShop, btnDonate, btnAdmin;
    private boolean isLoggedIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        btnLogReg = findViewById(R.id.btnLog);
        btnShop = findViewById(R.id.btnShop);
        btnDonate = findViewById(R.id.btnDonate);
        btnAdmin = findViewById(R.id.admin);
        
        LogandReg();
        Shop();
        Donate();
        Admin();
    }
    public  void Admin() {
        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                admin();
            }
        });
    }
    public void admin() {
        Intent intent = new Intent(this, AdminAccessPage.class);
        intent.putExtra("condition", isLoggedIn);
        startActivity(intent);
    }
    public  void LogandReg() {
        btnLogReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogandReg();
            }
        });
    }
    public  void Shop() {
        btnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openShop();
            }
        });
    }
    public  void Donate() {
        btnDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDonate();
            }
        });
    }
    public void openLogandReg() {
        Intent intent = new Intent(this, Login.class);
        intent.putExtra("condition", isLoggedIn);
        startActivity(intent);
    }
    public void openShop() {
        Intent intent = new Intent(this, Shop.class);
        intent.putExtra("condition", isLoggedIn);
        startActivity(intent);
    }
    public void openDonate() {
        Intent intent = new Intent(this, Donate.class);
        intent.putExtra("condition", isLoggedIn);
        startActivity(intent);
    }
}
