package com.eggyfawwas.myquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity {
    protected Cursor cursor;
    DatabaseHelper databaseHelper;
    Button btnmulai,btnreport;
    EditText nama,kelas,sekolah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        getSupportActionBar().hide();
        databaseHelper = new DatabaseHelper(this);
        nama=(EditText) findViewById(R.id.nama);
        sekolah=(EditText) findViewById(R.id.sekolah);
        kelas=(EditText) findViewById(R.id.kelas);
        btnmulai=(Button) findViewById(R.id.btnmulai);
        btnreport=(Button) findViewById(R.id.btnreport);
        btnmulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = databaseHelper.getWritableDatabase();
                db.execSQL("insert into peserta(nama,sekolah,kelas) values ('" + nama.getText().toString() + "','" + sekolah.getText().toString() + "',''" + kelas.getText().toString() + "','");
                Toast.makeText(getApplicationContext(), "SILAHKAN KERJAKAN QUIZ", Toast.LENGTH_LONG).show();
                ReportActivity.ma.Refreshlist();
                finishAffinity();
            }
        });

    }

    public void kirimdata(View view) {
        Intent intent = new Intent(CreateActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void report(View view) {
        Intent intent = new Intent(CreateActivity.this, ReportActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}