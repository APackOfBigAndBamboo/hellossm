package com.northgatecode.hellossm.controllers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by user on 2016/12/7.
 */@Controller
public class HomeController {
    @RequestMapping(value = "/login" ,method = RequestMethod.GET)
    public String getlogin(){
        return "home/login";
    }


}
