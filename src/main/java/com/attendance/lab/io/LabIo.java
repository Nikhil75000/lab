package com.attendance.lab.io;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LabIo {
    private Long id;
    private String labName;
    private Integer labNumber;
    private String labCode;
    private String inchargeName;
    private Long teacherId;
}
