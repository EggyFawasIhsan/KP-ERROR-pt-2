package com.eggyfawwas.myquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LihatHasilActivity extends AppCompatActivity {
protected Cursor cursor;
DatabaseHelper databaseHelper;
Button btnkembali;
TextView txtnama,txtkelas,txtsekolah,txtnilaimu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_hasil);
        getSupportActionBar().hide();
        databaseHelper = new DatabaseHelper(this);
        txtnama = (TextView) findViewById(R.id.txtnama);
        txtkelas = (TextView) findViewById(R.id.txtkelas);
        txtsekolah = (TextView) findViewById(R.id.txtsekolah);
        txtnilaimu = (TextView) findViewById(R.id.txtnilaimu);
        SQLiteDatabase database = databaseHelper.getReadableDatabase();
        cursor = database.rawQuery("SELECT * FROM peserta WHERE nama = '" +
                getIntent().getStringExtra("nama")+ "'", null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            txtnama.setText(cursor.getString(0).toString());
            txtkelas.setText(cursor.getString(1).toString());
            txtsekolah.setText(cursor.getString(2).toString());
            txtnilaimu.setText(cursor.getString(3).toString());
        }
        btnkembali = (Button) findViewById(R.id.btnkembali);
        btnkembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void kembali(View view) {
        Intent intent = new Intent(LihatHasilActivity.this, ReportActivity.class);
        startActivity(intent);
    }
}