package com.attendance.lab.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.lab.Repository.LabRepository;
import com.attendance.lab.Services.LabService;
import com.attendance.lab.entity.Lab;
import com.attendance.lab.io.LabIo;

@Service
public class LabServiceImpl implements LabService {

    @Autowired
    private LabRepository labRepo;

    @Override
    public LabIo createLab(LabIo dto) {
        Lab lab = new Lab();
        lab.setLabName(dto.getLabName());
        lab.setLabNumber(dto.getLabNumber());
        lab.setLabCode(dto.getLabCode());
        lab.setInchargeName(dto.getInchargeName());
        labRepo.save(lab);
        return dto;
    }

    @Override
    public List<LabIo> getAllLabs() {
        return labRepo.findAll().stream().map(lab -> {
            LabIo dto = new LabIo();
            dto.setId(lab.getId());
            dto.setLabName(lab.getLabName());
            dto.setLabNumber(lab.getLabNumber());
            dto.setLabCode(lab.getLabCode());
            dto.setInchargeName(lab.getInchargeName());
            return dto;
        }).toList();
    }
}
