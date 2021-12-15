package com.eggyfawwas.myquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView txt_nilai,txt_comment;
    Button report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().hide();

        txt_nilai = findViewById(R.id.txt_nilai);
        txt_comment = findViewById(R.id.txt_comment);
        report = findViewById(R.id.btn_report);

        int nilai = getIntent().getExtras().getInt("nilai");
        txt_nilai.setText(String.valueOf(nilai));

        if(nilai >= 80) {
            txt_comment.setText("Kamu hebat!");
        }else if(nilai >= 60) {
            txt_comment.setText("Kamu cukup baik, namun perlu ditingkatkan!");
        }else {
            txt_comment.setText("Kamu harus belajar lagi!");
        }

        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (ResultActivity.this, ReportActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

}
