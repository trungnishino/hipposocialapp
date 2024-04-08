package com.hipposocial.app.fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hipposocial.app.R;
import com.hipposocial.app.adapter.Ad_Gallery;
import com.hipposocial.app.adapter.Ad_Main;
import com.hipposocial.app.model.Post;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fr_ProfileView extends Fragment {


    private Context mContext;
    RecyclerView recyclerView, RecyclerViewPhoto;
    NestedScrollView nestedScrollView;
    LinearLayout linearLayout;

    public Fr_ProfileView() {
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
        return inflater.inflate(R.layout.fr_profile_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        linearLayout = view.findViewById(R.id.l1);

        nestedScrollView = view.findViewById(R.id.scrollView);
        recyclerView = view.findViewById(R.id.RecyclerView);
        RecyclerViewPhoto = view.findViewById(R.id.RecyclerViewPhoto);

        RecyclerViewPhoto.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false));
        Ad_Gallery ad_gallery = new Ad_Gallery(mContext, getImages());
        RecyclerViewPhoto.setFocusable(false);
        RecyclerViewPhoto.setAdapter(ad_gallery);

        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setFocusable(false);
        Ad_Main ad_main = new Ad_Main(mContext, getData());
        recyclerView.setAdapter(ad_main);
        nestedScrollView.scrollTo(0, 0);
        linearLayout.requestFocus();
        RecyclerViewPhoto.setFocusable(false);
        recyclerView.setFocusable(false);


    }

    private ArrayList<String> getImages() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("https://images.wallpapersden.com/image/download/helldivers-2-gaming_bmdnaG6UmZqaraWkpJRmbmdlrWZnZWU.jpg");
        arrayList.add("https://images.wallpapersden.com/image/download/gojo-vs-sukuna-jujutsu-kaisen-battle_bmdnaGaUmZqaraWkpJRmbmdsrWZlbWU.jpg");
        arrayList.add("https://images.wallpapersden.com/image/download/gojo-satoru-cool-jujutsu-kaisen_bmZramWUmZqaraWkpJRobWllrWdmamg.jpg");
        arrayList.add("https://images.wallpapersden.com/image/download/satoru-gojo-x-sukuna-hd-jujutsu-kaisen-epic-art_bmdma22UmZqaraWkpJRmbmdsrWZlbWU.jpg");
        arrayList.add("https://images.wallpapersden.com/image/download/sukuna-digital-art-of-jujutsu-kaisen_bmdmamyUmZqaraWkpJRmbmdsrWZlbWU.jpg");
        arrayList.add("https://images.wallpapersden.com/image/download/blazblue-entropy-effect-2024_bmdmZWqUmZqaraWkpJRobWllrWdma2U.jpg");
        arrayList.add("https://images.wallpapersden.com/image/download/anime-city-4k-aesthetic_bmZuZ2iUmZqaraWkpJRobmVprWdnaWU.jpg");
        arrayList.add("https://images.wallpapersden.com/image/download/demoness-2023-art_bmZtamuUmZqaraWkpJRnbmZnrWZraGc.jpg");
        return arrayList;
    }

    private ArrayList<Post> getData() {
        ArrayList<Post> arrayList = new ArrayList<>();
        arrayList.add(new Post("", R.drawable.post2, "", 0));
        arrayList.add(new Post("", R.drawable.post3, "", 0));
        arrayList.add(new Post("", R.drawable.post4, "", 0));
        arrayList.add(new Post("", R.drawable.profile, "", 0));
        arrayList.add(new Post("https://www.radiantmediaplayer.com/media/bbb-360p.mp4", 0, "", 1));
        return arrayList;
    }
}
