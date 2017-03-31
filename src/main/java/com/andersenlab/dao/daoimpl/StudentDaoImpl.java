package com.andersenlab.dao.daoimpl;

import com.andersenlab.dao.StudentDao;
import com.andersenlab.entities.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Grindevalt on 31.03.2017.
 */
@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory session;

    @Override
    public void addStudent(Student student) {
        session.getCurrentSession().save(student);
    }

    @Override
    public void editStudent(Student student) {
        session.getCurrentSession().update(student);
    }

    @Override
    public void deleteStudent(long studentId) {
        session.getCurrentSession().delete(getStudent(studentId));
    }

    @Override
    public Student getStudent(long studentId) {
        return (Student) session.getCurrentSession().get(Student.class, studentId);
    }

    @Override
    public List getAllStudents() {
        return session.getCurrentSession().createQuery("from com.andersenlab.entities.Student").list();
    }
}
