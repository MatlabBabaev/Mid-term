package com.midtermtest.demo.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseRequestDto {


    @NotBlank(message = "name can not be empty")
    private String courseName;
    @NotBlank(message = "name can not be empty")
    private String author;

    @Min(value = 20, message = "duration cannot be less than 20")
    private int duration;

    @NotEmpty
    private boolean availability;
}
