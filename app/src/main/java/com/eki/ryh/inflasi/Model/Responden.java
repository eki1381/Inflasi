package com.eki.ryh.inflasi.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by user on 07/02/2018.
 */

@Entity(tableName = "Responden")
public final class Responden {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int respId;

    @NonNull
    private String respName;

    public Responden(@NonNull String respName) {
        this.respName = respName;
    }

    public void setRespId(@NonNull int respId) {
        this.respId = respId;
    }

    @NonNull
    public int getRespId() {
        return respId;
    }

    @NonNull
    public String getRespName() {
        return respName;
    }
}
