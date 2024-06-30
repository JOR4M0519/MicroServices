package com.microservice.course.client;

import com.microservice.course.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="msvc-student", url = "http://localhost:8080/api/student/")
public interface StudentClient {
    @GetMapping("/search-by-course/{courseId}")
    List<StudentDTO> findAllByCourseId(@PathVariable Long courseId);
}
