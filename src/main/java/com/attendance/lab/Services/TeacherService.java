package com.attendance.lab.Services;

import com.attendance.lab.io.TeacherIo;

public interface TeacherService {
    TeacherIo addTeacher(TeacherIo dto);

    TeacherIo getTeacher(Long id);
}
