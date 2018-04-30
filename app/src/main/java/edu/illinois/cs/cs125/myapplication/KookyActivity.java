package edu.illinois.cs.cs125.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class KookyActivity extends AppCompatActivity {
    Button normalMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kooky);
        normalMode = (Button) findViewById(R.id.normalMode);
        normalMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNormal();
            }
        });

    }
    public void openNormal() {
        Intent intent = new Intent(this, CalenderActivity.class);
        startActivity(intent);
    }
}
