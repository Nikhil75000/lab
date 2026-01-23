package com.attendance.lab.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendance.lab.Repository.AttendanceRepository;
import com.attendance.lab.Repository.LabRepository;
import com.attendance.lab.Repository.StudentRepository;
import com.attendance.lab.Services.AttendanceService;
import com.attendance.lab.entity.Attendance;
import com.attendance.lab.entity.Lab;
import com.attendance.lab.entity.Student;
import com.attendance.lab.io.AttendanceIo;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepo;

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private LabRepository labRepo;

    @Override
    public AttendanceIo markAttendance(AttendanceIo dto) {
        Student s = studentRepo.findById(dto.getRollNumber())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Lab lab = labRepo.findById(dto.getLabId())
                .orElseThrow(() -> new RuntimeException("Lab not found"));

        Attendance a = new Attendance();
        a.setStudent(s);
        a.setLab(lab);
        a.setDate(LocalDate.parse(dto.getDate()));
        a.setStatus(dto.getStatus());

        attendanceRepo.save(a);
        return dto;
    }

    @Override
    public List<AttendanceIo> getByLabAndDate(Long labId, String date) {
        return attendanceRepo
                .findByLabIdAndDate(labId, LocalDate.parse(date))
                .stream()
                .map(a -> {
                    AttendanceIo dto = new AttendanceIo();
                    dto.setId(a.getId());
                    dto.setRollNumber(a.getStudent().getRollNumber());
                    dto.setLabId(labId);
                    dto.setDate(a.getDate().toString());
                    dto.setStatus(a.getStatus());
                    return dto;
                })
                .toList();
    }

    @Override
    public List<AttendanceIo> getByStudent(Long rollNumber) {
        return attendanceRepo.findByStudentRollNumber(rollNumber)
                .stream()
                .map(a -> {
                    AttendanceIo dto = new AttendanceIo();
                    dto.setId(a.getId());
                    dto.setRollNumber(rollNumber);
                    dto.setLabId(a.getLab().getId());
                    dto.setDate(a.getDate().toString());
                    dto.setStatus(a.getStatus());
                    return dto;
                })
                .toList();
    }
}
