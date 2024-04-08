package com.hipposocial.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hipposocial.app.DetailsActivity;
import com.hipposocial.app.R;
import com.hipposocial.app.adapter.holder.ViewHolderSearch;
import com.hipposocial.app.model.Search;

import java.util.ArrayList;

public class Ad_Search extends RecyclerView.Adapter<ViewHolderSearch> {

    Context mContext;
    ArrayList<Search> arrayList;

    public Ad_Search(Context context, ArrayList<Search> getdata) {
        mContext = context;
        arrayList = getdata;
    }

    @NonNull
    @Override
    public ViewHolderSearch onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search, parent, false);
        return new ViewHolderSearch(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSearch holder, int position) {
        setFadeAnimation(holder.itemView);
        Search search = arrayList.get(position);
        holder.text_name.setText(search.getName());
        Glide.with(mContext).load(search.getProfileImage()).into(holder.profileImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailsActivity.class);
                intent.putExtra("fr", 3);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500);
        view.startAnimation(anim);
    }
}
