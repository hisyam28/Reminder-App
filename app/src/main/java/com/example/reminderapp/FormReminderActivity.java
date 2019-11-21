package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.example.reminderapp.model.Reminder;

import io.realm.Realm;
import io.realm.Sort;

public class FormReminderActivity extends AppCompatActivity {

    //Deklarasi
    Button btnSimpan;
    EditText etNama;
    EditText etTanggal;
    EditText etWaktu;
    RadioButton rbPenting;
    RadioButton rbSedang;
    RadioButton rbKecil;
    CheckBox cbMediasi;
    CheckBox cbBelanja;
    CheckBox cbKonsumsi;
    CheckBox cbTravel;
    Spinner spnrPilih;
    Switch swthAktif;
    EditText edCatatan;

    String namaReminder;
    String tanggal;
    String waktu;
    String catatan;
    String frekuensiData;
    String prioritas;
    String tag;
    boolean reminderActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_reminder);

        //Inisiasi
        etNama = findViewById(R.id.et_nama);
        etTanggal = findViewById(R.id.et_tanggal);
        etWaktu = findViewById(R.id.et_waktu);
        rbPenting = findViewById(R.id.rb_penting);
        rbSedang = findViewById(R.id.rb_sedang);
        rbKecil = findViewById(R.id.rb_kecil);
        cbMediasi = findViewById(R.id.cb_mediasi);
        cbBelanja = findViewById(R.id.cb_belanja);
        cbKonsumsi = findViewById(R.id.cb_konsumsi);
        cbTravel = findViewById(R.id.cb_travel);
        spnrPilih = findViewById(R.id.spnr_pilih);
        swthAktif = findViewById(R.id.swth_aktif);
        edCatatan = findViewById(R.id.ed_catatan);
        btnSimpan = findViewById(R.id.btn_simpan);
//        mengambil kiriman intent dari MainActivity
        int id = getIntent().getIntExtra("id", 0);
        if (id > 0) {
//            melakukan aksi ketika id > 0(edit)
//            mengakses database
            Realm realm = Realm.getDefaultInstance();
//                    mengambil baris data berdasarkan id yang didapatkan dari intent extra
            Reminder reminder = realm.where(Reminder.class).equalTo("id", id).findFirst();

//            menginput data ke masing masing view
//            mengisi data ke Edittext
            etNama.setText(reminder.getNamaReminder());
            etTanggal.setText(reminder.getTanggal());
            etWaktu.setText(reminder.getWaktu());
            edCatatan.setText(reminder.getCatatan());
//            mengisi data ke radio button
            if (reminder.getPrioritas().equals("penting")) {
                rbPenting.setChecked(true);
            } else if (reminder.getPrioritas().equals("sedang")) {
                rbSedang.setChecked(true);
            } else if (reminder.getPrioritas().equals("kecil")) {
                rbKecil.setChecked(true);
            }
//mengisi data ke checkbox
            if (reminder.getTag().contains("mediasi")) {
                cbMediasi.setChecked(true);
            }
            if (reminder.getTag().contains("belanja")) {
                cbBelanja.setChecked(true);
            }
            if (reminder.getTag().contains("konsumsi")) {
                cbKonsumsi.setChecked(true);
            }
            if (reminder.getTag().contains("travel")) {
                cbTravel.setChecked(true);
            }
//            mengisi data ke spinner
            ArrayAdapter<String> spinnerApdater = new ArrayAdapter<>(FormReminderActivity.this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.frekuensi_reminder));
            spnrPilih.setSelection(spinnerApdater.getPosition(reminder.getFrekuensiData()));
//            mengisi data ke switch
            swthAktif.setChecked(reminder.isReminderActive());
        }
        // membuat btnsimpan dapat diklik serta melakukan aksi yang diinginkan di dalam onclik
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mengambil value dari edittext dan disimpan didalam string
                // trim berguna agar data yang diinput di database tidak kespasi
                namaReminder = etNama.getText().toString().trim();
                tanggal = etTanggal.getText().toString().trim();
                waktu = etWaktu.getText().toString().trim();
                catatan = edCatatan.getText().toString().trim();

                //mengambil value dari spinner
                frekuensiData = spnrPilih.getSelectedItem().toString();

                //mengambil value dari RadioButton
                prioritas = "";
                if (rbPenting.isChecked()) {
                    prioritas = "penting";
                } else if (rbSedang.isChecked()) {
                    prioritas = "sedang";
                } else if (rbKecil.isChecked()) {
                    prioritas = "kecil";
                }
                //bisa juga syntaxnya if (rbPenting.isChecked()){ prioritas = rbpenting.getText().toString();

                tag = "";
                if (cbMediasi.isChecked()) {
                    tag += "mediasi, ";
                }
                if (cbBelanja.isChecked()) {
                    tag += "belanja, ";
                }
                if (cbKonsumsi.isChecked()) {
                    tag += "konsumsi, ";
                }
                if (cbTravel.isChecked()) {
                    tag += "travel, ";
                }
                // pengunaan + pada sama dengan(=) untuk penambahan data yang dimasukan

                reminderActive = swthAktif.isChecked();

                //insert data ke model
                Reminder reminder = new Reminder();
                reminder.setNamaReminder(namaReminder);
                reminder.setTanggal(tanggal);
                reminder.setWaktu(waktu);
                reminder.setCatatan(catatan);
                reminder.setFrekuensiData(frekuensiData);
                reminder.setPrioritas(prioritas);
                reminder.setTag(tag);
                reminder.setReminderActive(reminderActive);
                int id = getIntent().getIntExtra("id", 0);

                //Memanggil database Realm
                Realm realm = Realm.getDefaultInstance();
                // Membuat id pada Realm auto incremenet
                Number lastId = realm.where(Reminder.class).max("id");

//                jika id > 0 (mode edit)
                if (id > 0) {
                    reminder.setId(id);
                } else {
                    int nextId;
                    if (lastId == null) {
                        nextId = 1;
                    } else {
                        nextId = lastId.intValue() + 1;
                    }
                    reminder.setId(nextId);
                }


                //insert data ke realm database
                realm.beginTransaction();
                realm.insertOrUpdate(reminder);
                realm.commitTransaction();

                //read realm database
                Reminder reminderRealm = realm.where(Reminder.class).sort("id", Sort.DESCENDING).findFirst();

                Toast.makeText(FormReminderActivity.this, "Data berhasil disimpan -> " + reminderRealm.getId(), Toast.LENGTH_SHORT).show();
                finish();

                //action disini tanpa menggunakan realm
//                Toast.makeText(FormReminderActivity.this, "button diclik : " +
//            namaReminder + " " + tanggal + " " + waktu + " " + prioritas + " " + tag + " " + frekuensiData + " " + reminderActive + " " + catatan, Toast.LENGTH_LONG).show();
            }
        });
    }
}
