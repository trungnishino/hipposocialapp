package com.hipposocial.app.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.hipposocial.app.MainActivity;
import com.hipposocial.app.R;
import com.hipposocial.app.utility.PasswordTransformationMethod;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fr_SignUp extends Fragment {

    private Context mContext;



    public Fr_SignUp() {
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
        return inflater.inflate(R.layout.fr_sign_up, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText Password = view.findViewById(R.id.Password);
        Password .setTransformationMethod(new PasswordTransformationMethod());
        Button CreateAccount = view.findViewById(R.id.CreateAccount);
        CreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext , MainActivity.class);
                startActivity(intent);
            }
        });

    }

}
