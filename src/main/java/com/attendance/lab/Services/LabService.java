package com.attendance.lab.Services;

import java.util.List;

import com.attendance.lab.io.LabIo;

public interface LabService {
    LabIo createLab(LabIo dto);

    List<LabIo> getAllLabs();
}
