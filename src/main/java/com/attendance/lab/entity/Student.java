package com.attendance.lab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String studentName;
    @Id
    private Long rollNumber;
    private Integer pcNumber;
    @ManyToOne
    @JoinColumn(name = "lab_id")
    private Lab lab;

}
