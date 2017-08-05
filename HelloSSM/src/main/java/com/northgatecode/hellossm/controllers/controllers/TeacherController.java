package com.northgatecode.hellossm.controllers.controllers;

import com.northgatecode.hellossm.controllers.mappers.GenderMapper;
import com.northgatecode.hellossm.controllers.mappers.TeacherMapper;
import com.northgatecode.hellossm.controllers.models.Student;
import com.northgatecode.hellossm.controllers.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by user on 2016/11/26.
 */
@Controller
@RequestMapping(value = "teachers")
public class TeacherController {
    @Autowired
    private GenderMapper genderMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String getList(Model model) {
        List<Teacher> teachers = teacherMapper.getAll();
        model.addAttribute("teachers", teachers);
        return "teachers/list";
    }
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String getupdate(ModelMap model,
                            @RequestParam String mode,
                            @RequestParam(required = false) Integer id) {
        model.addAttribute("mode", mode);
        Teacher teacher = null;
        if (mode.equals("create")) {
            teacher = new Teacher();
        } else if (mode.equals("update")) {
            teacher = teacherMapper.getteacherById(id);
        }
        model.addAttribute("teacher", teacher);
        model.addAttribute("genders", genderMapper.getGenderAll());
        return "teachers/update";
    }
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String addupdate(ModelMap model,
                            @RequestParam String mode,
                            @RequestParam String action,
                            @Valid Teacher teacher, BindingResult bindingResult) {
        model.addAttribute("mode", mode);
        if (action.equals("delete")) {

            teacherMapper.delete(teacher.getId());
            model.clear();
            return "redirect:/teachers/list";
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("student");
            model.addAttribute("genders", genderMapper.getGenderAll());
            return "teachers/update";
        }
        if (mode.equals("create")) {
            teacherMapper.insert(teacher);
        } else if (mode.equals("update")) {
            teacherMapper.update(teacher);
        }
        model.clear();

        return "redirect:/teachers/list";
    }
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String getdeleate(ModelMap model,

                             @RequestParam int id) {

        teacherMapper.delete(id);

        return "redirect:/teachers/list";
    }
}
