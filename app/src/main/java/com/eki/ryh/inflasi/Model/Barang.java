package com.eki.ryh.inflasi.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by user on 07/02/2018.
 */

@Entity(tableName = "Barang")
public class Barang {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private String itemId;

    @NonNull
    private String itemName;

    public Barang(@NonNull String itemName) {
        this.itemName = itemName;
    }

    @NonNull
    public String getItemId() {
        return itemId;
    }

    @Nullable
    public String getItemName() {
        return itemName;
    }
}
