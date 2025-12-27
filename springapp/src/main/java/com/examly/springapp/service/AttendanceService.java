package com.examly.springapp.service;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Attendance;
import com.examly.springapp.repository.AttendanceRepository;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    // Constructor Injection
    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    // Save attendance (check-in)
    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    // Get attendance by ID
    public Attendance getAttendanceById(long id) {
        return attendanceRepository.findById(id).orElse(null);
    }
}
