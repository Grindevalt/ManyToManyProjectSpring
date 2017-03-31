package com.andersenlab.service;

import com.andersenlab.entities.Course;

import java.util.List;

/**
 * Created by Grindevalt on 31.03.2017.
 */
public interface CourseService {
    public void addCourse(Course course);
    public void editCourse(Course course);
    public void deleteCourse(long courseId);
    public Course getCourse(long courseId);
    public List getAllCourses();
}
