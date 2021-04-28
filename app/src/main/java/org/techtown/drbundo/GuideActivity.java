package org.techtown.drbundo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class GuideActivity extends AppCompatActivity {
    Button plastic;
    Button vinyl;
    Button styro;
    Button glass;
    ImageView titleguide;
    Button QA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        plastic = (Button)findViewById(R.id.plastic);
        vinyl = (Button)findViewById(R.id.vinyl);
        styro = (Button)findViewById(R.id.styro);
        glass = (Button)findViewById(R.id.glass);

        titleguide = (ImageView)findViewById(R.id.guideimage);

        QA = (Button)findViewById(R.id.QA);

        titleguide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titleguide.setImageResource(R.drawable.guide7);
            }
        });

        plastic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titleguide.setImageResource(R.drawable.guide3);
            }
        });

        vinyl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titleguide.setImageResource(R.drawable.guide4);
            }
        });

        styro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titleguide.setImageResource(R.drawable.guide5);
            }
        });

        glass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titleguide.setImageResource(R.drawable.guide6);
            }
        });

        QA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AskActivity.class);
                startActivity(intent);
            }
        });

    }
}