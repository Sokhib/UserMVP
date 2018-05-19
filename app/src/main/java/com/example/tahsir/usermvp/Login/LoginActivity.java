package com.example.tahsir.usermvp.Login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.tahsir.usermvp.R;
import com.example.tahsir.usermvp.utils.ActivityUtils;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        if (loginFragment == null) {
            loginFragment = LoginFragment.newInstance();
            ActivityUtils.AddFragmentToActivity(getSupportFragmentManager(), loginFragment, R.id.contentFrame);
        }
        new LoginPresenter(loginFragment);

    }
}
