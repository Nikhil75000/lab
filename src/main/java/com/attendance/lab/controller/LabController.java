package com.attendance.lab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.lab.Services.LabService;
import com.attendance.lab.io.LabIo;

@RestController
@RequestMapping("/api/labs")
public class LabController {

    @Autowired
    private LabService service;

    @PostMapping
    public LabIo create(@RequestBody LabIo dto) {
        return service.createLab(dto);
    }

    @GetMapping
    public List<LabIo> all() {
        return service.getAllLabs();
    }
}
