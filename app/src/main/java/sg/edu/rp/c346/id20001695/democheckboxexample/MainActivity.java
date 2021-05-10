package sg.edu.rp.c346.id20001695.democheckboxexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cb;
    Button btnCheck;
    TextView tvDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb = findViewById(R.id.checkBoxDiscount);
        btnCheck = findViewById(R.id.buttonCheck);
        tvDisplay= findViewById(R.id.textView);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MainActivity", "Inside onClick");
                Toast.makeText(MainActivity.this, "Button Click", Toast.LENGTH_LONG).show();
                if (cb.isChecked()) {
                    double pay = calcPay(100,20);
                    tvDisplay.setText("The discount is given, pay $" + pay);
                }
                else {
                    double pay = calcPay(100, 0);
                    tvDisplay.setText("The discount is not given, pay $" + pay);
                }
            }
        });
    }

    private double calcPay(double price, double discount) {
        double pay = price * (1 - discount / 100);
        return pay;
    }
}