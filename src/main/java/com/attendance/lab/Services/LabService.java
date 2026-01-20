package com.attendance.lab.Services;

import com.attendance.lab.io.LabIo;

public interface LabService {
    LabIo addLab(LabIo dto);

    LabIo getLab(Long id);
}
