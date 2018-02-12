package com.eki.ryh.inflasi.Base;

/**
 * Created by user on 05/02/2018.
 */

import android.content.Context;
import android.support.annotation.NonNull;

public class BasePresenter {
    protected Context mContext;

    public void subscribe(@NonNull Context context) {
        this.mContext = context;
    }

    public boolean isSubscribed() {
        return mContext != null;
    }
}