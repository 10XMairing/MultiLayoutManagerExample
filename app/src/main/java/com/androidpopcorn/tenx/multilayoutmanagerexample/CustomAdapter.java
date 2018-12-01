package com.androidpopcorn.tenx.multilayoutmanagerexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidpopcorn.tenx.multilayoutmanagerexample.models.BaseListItem;
import com.androidpopcorn.tenx.multilayoutmanagerexample.models.GenreListItem;
import com.androidpopcorn.tenx.multilayoutmanagerexample.models.SongListItem;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private Context mCtx;
    private List<BaseListItem> mList;

    public CustomAdapter(Context mCtx, List<BaseListItem> mList) {
        this.mCtx = mCtx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View linear = LayoutInflater.from(mCtx).inflate(R.layout.listitem_linear, parent, false);
        View grid = LayoutInflater.from(mCtx).inflate(R.layout.listitem_grid, parent, false);
        if(viewType == BaseListItem.TYPE_GRID){
            return new CustomViewHolder(grid);
        }else {
            return new CustomViewHolder(linear);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        BaseListItem currentItem = mList.get(position);

        if(currentItem.getType() == BaseListItem.TYPE_LINEAR){
            //this is the genre box
            holder.tvGenre.setText(((GenreListItem) currentItem).getmGenre()); //cast BaseListItem to Genre Type

        }else {
            //this is the songs box
            holder.tvSongName.setText("Song: "+((SongListItem) currentItem).getmSongName()); //cast BaseListItem to Song Type
            holder.tvArtist.setText("Artist: "+((SongListItem) currentItem).getmArtistName());
        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getType(); //this is reused at the onCreateViewHolder to set the required view type

    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
         TextView tvArtist,tvSongName,tvGenre;

        public CustomViewHolder(View itemView) {
            super(itemView);
            tvArtist = itemView.findViewById(R.id.tv_name_artist);
            tvSongName = itemView.findViewById(R.id.tv_name_song);
            tvGenre = itemView.findViewById(R.id.tv_genre);


        }
    }
}
