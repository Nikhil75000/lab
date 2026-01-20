package com.attendance.lab.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendance.lab.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByLabId(Long labId);
}
