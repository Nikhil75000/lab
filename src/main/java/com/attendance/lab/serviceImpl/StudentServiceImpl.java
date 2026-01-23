package com.attendance.lab.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.lab.Repository.LabRepository;
import com.attendance.lab.Repository.StudentRepository;
import com.attendance.lab.Services.StudentService;
import com.attendance.lab.entity.Lab;
import com.attendance.lab.entity.Student;
import com.attendance.lab.io.StudentIo;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private LabRepository labRepo;

    @Override
    public StudentIo addStudent(StudentIo dto) {
        Lab lab = labRepo.findById(dto.getLabId())
                .orElseThrow(() -> new RuntimeException("Lab not found"));

        Student s = new Student();
        s.setRollNumber(dto.getRollNumber());
        s.setStudentName(dto.getStudentName());
        s.setPcNumber(dto.getPcNumber());
        s.setLab(lab);

        studentRepo.save(s);
        return dto;
    }

    @Override
    public void removeStudent(Long rollNumber) {
        studentRepo.deleteById(rollNumber);
    }

    @Override
    public List<StudentIo> getByLab(Long labId) {
        return studentRepo.findByLabId(labId)
                .stream()
                .map(s -> {
                    StudentIo dto = new StudentIo();
                    dto.setRollNumber(s.getRollNumber());
                    dto.setStudentName(s.getStudentName());
                    dto.setPcNumber(s.getPcNumber());
                    dto.setLabId(labId);
                    return dto;
                })
                .toList();
    }
}
