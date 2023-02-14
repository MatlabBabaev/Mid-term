package com.midtermtest.demo.service;

import com.midtermtest.demo.dto.CourseRequestDto;
import com.midtermtest.demo.entity.Course;
import com.midtermtest.demo.exception.CourseException;
import com.midtermtest.demo.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{
    private final CourseRepository repository;
    @Override
    public List<Course> getCourses() {
        return repository.findAll();
    }
    @Override
    public List<Course> getCoursesByAuthor(String author){
        return repository.findAllByAuthor(author).get();
    }
    @Override
    public Course getCourseByCourseName(String course) {
        return repository.findCourseByCourseName(course).get();
    }

    @Override
    public List<Course> getCoursesByCourseNameContaining(String course) {
        return repository.findAllByCourseNameContaining(course).get();
    }

    @Override
    public Course createCourse(CourseRequestDto dto) {

        Optional<Course> courseByCourseName = repository.findCourseByCourseName(dto.getCourseName());

        if(courseByCourseName.isPresent()){
            throw new CourseException("Course already exist");
        }
        Course course = Course.builder()
                .courseName(dto.getCourseName())
                .author(dto.getAuthor())
                .duration(dto.getDuration())
                .availability(dto.isAvailability())
                .build();
        return repository.save(course);
    }

    @Override
    public String deleteCourse(int id) {

        Optional<Course> byId = repository.findById(id);
        if(byId.isEmpty()){
            throw new CourseException("Course do not exist");
        }
        repository.delete(byId.get());
        return null;
    }
}
