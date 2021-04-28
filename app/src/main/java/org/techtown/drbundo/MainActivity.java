package org.techtown.drbundo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button guidebook;
    Button scanbarcode;
    Button evaluate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guidebook = (Button)findViewById(R.id.guidebook);
        guidebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GuideActivity.class);
                startActivity(intent);
            }
        });

        scanbarcode = (Button)findViewById(R.id.barcode);
        scanbarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), ScanActivity.class);
                startActivity(intent2);
            }
        });

        evaluate = (Button)findViewById(R.id.evaluate);
        evaluate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), EvaluateActivity.class);
                startActivity(intent3);
            }
        });

    }
}