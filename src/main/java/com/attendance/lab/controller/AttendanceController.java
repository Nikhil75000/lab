package com.attendance.lab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.lab.Services.AttendanceService;
import com.attendance.lab.io.AttendanceIo;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService service;

    @PostMapping
    public AttendanceIo mark(@RequestBody AttendanceIo dto) {
        return service.markAttendance(dto);
    }

    @GetMapping("/lab/{labId}/date/{date}")
    public List<AttendanceIo> byLabDate(
            @PathVariable Long labId,
            @PathVariable String date) {
        return service.getByLabAndDate(labId, date);
    }

    @GetMapping("/student/{rollNumber}")
    public List<AttendanceIo> byStudent(@PathVariable Long rollNumber) {
        return service.getByStudent(rollNumber);
    }
}
