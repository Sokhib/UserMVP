package com.example.tahsir.usermvp.Login;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tahsir.usermvp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements LoginContract.View {


    public LoginFragment() {
    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    private EditText emailETxt, passwordETxt;
    private Button loginBtn;
    private LoginContract.Presenter mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        emailETxt = view.findViewById(R.id.editTextEmail);
        passwordETxt = view.findViewById(R.id.editTextPassword);
        loginBtn = view.findViewById(R.id.login_button);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.validateCredentials(emailETxt.getText().toString(), passwordETxt.getText().toString());
            }
        });

        return view;
    }

    @Override
    public void showUserNameError() {
        emailETxt.setError("Username or Email is empty");
    }

    @Override
    public void showPasswordError() {
        passwordETxt.setError("Password is empty");
    }

    @Override
    public void showSuccess() {
        Toast.makeText(getActivity(), "Successfully logged in", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showAlert() {
        Toast.makeText(getActivity(), "Invalid Credentials", Toast.LENGTH_LONG).show();
    }

    @Override
    public void setPresenter(@NonNull LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
