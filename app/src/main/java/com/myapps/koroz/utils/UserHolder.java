package com.myapps.koroz.utils;

import com.myapps.koroz.service.model.User;

public class UserHolder {
    private static final UserHolder ourInstance = new UserHolder();
    private User user;

    static UserHolder getInstance() {
        return ourInstance;
    }

    private UserHolder() {
    }

    public static UserHolder getOurInstance() {
        return ourInstance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
