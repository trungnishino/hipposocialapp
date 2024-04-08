/*
 * *
 *  * Created by Mohammed Alsudani on 7/14/19 12:45 AM
 *   linkedin =  https://www.linkedin.com/in/alsudani-mohammed-259a28152
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 7/14/19 12:45 AM
 *
 */

package com.hipposocial.app.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hipposocial.app.R;
import com.hipposocial.app.adapter.Ad_Chat;
import com.hipposocial.app.adapter.Ad_list;
import com.hipposocial.app.model.Chat;
import com.hipposocial.app.model.Stories;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fr_Chats extends Fragment {

    private Context mContext;

    public Fr_Chats() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fr_chat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        RecyclerView chats_Recycler = view.findViewById(R.id.RecyclerView);
        RecyclerView stores_Recycler = view.findViewById(R.id.RecyclerViewStores);


        chats_Recycler.setLayoutManager(new LinearLayoutManager(mContext));
        chats_Recycler.setHasFixedSize(false);
        Ad_Chat ad_chats = new Ad_Chat(getChatData(), mContext);
        chats_Recycler.setAdapter(ad_chats);

        stores_Recycler.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false));
        chats_Recycler.setHasFixedSize(false);
        Ad_list ad_list = new Ad_list(getData(), mContext);
        stores_Recycler.setAdapter(ad_list);


    }

    private ArrayList<Chat> getChatData() {
        ArrayList<Chat> arrayList = new ArrayList<>();
        arrayList.add(new Chat("Doru fadi", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRoMnq8bzCU6CUb2PkFvfBnME6H6qYtnZe6n8_t1Cmh3392Kk8e", "hi"));
        arrayList.add(new Chat("Porana Nasd", "https://mobirise.com/bootstrap-template/profile-template/assets/images/timothy-paul-smith-256424-1200x800.jpg", "where are you"));
        arrayList.add(new Chat("Brigette Hyacinth ", "https://i.ytimg.com/vi/7Xu_s1YJhyg/maxresdefault.jpg", "that's awesome"));
        arrayList.add(new Chat("Tommy Coolio", "https://content-static.upwork.com/uploads/2014/10/02123010/profilephoto_goodcrop.jpg", "hello"));
        arrayList.add(new Chat("Rayan Ford", "https://images.askmen.com/1080x540/2016/01/25-021526-facebook_profile_picture_affects_chances_of_getting_hired.jpg", "lets go now"));
        arrayList.add(new Chat("Maria Staver", "https://www.rd.com/wp-content/uploads/2017/09/01-shutterstock_476340928-Irina-Bg.jpg", "see you "));
        return arrayList;
    }

    private ArrayList<Stories> getData() {
        ArrayList<Stories> arrayList = new ArrayList<>();
        arrayList.add(new Stories("https://yt3.ggpht.com/bIHY6TDWPd-5ni8rGLBIry1dNNUW1YrOsmhvEyFf2CrOFrsYRIhdOLm8ODLlyhBpyC7wfYbgQbw=s900-c-k-c0xffffffff-no-rj-mo", "ali"));
        arrayList.add(new Stories("https://cdn.vox-cdn.com/thumbor/hJq_hq_GDsldfqsPJJIw8xJX-rA=/0x354:1064x1166/1200x800/filters:focal(376x510:546x680)/cdn.vox-cdn.com/uploads/chorus_image/image/56956201/2x3__25_.0.png", "salah"));
        arrayList.add(new Stories("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQJqNY9tNsNMOq2rZ4VTVh_rw_7Bi7QgpLyA1ZDCKzoaROy-Et", "Noor"));
        arrayList.add(new Stories("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRcai8fsvjYdJiUs4bTNVoCJxwrI1ULzZc8CuFkZQu9JaIpPlZE", "Naroto"));
        arrayList.add(new Stories("https://cdn.animenewsnetwork.com/thumbnails/max400x400/cms/news.3/150796/vegmovie.jpg", "Delayed"));
        arrayList.add(new Stories("https://avatarfiles.alphacoders.com/752/75205.png", "Kaneki"));
        arrayList.add(new Stories("https://displate.com/displates/2015-06-24/ccd7b20be2db6f02da7886f7bc9fb423.jpg?w=280", "Manga"));
        return arrayList;
    }


}
