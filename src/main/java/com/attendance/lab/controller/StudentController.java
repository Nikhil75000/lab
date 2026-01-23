package com.attendance.lab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.lab.Services.StudentService;
import com.attendance.lab.io.StudentIo;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public StudentIo add(@RequestBody StudentIo dto) {
        return service.addStudent(dto);
    }

    @DeleteMapping("/{rollNumber}")
    public void delete(@PathVariable Long rollNumber) {
        service.removeStudent(rollNumber);
    }

    @GetMapping("/lab/{labId}")
    public List<StudentIo> byLab(@PathVariable Long labId) {
        return service.getByLab(labId);
    }
}
