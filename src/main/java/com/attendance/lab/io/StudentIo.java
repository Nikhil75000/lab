package com.attendance.lab.io;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentIo {
    private Long rollNumber;
    private String studentName;
    private Integer pcNumber;
    private Long labId;
}
