package com.northgatecode.hellossm.controllers.models;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.userdetails.UserDetails;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
/**
 * Created by qianl on 12/5/2016.
 */
public class User {
    private int id;
    @NotNull
    @Size(min = 2, max = 5, message = "无效的姓名")
    private String name;
    @NotEmpty(message = "必须提供有效的手机号码")
    @Pattern(regexp = "(^$)|(^(((13[0-9])|(15[^4,\\D])|(18[0,3-9]))\\d{8})$)", message = "无效的手机号码")
    private String mobile;
    @NotEmpty(message = "必须提供有效的邮箱")
    @Email(message = "这是个邮箱吗？")
    private String email;
    private String password;
    private Integer genderId;
    private Boolean isEnabled;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date registerDate;
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isEnable=" + isEnabled +
                ", registerDate=" + registerDate +
                '}';
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getGenderId() {
        return genderId;
    }
    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }
    public Boolean getEnabled() {
        return isEnabled;
    }
    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }
    public Date getRegisterDate() {
        return registerDate;
    }
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}