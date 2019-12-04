package com.example.se;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Shop extends AppCompatActivity {

    private static final double [] price = {49.99, 19.99, 15.99, 21.99, 24.99};
    private double result;
    private static final int[] imageArray = {
            R.drawable.bag,
            R.drawable.hat,
            R.drawable.catty,
            R.drawable.pillow,
            R.drawable.shirt
    };
    private ArrayList<EditText> ets;
    private boolean isLoggedin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        isLoggedin = getIntent().getExtras().getBoolean("condition");

        ets = new ArrayList<>();
        final LinearLayout layout = findViewById(R.id.activity_main);
        View inflatedView;
        final TextView resultView = new TextView(this);

        for (int i = 0; i < 5; i++) {
            inflatedView = getLayoutInflater().inflate(R.layout.language, null);
            ImageView iv = inflatedView.findViewById(R.id.icon);

            TextView tv = inflatedView.findViewById(R.id.tv);
            tv.setText("Price: $" + price[i]);

            iv.setImageResource(imageArray[i]);
            layout.addView(inflatedView);

            EditText edt = inflatedView.findViewById(R.id.ed);
            ets.add(edt);
        }

        Button bt = new Button(this);
        bt.setText("Checkout");
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = 0;
                for (int i = 0; i < 5; i++) {
                    EditText et = ets.get(i);
                    if (et.getText().toString().length() > 0 ) {
                        String s = et.getText().toString();
                        result += Integer.parseInt(s) * price[i];
                    }
                }
                if(result <= 0) {
                    Toast();
                    return;
                }
                else {
                    openCheckout();
                }

            }
        });
        layout.addView(bt);
        layout.addView(resultView);
        resultView.setTextSize(25);
        resultView.setGravity(Gravity.CENTER);

    }
    public void openCheckout() {
        if(isLoggedin) {
            Intent intent = new Intent(this, ShopCheckout.class);
            intent.putExtra("condition", isLoggedin);
            intent.putExtra("total", result);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, ShopCheckout.class);
            intent.putExtra("condition", false);
            intent.putExtra("total", result);
            startActivity(intent);
        }
    }
    public void Toast() {
        Toast.makeText(this, "Please purchase a few items, or use your back page command to go to main screen", Toast.LENGTH_LONG).show();
    }

}