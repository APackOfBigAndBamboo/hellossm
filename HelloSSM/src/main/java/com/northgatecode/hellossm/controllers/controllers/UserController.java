package com.northgatecode.hellossm.controllers.controllers;

import com.northgatecode.hellossm.controllers.mappers.GenderMapper;
import com.northgatecode.hellossm.controllers.mappers.RoleMapper;
import com.northgatecode.hellossm.controllers.mappers.UserMapper;
import com.northgatecode.hellossm.controllers.models.Role;
import com.northgatecode.hellossm.controllers.models.User;
import com.northgatecode.hellossm.controllers.models.UserPassword;
import com.northgatecode.hellossm.controllers.security.CustormUserDetail;
import com.northgatecode.hellossm.controllers.servies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 2016/12/6.
 */
@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GenderMapper genderMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String getlist(ModelMap model,
                          @RequestParam(required = false) String searchText,
                          @RequestParam(required = false, defaultValue = "0") int offset,
                          @RequestParam(required = false, defaultValue = "5") int limit) {
        List<User> users = userMapper.getUsersByCriteria(searchText, offset, limit);
        model.addAttribute("offset", offset);
        model.addAttribute("limit", limit);
        model.addAttribute("users", users);
        return "user/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String getCreate(ModelMap model,
                            @RequestParam(required = false) Integer id) {
        User user = new User();
        model.addAttribute("genders", genderMapper.getGenderAll());
        model.addAttribute("user", user);
        return "user/create";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String postCreate(ModelMap model,
                             @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("genders", genderMapper.getGenderAll());
            return "user/create";
        }
        String mobile = user.getMobile();
        User sameMobileUser = userMapper.getUserMobile(mobile);
        if (sameMobileUser != null) {
            bindingResult.rejectValue("mobile", "code", "此手机号码已使用");
            model.addAttribute("genders", genderMapper.getGenderAll());
            return "user/create";
        }
        userService.createUser(user);
        return "redirect:/user/edit?id=" + user.getId();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String getEdit(ModelMap model,
                          @RequestParam(required = false) Integer id) {
        User user = userMapper.getUserById(id);
        model.addAttribute("genders", genderMapper.getGenderAll());
        model.addAttribute("user", user);
        return "user/edit";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String postEdit(ModelMap model,
                           @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("genders", genderMapper.getGenderAll());
            return "user/edit";
        }
        String mobile = user.getMobile();
        User sameMobileUser = userMapper.getUserMobile(mobile);
        if (sameMobileUser != null && sameMobileUser.getId() != user.getId()) {
            bindingResult.rejectValue("mobile", "code", "此手机号码已使用");
            model.addAttribute("genders", genderMapper.getGenderAll());
            return "user/edit";
        }
        userMapper.updateUserBaseInfo(user);
        return "redirect:/user/edit?id=" + user.getId();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "password", method = RequestMethod.GET)
    public String getPassword(ModelMap model,
                              @RequestParam(required = false) Integer id) {
        User user = userMapper.getUserById(id);
        model.addAttribute("user", user);
        return "user/password";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "password", method = RequestMethod.POST)
    public String postPassword(ModelMap model,
                               @RequestParam int id) {
        User user = new User();
        user.setId(id);
        user.setPassword(DigestUtils.md5DigestAsHex("1234".getBytes()));
        userMapper.updateUserPassword(user);
        return "redirect:/user/password?id=" + user.getId();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "authority", method = RequestMethod.GET)
    public String getAuthority(ModelMap model,
                               @RequestParam(required = false) Integer id) {
        User user = userMapper.getUserById(id);
        model.addAttribute("user", user);
        List<Role> roles = roleMapper.getRolesAll();
        model.addAttribute("roles" , roles);
        List<Role> userRoles = roleMapper.getRolesByUserId(user.getId());
        for (Role role : roles) {
            role.setChecked(false);
            for (Role userRole : userRoles) {
                if (role.getId() == userRole.getId()) {
                    role.setChecked(true);
                    break;
                }
            }
        }

        return "user/authority";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "authority", method = RequestMethod.POST)
    @Transactional
    public String postAuthority(ModelMap model,
                                @RequestParam(required = false) Integer id,
                                @RequestParam(required = false, defaultValue = "") List<Integer> userRoleIds) {
        User user = userMapper.getUserById(id);
        model.addAttribute("user", user);
        roleMapper.deleteUserRolesByUserId(user.getId());
//        if (true){
//            throw  new  RuntimeException("哈哈");
//        }
        for (Integer userRoleId : userRoleIds) {
            roleMapper.insertUserRoleRoleByUserIdAndRoleId(user.getId(), userRoleId);
        }
        List<Role> roles = roleMapper.getRolesAll();
        model.addAttribute("roles", roles);

        List<Role> userRoles = roleMapper.getRolesByUserId(user.getId());
        for (Role role : roles) {
            role.setChecked(false);
            for (Role userRole : userRoles) {
                if (role.getId() == userRole.getId()) {
                    role.setChecked(true);
                    break;
                }
            }
        }

        return "user/authority";
    }

    @RequestMapping(value = "myProfile", method = RequestMethod.GET)
    public String getMyProfile(ModelMap model, Authentication authentication) {
        CustormUserDetail custormUserDetail = (CustormUserDetail) authentication.getPrincipal();

        int currentUserId = custormUserDetail.getUser().getId();
        User user = userMapper.getUserById(currentUserId);
        model.addAttribute("user", user);

        return "user/my-profile";
    }

    @RequestMapping(value = "myProfile", method = RequestMethod.POST)
    public String postupdate(ModelMap model,
                             @Valid User user, BindingResult bindingResult) {
        String mobile = user.getMobile();
        User sameMobileUser = userMapper.getUserMobile(mobile);
        if (sameMobileUser != null && sameMobileUser.getId() != user.getId()) {
            bindingResult.rejectValue("mobile", "code", "此手机号码已使用");
        }
        if (bindingResult.hasErrors()) {
            return "user/my-profile";
        }
        userMapper.updateUserBaseInfo(user);
        model.clear();
        return "redirect:/user/myProfile";
    }

    @RequestMapping(value = "myPassword", method = RequestMethod.GET)
    public String getMyPassword(ModelMap model) {
        UserPassword userPassword = new UserPassword();
        model.addAttribute("userPassword", userPassword);
        return "user/my-password";
    }

    @RequestMapping(value = "myPassword", method = RequestMethod.POST)
    public String postMyPassword(ModelMap model, Authentication authentication,
                                 @Valid UserPassword userPassword, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/my-password";
        }
        CustormUserDetail custormUserDetail = (CustormUserDetail) authentication.getPrincipal();
        User user = userMapper.getUserById(custormUserDetail.getUser().getId());

        String md5Pwd = DigestUtils.md5DigestAsHex(userPassword.getOldPassword().getBytes());
        if (!user.getPassword().equals(md5Pwd)) {
            bindingResult.rejectValue("oldPassword", "code", "原密码不正确");
            return "user/my-password";
        }
        if (!userPassword.getNewPassword().equals(userPassword.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", "code", "请确认新密码");
            return "user/my-password";
        }
        user.setPassword(DigestUtils.md5DigestAsHex(userPassword.getNewPassword().getBytes()));
        userMapper.updateUserPassword(user);

        model.addAttribute("success", "密码修改成功");

        return "user/my-password";
    }
}
