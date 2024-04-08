package com.hipposocial.app.fragment;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hipposocial.app.R;
import com.hipposocial.app.utility.StoriesProgressView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fr_Stories extends Fragment implements StoriesProgressView.StoriesListener {


    public Fr_Stories() {
        // Required empty public constructor
    }

    Context mContext;
    private static final int PROGRESS_COUNT = 10;

    private StoriesProgressView storiesProgressView;
    private ImageView image , close;

    private int counter = 0;
    private final String[] resources = new String[]{
            "https://images.wallpapersden.com/image/download/fortnite-chapter-5-season-2_bmdpaWiUmZqaraWkpJRqZmdlrWdtbWU.jpg",
            "https://images.wallpapersden.com/image/download/8-bit-programmer-4k-pixel-art_bmdpZ2qUmZqaraWkpJRobWllrWdma2U.jpg",
            "https://images.wallpapersden.com/image/download/ghostrunner-game-tunnel_bGlpbmeUmZqaraWkpJRmbmdlrWZlbWU.jpg",
            "https://images.wallpapersden.com/image/download/statue-of-god-hd-solo-leveling-digital_bmdqZW6UmZqaraWkpJRnaW1lrWZubmc.jpg",
            "https://images.wallpapersden.com/image/download/sova-omen-and-cypher-valorant-team_bmdpZWaUmZqaraWkpJRobWllrWdma2U.jpg",
            "https://images.wallpapersden.com/image/download/zhongli-4k-genshin-impact-digital-2k24-portrait_bmdoaG2UmZqaraWkpJRoamVlrWdqZWU.jpg",
            "https://images.wallpapersden.com/image/download/goku-rage-hd-dragon-ball-z_bmdoaW2UmZqaraWkpJRmbmdsrWZlbWU.jpg",
            "https://images.wallpapersden.com/image/download/hd-rpg-arknights-girls-cool-art_bmdoZmuUmZqaraWkpJRmbmdlrWZlbWU.jpg",
            "https://images.wallpapersden.com/image/download/sung-jin-woo-digital-solo-leveling_bmdnam6UmZqaraWkpJRmbmdsrWZlbWU.jpg",
            "https://images.wallpapersden.com/image/download/gojo-vs-sukuna-jujutsu-kaisen-battle_bmdnaGaUmZqaraWkpJRmbmdsrWZlbWU.jpg"
    };


    long pressTime = 0L;
    long limit = 500L;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fr_stories, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        storiesProgressView = view.findViewById(R.id.stories);
        storiesProgressView.setStoriesCount(PROGRESS_COUNT);
        storiesProgressView.setStoryDuration(3000L);
        storiesProgressView.setStoriesListener(this);
        counter = 0;
        storiesProgressView.startStories(counter);
        image = (ImageView) view.findViewById(R.id.image);
        Glide.with(mContext).load(resources[counter]).into(image);
        close = view.findViewById(R.id.close_image);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onComplete();
            }
        });
        // bind reverse view
        View reverse =view. findViewById(R.id.reverse);
        reverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storiesProgressView.reverse();
            }
        });
        reverse.setOnTouchListener(onTouchListener);

        // bind skip view
        View skip =view. findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storiesProgressView.skip();
            }
        });
        skip.setOnTouchListener(onTouchListener);

    }

    private View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    pressTime = System.currentTimeMillis();
                    storiesProgressView.pause();
                    return false;
                case MotionEvent.ACTION_UP:
                    long now = System.currentTimeMillis();
                    storiesProgressView.resume();
                    return limit < now - pressTime;
            }
            return false;
        }
    };
    @Override
    public void onNext() {
        Glide.with(mContext).load(resources[++counter]).into(image);

    }

    @Override
    public void onPrev() {
        if ((counter - 1) < 0) return;
        Glide.with(mContext).load(resources[--counter]).into(image);
    }

    @Override
    public void onComplete() {
        getActivity().finish();
    }

    @Override
    public void onDestroy() {
        // Very important !
        storiesProgressView.destroy();
        super.onDestroy();
    }


    @Override
    public void onResume() {
        super.onResume();
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
