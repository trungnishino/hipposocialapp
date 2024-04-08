package com.hipposocial.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.hipposocial.app.fragment.Fr_Register;
import com.hipposocial.app.fragment.Fr_SignIn;
import com.hipposocial.app.fragment.Fr_SignUp;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setFragment(new Fr_Register());

    }

    public void setFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.login_fragment, fragment);
        ft.commit();
    }
}
