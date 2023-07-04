package com.zn.portfolio.services;

import com.zn.portfolio.entities.Course;


import com.zn.portfolio.repositories.CourseRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public Course getCourse(String id) {
        return courseRepository.findById(Integer.valueOf(id))
                .orElseThrow(() ->  new RuntimeException());
    }

    public void createCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(Integer.valueOf(id));
    }
    //ToDo fix update
    public void updateCourse(String id, Course course) {
        course.setId(Long.valueOf(id));
        courseRepository.save(course);
    }
}
