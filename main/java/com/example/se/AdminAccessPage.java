package com.example.se;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminAccessPage extends AppCompatActivity {
    Button access, cancel;
    private boolean isLoggedin;
    EditText secretpw;
    private String secretCode = "777";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_access_page);

        isLoggedin = getIntent().getExtras().getBoolean("condition");

        cancel = findViewById(R.id.cancelbtn);
        access = findViewById(R.id.accessbtn);
        secretpw = findViewById(R.id.adminpw);

        AccessPage();
        CancelPage();
    }

    public void access() {
            if(!secretpw.getText().toString().equals(secretCode)) {
                Toast.makeText(this, "Incorrect Code", Toast.LENGTH_LONG).show();
                return;
            }
            else {
                Intent intent = new Intent(this, AdminPage.class);
                intent.putExtra("condition", false);
                startActivity(intent);
            }

    }

    public  void AccessPage() {
        access.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                access();
            }
        });
    }
    public void openCancel() {
            Intent intent = new Intent(this, MainScreenLogged.class);
            intent.putExtra("condition", false);
            startActivity(intent);

    }

    public  void CancelPage() {
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCancel();
            }
        });
    }
}
