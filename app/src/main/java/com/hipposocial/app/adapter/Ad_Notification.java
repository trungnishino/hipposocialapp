package com.hipposocial.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hipposocial.app.R;
import com.hipposocial.app.adapter.holder.ViewHolderNotification;
import com.hipposocial.app.model.Notification;

import java.util.ArrayList;

public class Ad_Notification extends RecyclerView.Adapter<ViewHolderNotification> {

    Context mContext;
    ArrayList<Notification> dataList;

    public Ad_Notification(Context context, ArrayList<Notification> data) {
        this.mContext = context;
        this.dataList = data;
    }

    @NonNull
    @Override
    public ViewHolderNotification onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification, parent, false);
        return new ViewHolderNotification(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderNotification holder, int position) {
        setFadeAnimation(holder.itemView);
        Notification notification = dataList.get(position);
        Glide.with(mContext).load(notification.getProfileImage()).into(holder.imageView);
        holder.name.setText(notification.getName());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500);
        view.startAnimation(anim);
    }
}
