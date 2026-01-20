package com.attendance.lab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendance.lab.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
