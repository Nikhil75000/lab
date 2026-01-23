package com.attendance.lab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attendance.lab.entity.Lab;

@Repository
public interface LabRepository extends JpaRepository<Lab, Long> {
    Lab findByLabCode(String labCode);
}
