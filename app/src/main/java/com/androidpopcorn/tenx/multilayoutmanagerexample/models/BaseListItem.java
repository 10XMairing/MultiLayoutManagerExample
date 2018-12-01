package com.androidpopcorn.tenx.multilayoutmanagerexample.models;

public abstract class BaseListItem {


    public static int TYPE_LINEAR=0;
    public static int TYPE_GRID =1;

    public abstract int getType();
}
