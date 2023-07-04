package com.zn.portfolio.repositories;


import com.zn.portfolio.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository  extends JpaRepository<Course, Integer> {
}
