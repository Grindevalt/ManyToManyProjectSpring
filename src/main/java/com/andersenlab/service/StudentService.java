package com.andersenlab.service;

import com.andersenlab.entities.Student;

import java.util.List;

/**
 * Created by Grindevalt on 31.03.2017.
 */
public interface StudentService {
    public void addStudent(Student student);
    public void editStudent(Student student);
    public void deleteStudent(long studentId);
    public Student getStudent(long studentId);
    public List getAllStudents();
}
