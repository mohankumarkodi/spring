package com.example.springstart.service;

import com.example.springstart.model.Student;
import com.example.springstart.repository.StudentRepository;
import com.example.springstart.repository.StudentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class StudentJpaService implements StudentRepository {
    @Autowired
    public StudentJpaRepository studentjparepository;

    @Override
    public ArrayList<Student> getstudents() {
        List<Student> studentslist = studentjparepository.findAll();
        ArrayList<Student> students = new ArrayList<Student>(studentslist);
        return students;

    }
    @Override
    public Student getStudentById(int studentId){
        try{
            Student student = studentjparepository.findById(studentId).get();
            return student;
        }
        catch (Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }
    @Override
    public Student updateStudent(int studentId,Student student){
        try{
            Student newStudent = studentjparepository.findById(studentId).get();
            if(student.getId() != 0){
                newStudent.setId(student.getId());
            }
            if(student.getName() !=null){
                newStudent.setName(student.getName());
            }if(student.getMarks() !=0){
                newStudent.setMarks(student.getMarks());
            }
            if(student.getGender() !=null){
                newStudent.setGender(student.getGender());
            }
            studentjparepository.save(newStudent);
            return newStudent;

        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Student addstudent(Student student){
        studentjparepository.save(student);
        return student;
    }

    @Override
    public String deletestudent(int studentId) {
        try{
            studentjparepository.deleteById(studentId);
            return "student deleted";
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
