package com.hipposocial.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hipposocial.app.R;
import com.hipposocial.app.adapter.holder.ViewHolderGallery;

import java.util.ArrayList;

public class Ad_Gallery extends RecyclerView.Adapter<ViewHolderGallery> {

    Context mContext;
    ArrayList<String> data;

    public Ad_Gallery(Context context, ArrayList<String> images) {
        mContext = context;
        data = images;
    }

    @NonNull
    @Override
    public ViewHolderGallery onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_gallery , parent,false);
        return new ViewHolderGallery(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderGallery holder, int position) {
        String imageUrl = data.get(position);
        Glide.with(mContext).load(imageUrl).into(holder.gallery_image);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
