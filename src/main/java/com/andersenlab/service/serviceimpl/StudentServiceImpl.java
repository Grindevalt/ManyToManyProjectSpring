package com.andersenlab.service.serviceimpl;

import com.andersenlab.dao.StudentDao;
import com.andersenlab.entities.Student;
import com.andersenlab.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Grindevalt on 31.03.2017.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    @Transactional
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    @Transactional
    public void editStudent(Student student) {
        studentDao.editStudent(student);
    }

    @Override
    @Transactional
    public void deleteStudent(long studentId) {
        studentDao.deleteStudent(studentId);
    }

    @Override
    @Transactional
    public Student getStudent(long studentId) {
        return studentDao.getStudent(studentId);
    }

    @Override
    @Transactional
    public List getAllStudents() {
        return studentDao.getAllStudents();
    }
}
