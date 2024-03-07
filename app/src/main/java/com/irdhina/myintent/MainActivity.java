package com.irdhina.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnGo, btnSubmit;
    EditText etUrl, etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGo = findViewById(R.id.btnGo);
        etUrl = findViewById(R.id.etUrl);
        btnSubmit = findViewById(R.id.btnSubmit);
        etName = findViewById(R.id.etName);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = etUrl.getText().toString().trim();

                if (!url.isEmpty()) {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(i);
                }
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();

                Intent i = new Intent(getApplicationContext(), SecondActivity.class);

                 i.putExtra("key_name", name);

                startActivity(i);
            }
        });
    }
}