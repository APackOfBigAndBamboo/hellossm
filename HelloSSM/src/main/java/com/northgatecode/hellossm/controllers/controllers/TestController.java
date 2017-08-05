package com.northgatecode.hellossm.controllers.controllers;

import com.northgatecode.hellossm.controllers.mappers.RoleMapper;
import com.northgatecode.hellossm.controllers.mappers.UserMapper;
import com.northgatecode.hellossm.controllers.models.Role;
import com.northgatecode.hellossm.controllers.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

/**
 * Created by user on 2016/11/12.
 */
@Controller
@RequestMapping(value = "test")

public class TestController {
    @Autowired
    private  UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    static final Logger logger = LoggerFactory.getLogger(TestController.class);
    @RequestMapping(value = "hello", method = RequestMethod.GET)


    public  String hello(){return "test/Hello";}

    @RequestMapping(value = "hello", method = RequestMethod.POST)

    public  String welcome(@RequestParam (required = false, defaultValue = "") String name, Model model){
        model.addAttribute("name" , name);
        return "test/welcome";
    }
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getUser(@PathVariable int id){
        User user = userMapper.getUserById(id);
        return user.toString();
    }
    @RequestMapping(value = "role/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getRole(@PathVariable int id){
        Role role = roleMapper.getRoleById(id);
        return role.getCode();
    }
    @RequestMapping(value = "md5", method = RequestMethod.GET)
    @ResponseBody
    public String getMD5(){

        return DigestUtils.md5DigestAsHex("1234".getBytes());
    }
    @RequestMapping(value = "log", method = RequestMethod.GET)
    @ResponseBody
    public String log() {
        logger.trace("trace log");
        logger.debug("debug log");
        logger.info("info log");
        logger.warn("warn log");
        logger.error("error log");
        return "log test";
    }


}
