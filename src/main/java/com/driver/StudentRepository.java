package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentMap;
    HashMap<String,Teacher> teacherMap;
    HashMap<String, List<String>> studentTeacherPair;
    StudentRepository(){
        studentMap = new HashMap<>();
        teacherMap = new HashMap<>();
        studentTeacherPair = new HashMap<>();
    }
    public void addStudent(String sname,Student student){
        studentMap.put(sname,student);
    }
    public void addTeacher(String tname,Teacher teacher){
        studentTeacherPair.put(tname,new ArrayList<>());
        teacherMap.put(tname,teacher);
    }
    public void addStudentTeacherPair(String student,String teacher){
//        List<String> studList = new ArrayList<>();
//        if(studentTeacherPair.containsKey(teacher)) studList = studentTeacherPair.get(teacher);
//        studList.add(student);
        Teacher teach = teacherMap.get(teacher);
        teach.setNumberOfStudents(teach.getNumberOfStudents()+1);
        studentTeacherPair.get(teacher).add(student);
    }
    public Student getStudentByName(String name){
        return studentMap.get(name);
    }
    public Teacher getTeacherByName(String name){
        return teacherMap.get(name);
    }
    public List<String> getStudentByTeacher(String teacher){
        return studentTeacherPair.get(teacher);
    }
    public List<String> getAllStudents(){
        List<String> students = new ArrayList<>();
        for(String s : studentMap.keySet()){
            students.add(s);
        }
        return students;
    }
    public void deleteTeacher(String teacher){
        List<String> stud = studentTeacherPair.get(teacher);
        for(String sName : stud){
            studentTeacherPair.remove(sName);
        }
        teacherMap.remove(teacher);
        studentTeacherPair.remove(teacher);
    }
    public void deleteAllTeachers(){
        for(String tName : studentTeacherPair.keySet()){
            deleteTeacher(tName);
        }
    }
}
