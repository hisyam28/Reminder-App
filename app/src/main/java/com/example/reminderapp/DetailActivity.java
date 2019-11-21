package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.reminderapp.model.Reminder;

import io.realm.Realm;

public class DetailActivity extends AppCompatActivity {

    //deklarasi view
    //deklarasi class
    TextView tvNamaReminder1;
    TextView tvTanggalWaktu1;
    TextView tvPrioritas1;
    TextView tvTag1;
    TextView tvFrekuensi1;
    TextView tvAktif1;
    TextView tvCatatan1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //inisiasi view
        tvNamaReminder1 = findViewById(R.id.tv_nama_reminder1);
        tvTanggalWaktu1 = findViewById(R.id.tv_tanggal_dan_waktu1);
        tvPrioritas1 = findViewById(R.id.tv_prioritas1);
        tvTag1 = findViewById(R.id.tv_tag1);
        tvFrekuensi1 = findViewById(R.id.tv_frekuensi_reminder1);
        tvAktif1 = findViewById(R.id.tv_reminder_aktif1);
        tvCatatan1 = findViewById(R.id.tv_catatan1);

        //mengambil kiriman ID dari mainactivity
        int id = getIntent().getIntExtra("id",0);
        //if disini digunakan agar mengantisipasi bila terdapat crash pada id , agar kembali ke halaman awal saat membuat ID tetap
        if (id > 0){
            //ambil data daru database realm
            Realm realm = Realm.getDefaultInstance();
            Reminder reminder = realm.where(Reminder.class).equalTo("id",id).findFirst();



            tvNamaReminder1.setText(reminder.getNamaReminder());
            tvTanggalWaktu1.setText(reminder.getTanggal()+ " | " +reminder.getWaktu());
            tvPrioritas1.setText(reminder.getPrioritas());
            tvTag1.setText(reminder.getTag());
            tvFrekuensi1.setText(reminder.getFrekuensiData());
            tvAktif1.setText(String.valueOf(reminder.isReminderActive()));
            tvCatatan1.setText(reminder.getCatatan());
        }

    }
}
