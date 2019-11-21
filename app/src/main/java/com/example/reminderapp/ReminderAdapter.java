package com.example.reminderapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.reminderapp.model.Reminder;

import java.util.List;

public class ReminderAdapter extends ArrayAdapter<Reminder> {
    //deklarasi
    private Context context;
    private List<Reminder> reminderList;

    //construktor
    public ReminderAdapter(Context context, List<Reminder> objects){
        super(context, R.layout.item_reminder, objects);

        //inisiasi variable
        this.context = context;
        this.reminderList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //mengikat adapter ke dalam layout item_reminder
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_reminder, parent, false);
        }

        //deklarasi dan inisiasi class view
        TextView tvNamaReminder = convertView.findViewById(R.id.tv_nama_reminder);
        TextView tvTglWtReminder = convertView.findViewById(R.id.tv_tanggal_dan_waktu);
        TextView tvTagPrioritas = convertView.findViewById(R.id.tv_tag_dan_prioritas);
        TextView tvFrekuensiReminder = convertView.findViewById(R.id.tv_frekuensi_reminder);
        //mengambil data dari arrayList dan dimasukkan ke dalam model
        Reminder reminder = reminderList.get(position);

        //mempopulasikan data ke dalam view
        tvNamaReminder.setText(reminder.getNamaReminder());
        tvTglWtReminder.setText(reminder.getTanggal()+ "|" +reminder.getWaktu());
        tvTagPrioritas.setText(reminder.getTag()+ "|"+ reminder.getPrioritas());
        tvFrekuensiReminder.setText(reminder.getFrekuensiData());

        return convertView;

    }
}
