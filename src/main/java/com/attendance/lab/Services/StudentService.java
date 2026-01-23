package com.attendance.lab.Services;

import java.util.List;

import com.attendance.lab.io.StudentIo;

public interface StudentService {
    StudentIo addStudent(StudentIo dto);

    void removeStudent(Long rollNumber);

    List<StudentIo> getByLab(Long labId);
}
