package com.example.tahsir.usermvp.Login;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;

public class LoginPresenter implements LoginContract.Presenter {

    private final LoginContract.View mloginView;

    public LoginPresenter(@NonNull LoginContract.View loginView) {
        mloginView = loginView;
        mloginView.setPresenter(this);
    }

    @Override
    public void validateCredentials(String userName, String password) {
        if(TextUtils.isEmpty(userName))
            mloginView.showUserNameError();
        else if (TextUtils.isEmpty(password))
            mloginView.showPasswordError();
        else if(userName.equals("admin") && password.equals("admin")){
            //delay 2 seconds to see progressBar
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mloginView.showSuccess();
                }
            }, 2000);
        }

        else mloginView.showAlert();
    }
}
