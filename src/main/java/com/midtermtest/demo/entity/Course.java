package com.midtermtest.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@AllArgsConstructor
@Getter
@Builder
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue
    @Column
    private  int courseId;
    @Column
    private  String courseName;
    @Column
    private  String author;
    @Column
    private  int duration;
    @Column
    private  boolean availability;
}
