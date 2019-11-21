package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.reminderapp.model.Reminder;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    //deklarasi
    ListView listView;
    SearchView searchView;
    List<Reminder> reminderList;
    ReminderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inisiasi
        searchView = findViewById(R.id.search_view);
        listView = findViewById(R.id.list_view);
        reminderList = new ArrayList<>();
//        mendaftarkan listview ke dalam contextmenu
        registerForContextMenu(listView);
//membuat searchview dapat melakukan search data
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
//            textsubmit diutamakan digunakan menggunakan internet
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            //textcahnge disarankan digunakan di offline
            @Override
            public boolean onQueryTextChange(String newText) {
                //menghapus data pada arraylist
                reminderList.clear();

//                mengakses realm database
                Realm realm = Realm.getDefaultInstance();
                RealmResults<Reminder> reminderRealmResults = realm.where(Reminder.class).contains("namaReminder", newText).findAll();
//                memasukkan semua data pada RealmResult <> kedalam arraylist
                reminderList.addAll(reminderRealmResults);
//                refresh adapter karena data pada arraylist telah berubah
                adapter.notifyDataSetChanged();
                return false;
            }
        });

        //mengaktifkan clik data pada ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                Toast.makeText(MainActivity.this, "data diklik", Toast.LENGTH_SHORT).show();

                //deklaraasi class reminder serta mengambil nilai reminder list yang dipilih
                Reminder reminder = reminderList.get(position);

                //Melakukan intent untuk berpindah activity
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                //mengirim data ke DetailActivity
                intent.putExtra("id", reminder.getId());
                startActivity(intent);
            }
        });

//memanggil fungsi onCreateOptionMenu untuk menampilkan menu pada toolbar

    }

    @Override
    protected void onResume() {
        super.onResume();
        reminderList.clear();
        //mengambil database dari realm
        Realm realm = Realm.getDefaultInstance();
        //memasukkan data dari database dan disimpan kedalam variable reminderList
        RealmResults<Reminder> reminderRealmResults = realm.where(Reminder.class).findAll();
//        memasukkan semua data pada realmResult <> kedalam arraylist
        reminderList.addAll(reminderRealmResults);

        //inisiasi adapter
        adapter = new ReminderAdapter(MainActivity.this, reminderList);
        //mengaktifkan adapter ke listview
        listView.setAdapter(adapter);
    }
//  memanggil fungsi oncreatecontextmenu untuk menampilkan context menu pada view yang terdaftar

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
//memanggil fungsi oncontextitemselect untuk membaca pilihan user pada contextmenu

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        Reminder reminder = reminderList.get(info.position);
        int id = item.getItemId();
        if (id == R.id.action_edit) {
//            aksi edit disini
            Intent intent = new Intent(MainActivity.this, FormReminderActivity.class);
            intent.putExtra("id", reminder.getId());
            startActivity(intent);
        } else if (id == R.id.action_delete) {
//            aksi delete disini
//            menghapus data pada Arratlist yang user pilih
            reminderList.remove(reminder);
//            refresh adapter karena ada perubahan data pada arraylist
            adapter.notifyDataSetChanged();

//            mengakses database
            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
//            menghapus 1 data pada database
            RealmObject realmObject = realm.where(Reminder.class).equalTo("id", reminder.getId()).findFirst();
            if (realmObject != null) {
                realmObject.deleteFromRealm();
            }
            realm.commitTransaction();

        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //memanggil fungsi onOptionsItemSelected untuk membaca pilihan user pada menu serta melakukan aksi

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //mengambil id pada menu
        int itemId = item.getItemId();
        //jika user memilih menu action_add
        if (itemId == R.id.action_add) {
            //pindah activity
            Intent intent = new Intent(MainActivity.this, FormReminderActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
