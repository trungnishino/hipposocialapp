package com.hipposocial.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hipposocial.app.R;
import com.hipposocial.app.adapter.holder.ViewHolderMessengerFrind;
import com.hipposocial.app.adapter.holder.ViewHolderMessengerUser;

public class Ad_Messenger extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int VIEW_TYPE_USER_MESSAGE = 0;
    public static final int VIEW_TYPE_FRIEND_MESSAGE = 1;
    Context mContext;


    public Ad_Messenger(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case VIEW_TYPE_FRIEND_MESSAGE:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_message_friend, parent, false);
                return new ViewHolderMessengerFrind(view);
            case VIEW_TYPE_USER_MESSAGE:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_message_user, parent, false);
                return new ViewHolderMessengerUser(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_USER_MESSAGE;
        }
        return VIEW_TYPE_FRIEND_MESSAGE;
    }

}
