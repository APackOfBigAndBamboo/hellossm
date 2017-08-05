package com.northgatecode.hellossm.controllers.models;

/**
 * Created by user on 2016/12/19.
 */
public class Role {
    private  int id;
    private  String code;
    private  String name;
private  boolean checked;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
