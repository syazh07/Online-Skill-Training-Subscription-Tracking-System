package com.examly.springapp.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentId;
    private double amount;
    private Date date;
    @ManyToOne
    private Attendance subscription;
    public Payment() {
    }
    public Payment(double amount, Date date, Attendance subscription) {
        this.amount = amount;
        this.date = date;
        this.subscription = subscription;
    }
    public long getPaymentId() {
        return paymentId;
    }
    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Attendance getSubscription() {
        return subscription;
    }
    public void setSubscription(Attendance subscription) {
        this.subscription = subscription;
    }
    
}
