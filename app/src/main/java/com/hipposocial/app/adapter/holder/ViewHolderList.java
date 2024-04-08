package com.hipposocial.app.adapter.holder;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.hipposocial.app.R;
import com.hipposocial.app.adapter.Ad_list;
import com.hipposocial.app.model.Post;
import com.hipposocial.app.model.Stories;
import com.hipposocial.app.utility.CenterZoomLayoutManager;

import java.util.ArrayList;

public class ViewHolderList extends RecyclerView.ViewHolder {

    private RecyclerView recyclerView;
    CenterZoomLayoutManager centerZoomLayoutManager;
    LinearSnapHelper snapHelper;

    public ViewHolderList(@NonNull View itemView, Context mContext) {
        super(itemView);
        recyclerView = itemView.findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(false);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setFocusable(false);
        centerZoomLayoutManager = new CenterZoomLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(centerZoomLayoutManager);
        snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        recyclerView.setOnFlingListener(snapHelper);
        Ad_list ad_list = new Ad_list(getData(), mContext);
        recyclerView.setAdapter(ad_list);
        recyclerView.smoothScrollToPosition(1);

    }

    public void setData(Post post, Context mContext) {

    }

    private ArrayList<Stories> getData() {
        ArrayList<Stories> arrayList = new ArrayList<>();
        arrayList.add(new Stories("https://yt3.ggpht.com/bIHY6TDWPd-5ni8rGLBIry1dNNUW1YrOsmhvEyFf2CrOFrsYRIhdOLm8ODLlyhBpyC7wfYbgQbw=s900-c-k-c0xffffffff-no-rj-mo", "ali"));
        arrayList.add(new Stories("https://cdn.vox-cdn.com/thumbor/hJq_hq_GDsldfqsPJJIw8xJX-rA=/0x354:1064x1166/1200x800/filters:focal(376x510:546x680)/cdn.vox-cdn.com/uploads/chorus_image/image/56956201/2x3__25_.0.png", "salah"));
        arrayList.add(new Stories("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQJqNY9tNsNMOq2rZ4VTVh_rw_7Bi7QgpLyA1ZDCKzoaROy-Et", "Noor"));
        arrayList.add(new Stories("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRcai8fsvjYdJiUs4bTNVoCJxwrI1ULzZc8CuFkZQu9JaIpPlZE", "Naruto"));
        arrayList.add(new Stories("https://cdn.animenewsnetwork.com/thumbnails/max400x400/cms/news.3/150796/vegmovie.jpg", "Delayed"));
        arrayList.add(new Stories("https://avatarfiles.alphacoders.com/752/75205.png", "Kaneki"));
        arrayList.add(new Stories("https://displate.com/displates/2015-06-24/ccd7b20be2db6f02da7886f7bc9fb423.jpg?w=280", "Manga"));
        return arrayList;
    }
}
