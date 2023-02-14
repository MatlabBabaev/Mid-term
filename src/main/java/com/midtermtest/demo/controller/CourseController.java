package com.midtermtest.demo.controller;

import com.midtermtest.demo.dto.CourseRequestDto;
import com.midtermtest.demo.entity.Course;
import com.midtermtest.demo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService service;

    @GetMapping()
    public ResponseEntity<List<Course>> getAllCourses(){
        return new ResponseEntity<>(service.getCourses(), HttpStatus.OK);
    }

    @GetMapping("/findbyauthor/{author}")
    public ResponseEntity<List<Course>> getCoursesByAuthor(@PathVariable String author){
        return new ResponseEntity<>(service.getCoursesByAuthor(author), HttpStatus.FOUND);
    }

    @GetMapping("/findbycoursename/{course}")
    public ResponseEntity<Course> getCoursesByCourseName(@PathVariable String course){
        return new ResponseEntity<>(service.getCourseByCourseName(course), HttpStatus.FOUND);
    }

    @PostMapping()
    public ResponseEntity<Course> createCourse(@RequestBody @Valid CourseRequestDto dto){
        Course course = service.createCourse(dto);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id){
        service.deleteCourse(id);
        return new ResponseEntity<>("Course deleted!", HttpStatus.OK);
    }
}
