package com.hipposocial.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hipposocial.app.fragment.Fr_CreatePost;
import com.hipposocial.app.fragment.Fr_Main;
import com.hipposocial.app.fragment.Fr_Notification;
import com.hipposocial.app.fragment.Fr_Profile;
import com.hipposocial.app.fragment.Fr_Search;
import com.hipposocial.app.utility.CustomBottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    TextView tilte_tb;
    ImageButton massinger, camera;
    FloatingActionButton newPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tilte_tb = findViewById(R.id.txt_title);
        massinger = findViewById(R.id.massinger);
        camera = findViewById(R.id.camera);
        CustomBottomNavigationView bottomNavigation = findViewById(R.id.customBottomBar);
        bottomNavigation.inflateMenu(R.menu.navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(this);
        setFragment(new Fr_Main());
        tilte_tb.setText("Feeds");

        newPost = findViewById(R.id.add_button);

        massinger.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("fr", 0);
            startActivity(intent);
        });
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("fr", 1);
                startActivity(intent);
            }
        });

        newPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNewPostDialog();
            }
        });

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navigation_home:
                setFragment(new Fr_Main());
                tilte_tb.setText("Feeds");
                break;
            case R.id.navigation_search:
                setFragment(new Fr_Search());
                tilte_tb.setText("Search");
                break;

            case R.id.navigation_notification:
                setFragment(new Fr_Notification());
                tilte_tb.setText("Notification");
                break;

            case R.id.navigation_profile:
                setFragment(new Fr_Profile());
                tilte_tb.setText("Profile");
                break;
            default:
                return false;
        }

        return true;

    }

    public void setFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main_frame, fragment);
        ft.commit();
    }


    private void showNewPostDialog() {
        FragmentManager fm = getSupportFragmentManager();
        Fr_CreatePost fr_createPost = new Fr_CreatePost();
        fr_createPost.show(fm, "Fr_CreatePost");

    }


}
