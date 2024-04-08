/*
 * *
 *  * Created by Mohammed Alsudani on 7/14/19 5:21 AM
 *   linkedin =  https://www.linkedin.com/in/alsudani-mohammed-259a28152
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 7/14/19 5:21 AM
 *
 */

package com.hipposocial.app.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hipposocial.app.DetailsActivity;
import com.hipposocial.app.R;
import com.hipposocial.app.adapter.Ad_Messenger;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fr_Messenger extends Fragment implements View.OnClickListener {


    private Context mContext;
    RecyclerView recyclerView;


    public Fr_Messenger() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fr_messenger, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.reyclerview_message_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        Ad_Messenger ad_messenger = new Ad_Messenger(mContext);
        recyclerView.setAdapter(ad_messenger);

    }


    @Override
    public void onClick(View v) {

    }
}
