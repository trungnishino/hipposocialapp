package com.hipposocial.app.adapter;

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
import com.hipposocial.app.adapter.holder.ViewHolderChat;
import com.hipposocial.app.adapter.holder.ViewHolderFollow;
import com.hipposocial.app.adapter.holder.ViewHolderSearch;
import com.hipposocial.app.model.Follow;
import com.hipposocial.app.model.Search;

import java.util.ArrayList;

public class Ad_Follow extends RecyclerView.Adapter<ViewHolderFollow> {

    Context mContext;
    ArrayList<Follow> arrayList;

    public Ad_Follow(Context context, ArrayList<Follow> getdata) {
        mContext = context;
        arrayList = getdata;
    }


    @NonNull
    @Override
    public ViewHolderFollow onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_follow, parent, false);
        return new ViewHolderFollow(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFollow holder, int position) {
        setFadeAnimation(holder.itemView);
        Follow follow = arrayList.get(position);
        holder.text_name.setText(follow.getName());
        Glide.with(mContext).load(follow.getProfileImage()).into(holder.profileImage);
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
