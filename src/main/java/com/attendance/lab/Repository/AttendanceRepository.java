package com.attendance.lab.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attendance.lab.entity.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findByLabId(Long labId);

    List<Attendance> findByStudentRollNumber(Long rollNumber);

    List<Attendance> findByDate(LocalDate date);

    List<Attendance> findByLabIdAndDate(Long labId, LocalDate date);
}
