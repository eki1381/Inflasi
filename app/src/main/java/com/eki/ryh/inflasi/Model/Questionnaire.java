package com.eki.ryh.inflasi.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by user on 14/02/2018.
 */

@Entity(tableName = "Questionnaire")
public class Questionnaire {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int questId;

    @NonNull
    private int harga;

    @NonNull
    private String bulan;

    @NonNull
    private String namaBarang;

    @NonNull
    private String namaMerek;

    @NonNull
    private String satuan;

    @NonNull
    private String namaResponden;

    public Questionnaire(@NonNull int harga, @NonNull String bulan, @NonNull String namaBarang, @NonNull String namaMerek, @NonNull String satuan, @NonNull String namaResponden) {
        this.harga = harga;
        this.bulan = bulan;
        this.namaBarang = namaBarang;
        this.namaMerek = namaMerek;
        this.satuan = satuan;
        this.namaResponden = namaResponden;
    }

    @NonNull
    public int getQuestId() {
        return questId;
    }

    public void setQuestId(@NonNull int questId) {
        this.questId = questId;
    }

    @NonNull
    public int getHarga() {
        return harga;
    }

    @NonNull
    public String getBulan() {
        return bulan;
    }

    @NonNull
    public String getNamaBarang() {
        return namaBarang;
    }

    @NonNull
    public String getNamaMerek() {
        return namaMerek;
    }

    @NonNull
    public String getSatuan() {
        return satuan;
    }

    public void setHarga(@NonNull int harga) {
        this.harga = harga;
    }

    public void setBulan(@NonNull String bulan) {
        this.bulan = bulan;
    }

    public void setNamaBarang(@NonNull String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public void setNamaMerek(@NonNull String namaMerek) {
        this.namaMerek = namaMerek;
    }

    public void setSatuan(@NonNull String satuan) {
        this.satuan = satuan;
    }

    public void setNamaResponden(@NonNull String namaResponden) {
        this.namaResponden = namaResponden;
    }

    @NonNull
    public String getNamaResponden() {
        return namaResponden;
    }
}
