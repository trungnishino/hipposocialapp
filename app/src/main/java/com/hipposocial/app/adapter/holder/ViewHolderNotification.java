package com.hipposocial.app.adapter.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hipposocial.app.R;

public class ViewHolderNotification extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView name;

    public ViewHolderNotification(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.Profile_Image);
        name = itemView.findViewById(R.id.User_Name);
    }
}
