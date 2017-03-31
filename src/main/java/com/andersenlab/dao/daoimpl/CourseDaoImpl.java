package com.andersenlab.dao.daoimpl;

import com.andersenlab.dao.CourseDao;
import com.andersenlab.entities.Course;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Grindevalt on 31.03.2017.
 */
@Repository
public class CourseDaoImpl implements CourseDao {

    @Autowired
    private SessionFactory session;

    @Override
    public void addCourse(Course course) {
        session.getCurrentSession().save(course);
    }

    @Override
    public void editCourse(Course course) {
        session.getCurrentSession().update(course);
    }

    @Override
    public void deleteCourse(long courseId) {
        session.getCurrentSession().delete(getCourse(courseId));
    }

    @Override
    public Course getCourse(long courseId) {
        return (Course) session.getCurrentSession().get(Course.class, courseId);
    }

    @Override
    public List getAllCourses() {
        return session.getCurrentSession().createQuery("from com.andersenlab.entities.Course").list();
    }
}
