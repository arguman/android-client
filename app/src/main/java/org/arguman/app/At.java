package org.arguman.app;

import android.app.Application;

import org.arguman.app.controller.UserController;

public class At extends Application {

    // TODO: Add flags and initializers.
    public UserController userController;

    public At() {
        userController = new UserController();
    }

}
