package com.attendance.lab.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.lab.Repository.LabRepository;
import com.attendance.lab.Repository.TeacherRepository;
import com.attendance.lab.Services.TeacherService;
import com.attendance.lab.entity.Lab;
import com.attendance.lab.entity.Teacher;
import com.attendance.lab.io.TeacherIo;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepo;
    @Autowired
    private LabRepository labRepo;

    @Override
    public TeacherIo addTeacher(TeacherIo dto) {
        Lab lab = labRepo.findById(dto.getLabId()).orElseThrow();

        Teacher t = new Teacher();
        t.setId(dto.getId());
        t.setTeacherName(dto.getTeacherName());
        t.setLab(lab);

        Teacher saved = teacherRepo.save(t);

        dto.setId(saved.getId());
        return dto;
    }

    @Override
    public TeacherIo getTeacher(Long id) {
        Teacher t = teacherRepo.findById(id).orElseThrow();
        TeacherIo dto = new TeacherIo();
        dto.setId(t.getId());
        dto.setTeacherName(t.getTeacherName());
        dto.setLabId(t.getLab().getId());
        return dto;
    }
}
