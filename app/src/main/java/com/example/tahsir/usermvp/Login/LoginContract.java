package com.example.tahsir.usermvp.Login;

import com.example.tahsir.usermvp.BasePresenter;
import com.example.tahsir.usermvp.BaseView;

public interface LoginContract {
    interface View extends BaseView<Presenter> {
        void showUserNameError();

        void showPasswordError();

        void showSuccess();

        void showAlert();
    }


    interface Presenter extends BasePresenter {

        void validateCredentials(String userName,String password);
    }
}
