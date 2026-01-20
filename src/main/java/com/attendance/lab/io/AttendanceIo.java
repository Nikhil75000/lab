package com.attendance.lab.io;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceIo {
    private Long id;
    private Long rollNumber;
    private Long labId;
    private String date; // yyyy-MM-dd
    private String status;

}
