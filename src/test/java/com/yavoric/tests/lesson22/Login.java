package com.yavoric.tests.lesson22;

import com.yavoric.lesson18.manager.PropertyManager;


public class Login {
    private PropertyManager propertyManager = PropertyManager.getInstance();
    private String signIn = propertyManager.getProperty("automation.login.signIn");
    private String email = propertyManager.getProperty("automation.login.email");
    private String password= propertyManager.getProperty("automation.login.password");
    private String submitLogin = propertyManager.getProperty("automation.login.submitLogin");
    private String signOut= propertyManager.getProperty("automation.login.signOut");
    private String login = propertyManager.getProperty("automation.username");
    private String cPassword = propertyManager.getProperty("automation.password");

    public String getSignIn() {
        return signIn;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getSubmitLogin() {
        return submitLogin;
    }

    public String getSignOut() {
        return signOut;
    }

    public String getLogin() {
        return login;
    }

    public String getcPassword() {
        return cPassword;
    }
}

