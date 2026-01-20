package com.attendance.lab.Services;

import java.util.List;

import com.attendance.lab.io.AttendanceIo;

public interface AttendanceService {
    AttendanceIo markAttendance(AttendanceIo dto);

    List<AttendanceIo> getByLabAndDate(Long labId, String date);

    List<AttendanceIo> getByStudent(Long rollNumber);
}
