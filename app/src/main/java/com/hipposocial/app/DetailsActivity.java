package com.hipposocial.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.hipposocial.app.fragment.Fr_Camera;
import com.hipposocial.app.fragment.Fr_Chats;
import com.hipposocial.app.fragment.Fr_Messenger;
import com.hipposocial.app.fragment.Fr_ProfileView;
import com.hipposocial.app.fragment.Fr_Stories;
import com.hipposocial.app.fragment.Fr_follow;

public class DetailsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    TextView tilte_tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        tilte_tb = findViewById(R.id.txt_title);

        toolbar = findViewById(R.id.Details_Toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> finish());


        switch (getIntent().getIntExtra("fr", 0)) {
            case 0:
                setFragment(new Fr_Chats());
                tilte_tb.setText("Chat");
                break;
            case 1:
                setFragment(new Fr_Camera());
                toolbar.setVisibility(View.GONE);
                tilte_tb.setVisibility(View.GONE);
                break;
            case 2:
                setFragment(new Fr_Stories());
                toolbar.setVisibility(View.GONE);
                tilte_tb.setVisibility(View.GONE);
                break;
            case 3:
                setFragment(new Fr_ProfileView());
                break;
            case 4:
                setFragment(new Fr_Messenger());
                break;
            case 5:
                setFragment(new Fr_follow());
                tilte_tb.setText("followers");
                break;
            case 6:
                setFragment(new Fr_follow());
                tilte_tb.setText("following");
                break;
        }
    }

    public void setFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.Details_frame, fragment);
        ft.commit();
    }

}
