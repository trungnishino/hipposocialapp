package com.hipposocial.app.fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hipposocial.app.R;
import com.hipposocial.app.adapter.Ad_Search;
import com.hipposocial.app.model.Search;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fr_Search extends Fragment {

    Context mContext;
    RecyclerView recyclerView;

    public Fr_Search() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fr_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        Ad_Search ad_search = new Ad_Search(mContext, getdata());
        recyclerView.setAdapter(ad_search);
    }

    private ArrayList<Search> getdata() {
        ArrayList<Search> arrayList = new ArrayList<>();
        arrayList.add(new Search("Doru fadi", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRoMnq8bzCU6CUb2PkFvfBnME6H6qYtnZe6n8_t1Cmh3392Kk8e"));
        arrayList.add(new Search("Porana Nasd", "https://mobirise.com/bootstrap-template/profile-template/assets/images/timothy-paul-smith-256424-1200x800.jpg"));
        arrayList.add(new Search("Brigette Hyacinth ", "https://i.ytimg.com/vi/7Xu_s1YJhyg/maxresdefault.jpg"));
        arrayList.add(new Search("Tommy Coolio", "https://content-static.upwork.com/uploads/2014/10/02123010/profilephoto_goodcrop.jpg"));
        arrayList.add(new Search("Rayan Ford", "https://images.askmen.com/1080x540/2016/01/25-021526-facebook_profile_picture_affects_chances_of_getting_hired.jpg"));
        arrayList.add(new Search("Maria Staver", "https://www.rd.com/wp-content/uploads/2017/09/01-shutterstock_476340928-Irina-Bg.jpg"));
        return arrayList;
    }
}
