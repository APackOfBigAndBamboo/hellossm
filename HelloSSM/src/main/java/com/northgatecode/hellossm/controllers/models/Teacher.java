package com.northgatecode.hellossm.controllers.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by user on 2016/11/26.
 */
public class Teacher {
    private int id;
    @NotNull
    @Size(min = 2, max = 5, message = "无效的姓名")
    private String name;
    @NotEmpty(message = "手机号码不能为空")
    @Pattern(regexp = "(^$)|(^(((13[0-9])|(15[^4,\\D])|(18[0,3-9]))\\d{8})$)", message = ("请输入正确的手机格式"))
    private  String mobile;
    @NotEmpty(message = "必须提供有效的邮箱")
    @Email(message = "这是个邮箱吗？")
    private  String email;
    private Integer genderId;

    public Teacher() {
    }

    public Teacher(int id, String name, String mobile, String email) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGenderId() {
        return genderId;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }
}
