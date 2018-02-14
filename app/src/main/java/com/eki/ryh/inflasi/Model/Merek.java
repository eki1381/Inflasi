package com.eki.ryh.inflasi.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by user on 07/02/2018.
 */

@Entity(tableName = "Merek")
public class Merek {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int merekId;

    @NonNull
    private String merekName;

    @NonNull
    private String satuan;

    @NonNull
    private int itemId;

    public Merek(@NonNull String merekName,@NonNull String satuan, @NonNull int itemId) {
        this.merekName = merekName;
        this.satuan = satuan;
        this.itemId = itemId;
    }

    @NonNull
    public int getMerekId() {
        return merekId;
    }

    @NonNull
    public String getMerekName() {
        return merekName;
    }

    @NonNull
    public String getSatuan() {
        return satuan;
    }

    @NonNull
    public int getItemId() {
        return itemId;
    }
}
