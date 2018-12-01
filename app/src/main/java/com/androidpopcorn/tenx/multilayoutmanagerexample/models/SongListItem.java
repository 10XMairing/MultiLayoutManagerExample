package com.androidpopcorn.tenx.multilayoutmanagerexample.models;

public class SongListItem extends BaseListItem {

    private String mArtistName;
    private String mSongName;

    public SongListItem(String artistName, String songName) {
        this.mArtistName = artistName;
        this.mSongName = songName;
    }

    public String getmArtistName() {
        return mArtistName;
    }

    public String getmSongName() {
        return mSongName;
    }

    @Override
    public int getType() {
        return BaseListItem.TYPE_GRID;
    }


}
