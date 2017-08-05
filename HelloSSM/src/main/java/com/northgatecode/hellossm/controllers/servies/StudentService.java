package com.northgatecode.hellossm.controllers.servies;

import com.northgatecode.hellossm.controllers.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by user on 2016/11/13.
 */
@Service
public class StudentService {}
//    private static List<Student> students = new ArrayList<>();
//
//    static {
//        students.add(new Student(1, "tom", "1213213", "sdjfsdf"));
//        students.add(new Student(2, "jim", "321321", "sdfsdfsd"));
//        students.add(new Student(3, "tom", "652135456", "evdvsafsdf"));
//    }

//    public List<Student> getAll() {
//        return students;
//    }
//
//    public Student getById(int id) {
//        for (Student student : students) {
//            if (student.getId() == id) {
//                return student;
//            }
//        }
//        return null;
//    }
//
//    public void add(Student student) {
//        students.add(student);
//        student.setId(students.size());
//    }
//
//   public void remvove(int id) {
//
//        for (int i = 0; i < students.size(); i++) {
//            if (students.get(i).getId() == id) {
//                students.remove(i);
//                break;
//            }
//        }
//    }
//public void delete(int id){
//    Iterator<Student> iterator = students.iterator();
//    while (iterator.hasNext()){
//        Student student = iterator.next();
//        if (student.getId()==id){
//            iterator.remove();
//        }
//    }
//}
//    public void update(Student student) {
//        for (int i = 0; i < students.size(); i++) {
//            if (students.get(i).getId() == student.getId()) {
//                students.set(i, student);
//
//            }
//        }
//    }
//}
// Student  student=new Student();
//int id1=Integer.parseInt(id);
//for(int i=0;i<  students.size();i++){
//   if(students.get(i).getId()==id1){
//      student.setId(students.get(i).getId());
//      student.setName(students.get(i).getMobile());
//     student.setEmail(students.get(i).getEmail());
// }
//}
//return  student;

