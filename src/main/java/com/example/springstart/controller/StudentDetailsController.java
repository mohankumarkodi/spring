package com.example.springstart.controller;

import com.example.springstart.service.StudentJpaService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.springstart.model.Student;

import java.util.*;


@RestController
public class StudentDetailsController {
    @Autowired
    public StudentJpaService studentservice;


    @GetMapping("/students")
    public ArrayList<Student> getStudents(){
        return studentservice.getstudents();
    }
    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable("studentId")int studentId){
        return studentservice.getStudentById(studentId);
    }
    @PutMapping("/students/{studentId}")
    public Student updateStudent(@PathVariable("studentId") int studentId,@RequestBody Student student){
        return studentservice.updateStudent(studentId,student);
    }
    @PostMapping("/students")
    public Student addstudent(@RequestBody Student student){
        return studentservice.addstudent(student);
    }
    @DeleteMapping("/students/{studentId}")
     public String deleteStudent(@PathVariable("studentId") int studentId){
        return studentservice.deletestudent(studentId);
    }
}
