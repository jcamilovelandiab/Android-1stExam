package com.example.myapplication.data;

import com.example.myapplication.data.model.Gender;
import com.example.myapplication.data.model.LoggedInUser;
import com.example.myapplication.data.model.Token;
import com.example.myapplication.data.model.User;
import com.example.myapplication.ui.login.LoginViewModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */
public class UserRepository {

    private static volatile UserRepository instance;

    private Map<String, User> users;

    // private constructor : singleton access
    private UserRepository() {
        users = new HashMap<String,User>();
        User userCamilo = new User("camilo@mail.com","camilo123", "camilo", "+571234567", "13/02/1999", Gender.MALE);
        users.put(userCamilo.getEmail(), userCamilo);
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public void login(final LoginViewModel loginViewModel, final String email, final String password) {
        Token token = null;
        if(users.containsKey(email) && users.get(email).getPassword().equals(password)){
            token = new Token("this is my token");
        }
        if(token == null){
            loginViewModel.requestLoginCompleted(false,null);
        }else{
            loginViewModel.requestLoginCompleted(true, new LoggedInUser(email, token));
        }
    }

    public LoggedInUser signup(final User u){
        Token token = null;
        if(!users.containsKey(u.getEmail())) {
            token = new Token("this is my token");
        }
        if(token==null){
            return null;
        }else{
            return new LoggedInUser(u.getEmail(),token);
        }

    }

}
