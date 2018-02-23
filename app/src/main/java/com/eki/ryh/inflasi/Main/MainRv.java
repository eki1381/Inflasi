package com.eki.ryh.inflasi.Main;

import android.graphics.drawable.Drawable;

import com.amulyakhare.textdrawable.TextDrawable;
import com.github.vivchar.rendererrecyclerviewadapter.ViewModel;

/**
 * Created by user on 22/02/2018.
 */

public class MainRv implements ViewModel {

    TextDrawable image;

    String title;

    public MainRv(TextDrawable image, String title) {
        this.image = image;
        this.title = title;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(TextDrawable image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
