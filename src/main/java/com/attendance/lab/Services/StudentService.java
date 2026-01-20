package com.attendance.lab.Services;

import java.util.List;

import com.attendance.lab.io.StudentIo;

public interface StudentService {
    StudentIo addStudent(StudentIo dto);

    void deleteStudent(Long rollNumber);

    List<StudentIo> getStudentsByLab(Long labId);
}
