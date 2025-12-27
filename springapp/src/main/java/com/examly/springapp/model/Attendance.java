package com.examly.springapp.model;

import java.sql.Date;


import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long attendanceId;
    private long memberId;
    private String date;
    private String checkInTime;
    private String checkoutTime;
    public Attendance(){

    }
    public Attendance(long attendanceId, long memberId, String date, String checkInTime, String checkoutTime) {
        this.attendanceId = attendanceId;
        this.memberId = memberId;
        this.date = date;
        this.checkInTime = checkInTime;
        this.checkoutTime = checkoutTime;
    }



    public long getAttendanceId() {
        return attendanceId;
    }



    public void setAttendanceId(long attendanceId) {
        this.attendanceId = attendanceId;
    }



    public long getMemberId() {
        return memberId;
    }



    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }



    public String getDate() {
        return date;
    }



    public void setDate(String date) {
        this.date = date;
    }



    public String getCheckInTime() {
        return checkInTime;
    }



    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }



    public String getCheckoutTime() {
        return checkoutTime;
    }



    public void setCheckoutTime(String checkoutTime) {
        this.checkoutTime = checkoutTime;
    }    
}
