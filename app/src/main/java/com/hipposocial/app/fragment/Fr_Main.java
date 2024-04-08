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
import com.hipposocial.app.adapter.Ad_Main;
import com.hipposocial.app.model.Post;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fr_Main extends Fragment {

    private Context mContext;
    RecyclerView recyclerView;

    public Fr_Main() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fr_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setNestedScrollingEnabled(false);
        Ad_Main ad_main = new Ad_Main(mContext, getData());
        recyclerView.setAdapter(ad_main);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    private ArrayList<Post> getData() {
        ArrayList<Post> arrayList = new ArrayList<>();
        arrayList.add(new Post("", R.drawable.post, "", 2));
        arrayList.add(new Post("", R.drawable.post2, "", 0));
        arrayList.add(new Post("https://www.radiantmediaplayer.com/media/bbb-360p.mp4", 0, "", 1));
        arrayList.add(new Post("", R.drawable.post3, "", 0));
        arrayList.add(new Post("", R.drawable.post4, "", 0));
        arrayList.add(new Post("", R.drawable.profile, "", 0));
        return arrayList;
    }


}
