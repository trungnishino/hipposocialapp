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
import com.hipposocial.app.adapter.holder.ViewHolderList;
import com.hipposocial.app.adapter.holder.ViewHolderPost;
import com.hipposocial.app.adapter.holder.ViewHolderVideo;
import com.hipposocial.app.model.Post;

import java.util.ArrayList;

public class Ad_Main extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<Post> list;
    private Context mContext;

    private static final int TYPE_POST = 0;
    private static final int TYPE_VIDEO = 1;
    private static final int TYPE_LIST = 2;

    public Ad_Main(Context context, ArrayList<Post> data) {
        this.list = data;
        mContext = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder viewHolder = null;

        switch (viewType) {
            case TYPE_POST:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
                viewHolder = new ViewHolderPost(view);
                break;
            case TYPE_VIDEO:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
                viewHolder = new ViewHolderVideo(view);
                break;
            case TYPE_LIST:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
                viewHolder = new ViewHolderList(view ,mContext);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Post post = list.get(position);
        setFadeAnimation(holder.itemView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailsActivity.class);
                intent.putExtra("fr", 3);
                mContext.startActivity(intent);
            }
        });
        switch (holder.getItemViewType()) {
            case TYPE_POST:
                ViewHolderPost viewHolderPost = (ViewHolderPost) holder;
                Glide.with(mContext).load(post.getImage()).into(viewHolderPost.imageView);
                if(isOddNumber(position)){
                    Glide.with(mContext).load(R.drawable.ic_favorite_heart).into(viewHolderPost.like);
                }
                break;
            case TYPE_VIDEO:
                ViewHolderVideo viewHolderVideo = (ViewHolderVideo) holder;
                viewHolderVideo.setData(post , mContext);
                if(isOddNumber(position)){
                    Glide.with(mContext).load(R.drawable.ic_favorite_heart).into(viewHolderVideo.like);
                }
                break;
            case TYPE_LIST:
                ViewHolderList viewHolderList = (ViewHolderList) holder;
                viewHolderList.setData(post , mContext);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {

        if (list.get(position).getType() == TYPE_POST) {
            return TYPE_POST;
        } else if (list.get(position).getType() == TYPE_VIDEO) {
            return TYPE_VIDEO;
        } else if (list.get(position).getType() == TYPE_LIST) {
            return TYPE_LIST;
        } else {
            return -1;
        }
    }
    public void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500);
        view.startAnimation(anim);
    }

    public boolean isOddNumber(int num) {
        return (num & 1) != 0;
    }

}
