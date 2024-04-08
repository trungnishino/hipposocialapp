package com.hipposocial.app.adapter.holder;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hipposocial.app.R;
import com.hipposocial.app.model.Post;

public class ViewHolderVideo extends RecyclerView.ViewHolder {

    VideoView videoView;
    public ImageView like;

    public ViewHolderVideo(@NonNull View itemView) {
        super(itemView);
        videoView = itemView.findViewById(R.id.post_vv);
        like = itemView.findViewById(R.id.like);
    }

    public void setData(Post post, final Context mContext) {
        videoView.setVideoURI(Uri.parse(post.getTilte()));
        final MediaController controller = new MediaController(mContext);
        controller.setMediaPlayer(videoView);
        videoView.setMediaController(controller);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.seekTo(2000);
            }
        });
        videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (controller.isShowing()) {
                    controller.setVisibility(View.GONE);
                } else {
                    controller.setVisibility(View.VISIBLE);
                }
            }
        });


        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.BOTTOM;
        controller.setLayoutParams(lp);
        ((ViewGroup) controller.getParent()).removeView(controller);
        ((FrameLayout) itemView.findViewById(R.id.controllerAnchor)).addView(controller);
    }


}
