package org.launchcode.WhatsSup.models;

public class RegisterFormDTO extends org.launchcode.WhatsSup.models.LoginFormDTO {

    private String verifyPassword;

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

}
