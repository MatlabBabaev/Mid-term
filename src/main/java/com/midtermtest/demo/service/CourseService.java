package com.midtermtest.demo.service;

import com.midtermtest.demo.dto.CourseRequestDto;
import com.midtermtest.demo.entity.Course;
import com.midtermtest.demo.repository.CourseRepository;

import java.util.List;

public interface CourseService {

    public List<Course> getCourses();

    public List<Course> getCoursesByAuthor(String author);

    public Course getCourseByCourseName(String course);

    public List<Course> getCoursesByCourseNameContaining(String course);

    public Course createCourse(CourseRequestDto course);

    public String deleteCourse(int id);
}
