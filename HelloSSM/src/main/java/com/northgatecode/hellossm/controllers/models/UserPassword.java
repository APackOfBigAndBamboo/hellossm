package com.northgatecode.hellossm.controllers.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by user on 2016/12/14.
 */
public class UserPassword {
    @NotEmpty(message = "请输入原密码")
    private String oldPassword;
    @NotEmpty(message = "请输入新密码")
    @Size (min = 4, max = 12 , message = "密码长度不得少于4位")
    private  String newPassword;
    @NotEmpty(message = "请确认新密码")
    private  String  confirmPassword;



    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
