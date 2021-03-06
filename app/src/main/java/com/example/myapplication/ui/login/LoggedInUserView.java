package com.example.myapplication.ui.login;

/**
 * Class exposing authenticated user details to the UI.
 */
class LoggedInUserView {

    private String token;
    private String displayName;
    //... other data fields that may be accessible to the UI

    LoggedInUserView(String displayName, String token) {
        this.displayName = displayName;
        this.token = token;
    }

    String getDisplayName() {
        return displayName;
    }
    String getToken(){return token; }

}
