package com.attendance.lab.io;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherIo {
    private Long id;
    private String teacherName;
    private Long labId;

}
