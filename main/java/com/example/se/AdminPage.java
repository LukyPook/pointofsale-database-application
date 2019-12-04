package com.example.se;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminPage extends AppCompatActivity {
    Button donBtn, accBtn, canBtn;
    private boolean isLoggedin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        isLoggedin = getIntent().getExtras().getBoolean("condition");

        donBtn = findViewById(R.id.donorBtn);
        accBtn = findViewById(R.id.accountBtn);
        canBtn = findViewById(R.id.cancelBtn);

        DonateInfo();
        CancelPage();
        AccountInfo();
    }

    public void accInfo() {
        Intent intent = new Intent(this, AccountInformation.class);
        intent.putExtra("condition", false);
        startActivity(intent);
    }
    public  void AccountInfo() {
        accBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accInfo();
            }
        });
    }
    public void donInfo() {
        Intent intent = new Intent(this, DonorInformation.class);
        intent.putExtra("condition", false);
        startActivity(intent);
    }
    public  void DonateInfo() {
        donBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                donInfo();
            }
        });
    }

    public void openCancel() {
            Intent intent = new Intent(this, MainScreen.class);
            intent.putExtra("condition", false);
            startActivity(intent);

    }

    public  void CancelPage() {
        canBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCancel();
            }
        });
    }

}
