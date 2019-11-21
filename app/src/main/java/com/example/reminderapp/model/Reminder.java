package com.example.reminderapp.model;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

//Membuat table untuk Realm bernama Reminder
public class Reminder extends RealmObject {

    //Flied untuk Realm
    @PrimaryKey
    private int id;
    private  String namaReminder;
    private  String tanggal;
    private  String waktu;
    private  String catatan;
    private  String frekuensiData;
    private  String prioritas;
    private  String tag;
    private  boolean reminderActive;
    //klik kanan di code(pada class) generate-getter+setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaReminder() {
        return namaReminder;
    }

    public void setNamaReminder(String namaReminder) {
        this.namaReminder = namaReminder;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public String getFrekuensiData() {
        return frekuensiData;
    }

    public void setFrekuensiData(String frekuensiData) {
        this.frekuensiData = frekuensiData;
    }

    public String getPrioritas() {
        return prioritas;
    }

    public void setPrioritas(String prioritas) {
        this.prioritas = prioritas;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean isReminderActive() {
        return reminderActive;
    }

    public void setReminderActive(boolean reminderActive) {
        this.reminderActive = reminderActive;
    }
}
