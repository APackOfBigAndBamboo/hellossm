package com.northgatecode.hellossm.controllers.controllers;

import com.northgatecode.hellossm.controllers.mappers.GenderMapper;
import com.northgatecode.hellossm.controllers.mappers.StudentMapper;
import com.northgatecode.hellossm.controllers.models.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by user on 2016/11/13.
 */
@Controller
@RequestMapping(value = "Student")
public class StudentController {
//    @Autowired
//    private StudentService studentService;
    @Autowired
    private GenderMapper genderMapper;
 @Autowired
 private StudentMapper studentMapper;
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String getList(Model model,@RequestParam (required = false) String name,
                          @RequestParam (required = false)Integer genderId,
                          @RequestParam(required = false,defaultValue = "0")Integer offest) {
        int pageSize=4;
        List<Student> students =  studentMapper.getsearch(name , genderId , offest, pageSize);
        model.addAttribute("name",name);
        model.addAttribute("genderId",genderId);
        model.addAttribute("genders", genderMapper.getGenderAll());
        model.addAttribute("offest", offest);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("students", students);
        return "Student/list";
    }
//    @RequestMapping(value = "list", method = RequestMethod.POST)
//    public String postList(ModelMap model,@RequestParam String name ,@RequestParam Integer genderId) {
//        List<Student> students = studentMapper.getsearch(name , genderId);
//        model.addAttribute("name",name);
//        model.addAttribute("genderId",genderId);
//        model.addAttribute("genders", genderMapper.getGenderAll());
//        model.addAttribute("students", students);
//        return "Student/list";
//
//    }

//    @RequestMapping(value = "create", method = RequestMethod.GET)
//    public String getcreate(Model model) {
//        Student student = new Student();
//        model.addAttribute("student", student);
//        return "Student/create";
//    }
//
//    @RequestMapping(value = "create", method = RequestMethod.POST)
//    public String addcreate(ModelMap model,
//                            @Valid Student student, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("studnet");
//            return "Student/create";
//        }
//                               @RequestParam String name,
//                               @RequestParam String mobile,
//                               @RequestParam String email){
//        Student student = new Student();
//        student.setName(name);
//        student.setMobile(mobile);
//        student.setEmail(email);
//        studentService.add(student);
//
//
//        return "redirect:/Student/list";
//    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String getupdate(ModelMap model,
                            @RequestParam String mode,
                            @RequestParam(required = false) Integer id) {
        model.addAttribute("mode", mode);
        Student student = null;
        if (mode.equals("create")) {
            student = new Student();
        } else if (mode.equals("update")) {
            student = studentMapper.getStudentById(id);
        }
        model.addAttribute("student", student);
        model.addAttribute("genders", genderMapper.getGenderAll());
        return "Student/update";
//        Student student = studentService.getById(id);
//        model.addAttribute("student", student);


    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String addupdate(ModelMap model,
                            @RequestParam String mode,
                            @RequestParam String action,
                            @Valid Student student, BindingResult bindingResult) {
        model.addAttribute("mode", mode);
        if (action.equals("delete")){

            studentMapper.delete(student.getId());
            model.clear();
            return "redirect:/Student/list";
        }

        String email = student.getEmail();
        List<Student> students = studentMapper.getStudentsByEmail(email);

        if (mode.equals("create")){
            if (students.size()>0){
                bindingResult.rejectValue("email" , "code" , "此邮箱已使用");
            }
        }else if (mode.equals("update")){
            if ((students.size())>1){
                bindingResult.rejectValue("email" , "code" , "此邮箱已使用");
            }else if (students.size()==1){
                if (students.get(0).getId() != student.getId()){
                    bindingResult.rejectValue("email" , "code" , "此邮箱已使用");
                }
            }
        }


        if (bindingResult.hasErrors()) {
            model.addAttribute("student");
            model.addAttribute("genders", genderMapper.getGenderAll());
            return "Student/update";
        }
        if (mode.equals("create")) {
            studentMapper.insert(student);
        } else if (mode.equals("update")) {
            studentMapper.update(student);
        }
        model.clear();
        //studentService.update(student);
        return "redirect:/Student/list";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String getdeleate(ModelMap model,

                             @RequestParam int id) {
        //studentService.remvove(id);
        studentMapper.delete(id);
        //model.clear();
        return "redirect:/Student/list";
    }
}