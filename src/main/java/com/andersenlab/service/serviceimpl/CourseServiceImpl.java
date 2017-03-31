package com.andersenlab.service.serviceimpl;

import com.andersenlab.dao.CourseDao;
import com.andersenlab.entities.Course;
import com.andersenlab.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Grindevalt on 31.03.2017.
 */
@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseDao courseDao;

    @Override
    @Transactional
    public void addCourse(Course course) {
        courseDao.addCourse(course);
    }

    @Override
    @Transactional
    public void editCourse(Course course) {
        courseDao.editCourse(course);
    }

    @Override
    public void deleteCourse(long courseId) {
        courseDao.deleteCourse(courseId);
    }

    @Override
    public Course getCourse(long courseId) {
        return courseDao.getCourse(courseId);
    }

    @Override
    public List getAllCourses() {
        return courseDao.getAllCourses();
    }
}
