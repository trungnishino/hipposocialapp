package com.hipposocial.app.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hipposocial.app.DetailsActivity;
import com.hipposocial.app.MainActivity;
import com.hipposocial.app.R;
import com.hipposocial.app.model.Stories;

import java.util.ArrayList;

public class Ad_list extends RecyclerView.Adapter<Ad_list.holder> {

    ArrayList<Stories> list;
    Context mContext;

    public Ad_list(ArrayList<Stories> data, Context context) {
        mContext = context;
        list = data;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_view, parent, false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        Stories stories = list.get(position);
        holder.name_tx.setText(stories.getName());
        Glide.with(mContext).load(stories.getImageUrl()).into(holder.store_iv);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailsActivity.class);
                intent.putExtra("fr", 2);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class holder extends RecyclerView.ViewHolder {
        ImageView store_iv;
        TextView name_tx;

        public holder(@NonNull View itemView) {
            super(itemView);
            store_iv = itemView.findViewById(R.id.image_store);
            name_tx = itemView.findViewById(R.id.User_Name);
        }
    }
}
