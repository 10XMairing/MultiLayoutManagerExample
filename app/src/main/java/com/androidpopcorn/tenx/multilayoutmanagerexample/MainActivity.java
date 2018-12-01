package com.androidpopcorn.tenx.multilayoutmanagerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.androidpopcorn.tenx.multilayoutmanagerexample.models.BaseListItem;
import com.androidpopcorn.tenx.multilayoutmanagerexample.models.GenreListItem;
import com.androidpopcorn.tenx.multilayoutmanagerexample.models.SongListItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CustomAdapter adapter;


    private List<BaseListItem> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_main);

        //create some dummy items to see in recycler view - normally this would be fetched from a database -- this is only a test data

        mList.add(new GenreListItem("Hip Hop"));
        mList.add(new SongListItem("Schwey", "Can't Stop"));
        mList.add(new SongListItem("Avantadale Bowling Club", "Years Gone"));
        mList.add(new SongListItem("Mac Miller", "Self Care"));
        mList.add(new SongListItem("Eminem", "Rap God"));
        mList.add(new GenreListItem("Favourite"));
        mList.add(new SongListItem("Ed Sheeran", "2002"));
        mList.add(new SongListItem("John Mayer", "Slow Dancing in a Burning Room"));
        mList.add(new SongListItem("John Mayer", "New Light"));
        mList.add(new SongListItem("Kodaline", "All i want"));
        mList.add(new GenreListItem("80's Rock"));
        mList.add(new SongListItem("Guns and Roses", "Highway to hell"));
        mList.add(new SongListItem("Skidrow", "18 and Life"));
        mList.add(new SongListItem("Bon Jovi", "Summer of 69"));
        mList.add(new SongListItem("Journey", "Always"));


        adapter = new CustomAdapter(this, mList);
        GridLayoutManager manager = new GridLayoutManager(this, 2);

        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int i) {
                int type = mList.get(i).getType();
                if(type == BaseListItem.TYPE_LINEAR){
                    return 2;
                }else {
                    return 1;
                }

            }
        });
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);




    }
}
