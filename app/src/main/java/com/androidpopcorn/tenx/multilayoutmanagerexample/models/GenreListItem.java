package com.androidpopcorn.tenx.multilayoutmanagerexample.models;

public class GenreListItem extends BaseListItem {

    private String mGenre;

    public String getmGenre() {
        return mGenre;
    }

    public GenreListItem(String genre) {
        this.mGenre = genre;
    }

    @Override
    public int getType() {
        return BaseListItem.TYPE_LINEAR;
    }
}
