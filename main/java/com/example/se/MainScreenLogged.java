package com.example.se;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreenLogged extends AppCompatActivity {
    Button shopButton, donateButton, logoutButton, btnAdmin;
    private boolean isLoggedin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen_logged);

        isLoggedin = getIntent().getExtras().getBoolean("condition");

        shopButton = findViewById(R.id.btnShop);
        donateButton = findViewById(R.id.btnDonate);
        logoutButton = findViewById(R.id.logout);
        btnAdmin = findViewById(R.id.admin);

        Shop();
        Donate();
        Logout();
        Admin();
    }

    public  void Logout() {
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
    }

    public void logout() {
        Intent intent = new Intent(this, MainScreen.class);
        intent.putExtra("condition", false);
        startActivity(intent);

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
        intent.putExtra("condition", isLoggedin);
        startActivity(intent);
    }
    public  void Shop() {
        shopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openShop();
            }
        });
    }
    public  void Donate() {
        donateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDonate();
            }
        });
    }
    public void openShop() {
        Intent intent = new Intent(this, Shop.class);
        intent.putExtra("condition", isLoggedin);
        startActivity(intent);

    }
    public void openDonate() {
        Intent intent = new Intent(this, Donate.class);
        intent.putExtra("condition", isLoggedin);
        startActivity(intent);
    }
}
