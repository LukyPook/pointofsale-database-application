package com.example.se;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

public class AccountInformation extends AppCompatActivity {
    EditText firstName, lastName, newfn, newln, newemail, newpw;
    Button check, can, btnchanges;
    private int index;
    private boolean isLoggedin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_information);

        isLoggedin = getIntent().getExtras().getBoolean("condition");

        firstName = findViewById(R.id.editText_firstname);
        lastName = findViewById(R.id.editText_lastname);
        newfn = findViewById(R.id.editText_newfn);
        newln = findViewById(R.id.editText_newln);
        newemail = findViewById(R.id.editText_newemail);
        newpw = findViewById(R.id.editText_newpw);
        can = findViewById(R.id.cancel);
        check = findViewById(R.id.check);
        btnchanges = findViewById(R.id.changes);

        Cancel();
        Changes();
        Check();

    }
    public  void Cancel() {
        can.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            returntoMain();

          }
        });
    }
    public void returntoMain() {
        Intent intent = new Intent(this, AdminAccessPage.class);
        intent.putExtra("condition", false);
        startActivity(intent);
    }

    public  void Changes() {
        btnchanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Account> dbase = Account.returnList();
                Account temp = new Account(newemail.getText().toString(), newpw.getText().toString(),
                                newfn.getText().toString(), newln.getText().toString());

                dbase.set(index, temp);
                changes();

            }
        });
    }
    public void changes() {
        Toast.makeText(this, "Account Information Changed", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainScreen.class);
        intent.putExtra("condition", false);
        startActivity(intent);
    }

    public  void Check() {
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Account> dbase = Account.returnList();
                for(int i = 0; i < dbase.size(); i++) {
                    if(dbase.get(i).name.equals(firstName.getText().toString()) && dbase.get(i).lastName.equals(lastName.getText().toString())) {
                        index = i;
                        check();
                    }
                }


            }
        });
    }
    public void check() {
            Toast.makeText(this, "This account was found in our database! Please proceed with making changes.", Toast.LENGTH_LONG).show();

    }
}
