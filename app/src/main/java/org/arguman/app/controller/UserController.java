package org.arguman.app.controller;

import android.content.Context;

import org.arguman.app.util.ObjectCache;
import org.arguman.app.model.UserModel;

public class UserController {

    private static UserController userController;
    private Context context;
    private boolean loginState;
    private UserModel user;

    private UserController(Context context) {
        this.context = context;
    }

    public static UserController getInstance(Context context) {
        if (userController == null) {
            userController = new UserController(context);
        }
        return userController;
    }

    public void initializeSession() {
        ObjectCache objectCache = ObjectCache.getInstance(context);
        userController.user = objectCache.getObject(UserModel.KEY, UserModel.class);
        if (userController.user == null) {
            userController.loginState = false;
        } else {
            userController.loginState = true;
        }
    }

    public UserModel getUser() {
        return this.user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public boolean getLoginState() {
        return loginState;
    }

    public void setLoginState(boolean loginState) {
        this.loginState = loginState;
    }
}
