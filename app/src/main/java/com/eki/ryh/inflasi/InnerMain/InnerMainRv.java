package com.eki.ryh.inflasi.InnerMain;

import android.graphics.drawable.Drawable;

import com.amulyakhare.textdrawable.TextDrawable;
import com.github.vivchar.rendererrecyclerviewadapter.ViewModel;

/**
 * Created by user on 23/02/2018.
 */

public class InnerMainRv implements ViewModel {
    int questId;

    int harga;

    String bulan;

    String namaBarang;

    String namaMerek;

    String satuan;

    String namaResponden;

    TextDrawable image;

    public InnerMainRv(int questId, int harga, String bulan, String namaBarang, String namaMerek, String satuan, String namaResponden, TextDrawable image) {
        this.questId = questId;
        this.harga = harga;
        this.bulan = bulan;
        this.namaBarang = namaBarang;
        this.namaMerek = namaMerek;
        this.satuan = satuan;
        this.namaResponden = namaResponden;
        this.image = image;
    }

    public int getQuestId() {
        return questId;
    }

    public void setQuestId(int questId) {
        this.questId = questId;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(TextDrawable image) {
        this.image = image;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getNamaMerek() {
        return namaMerek;
    }

    public void setNamaMerek(String namaMerek) {
        this.namaMerek = namaMerek;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getNamaResponden() {
        return namaResponden;
    }

    public void setNamaResponden(String namaResponden) {
        this.namaResponden = namaResponden;
    }
}
