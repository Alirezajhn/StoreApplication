package com.maktab74.util;

import com.maktab74.domain.User;

public class SecurityContext {
    private User currentUser = null;

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void logout() {
        this.currentUser = null;
    }
}


