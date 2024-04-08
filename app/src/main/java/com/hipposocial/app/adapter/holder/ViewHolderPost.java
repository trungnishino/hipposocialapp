package com.hipposocial.app.adapter.holder;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hipposocial.app.R;

public class ViewHolderPost extends RecyclerView.ViewHolder {

    public ImageView imageView , like;

    public ViewHolderPost(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.post_iv);
        like = itemView.findViewById(R.id.like);
    }
}
