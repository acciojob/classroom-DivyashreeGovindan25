package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository sp;
    public void addStudent(Student student){
        sp.addStudent(student.getName(),student);
    }
    public void addTeacher(Teacher teacher){
        sp.addTeacher(teacher.getName(),teacher);
    }
    public void addStudentTeacherPair(String student,String teacher){
//        Teacher teach = sp.getTeacherByName(teacher);
//        teach.setNumberOfStudents(1);
        sp.addStudentTeacherPair(student,teacher);
    }
    public Student getStudentByName(String name){
        Student student = null; // Assign student by calling service layer method
        student = sp.getStudentByName(name);
        return student;
    }
    public Teacher getTeacherByName(String name){
        Teacher teacher = sp.getTeacherByName(name); // Assign student by calling service layer method
        return teacher;
    }
    public List<String> getStudentByTeacher(String teacher){
        return sp.getStudentByTeacher(teacher);
    }
    public List<String> getAllStudents(){
        return sp.getAllStudents();
    }
    public void deleteTeacher(String teacher){
        sp.deleteTeacher(teacher);
    }
    public void deleteAllTeachers(){
        sp.deleteAllTeachers();
    }
}
