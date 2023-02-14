package com.midtermtest.demo.repository;

import com.midtermtest.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    Optional<List<Course>> findAllByAuthor(String author);

    Optional<Course> findCourseByCourseName (String course);

    Optional<List<Course>> findAllByCourseNameContaining (String course);
}
