package com.attendance.lab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendance.lab.entity.Lab;

public interface LabRepository extends JpaRepository<Lab, Long> {
    Lab findByLabCode(String labCode);
}
