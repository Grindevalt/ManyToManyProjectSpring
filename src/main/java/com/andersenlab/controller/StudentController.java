package com.andersenlab.controller;

import com.andersenlab.entities.Student;
import com.andersenlab.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by Grindevalt on 31.03.2017.
 */
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/index")
    public String setupForm(Map<String,Object> map){
        Student student = new Student();
        map.put("student", student);
        map.put("studentList", studentService.getAllStudents());
        return "student";
    }

    @RequestMapping(value = "/student.do", method = RequestMethod.POST)
    public String doActions(@ModelAttribute Student student, BindingResult result, @RequestParam String action, Map<String, Object> map){
        Student studentResult = new Student();
        if (action.equals("add")){
            studentService.addStudent(student);
            studentResult = student;
        }
        if (action.equals("edit")){
            studentService.editStudent(student);
            studentResult = student;
        }
        if (action.equals("delete")){
            studentService.deleteStudent(student.getStudentId());
            studentResult = student;
        }
        if (action.equals("search")){
            Student searchedStudent = studentService.getStudent(student.getStudentId());
            studentResult = searchedStudent!=null ? searchedStudent : new Student();
        }
        map.put("student", studentResult);
        map.put("studentList", studentService.getAllStudents());
        return "student";    }

}
