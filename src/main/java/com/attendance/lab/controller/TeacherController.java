package com.attendance.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.lab.Services.TeacherService;
import com.attendance.lab.io.TeacherIo;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService service;

    @PostMapping
    public TeacherIo add(@RequestBody TeacherIo dto) {
        return service.addTeacher(dto);
    }

    @GetMapping("/{id}")
    public TeacherIo get(@PathVariable Long id) {
        return service.getTeacher(id);
    }
}
