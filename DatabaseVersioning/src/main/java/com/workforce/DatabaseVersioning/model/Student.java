package com.workforce.DatabaseVersioning.model;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "STUDENT_ID")
    private Long studentId;

    @Column(name = "STUDENT_NAME")
    private String studentName;

    @Column(name = "EMAIL_ID", unique = true)
    private String emailId;

    @Column(name="STUDENT_PH", unique = true)
    private String ph;

    public Student(String studentName, String emailId, String ph) {
        this.studentName = studentName;
        this.emailId = emailId;
        this.ph = ph;
    }

    public Student() {
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", ph='" + ph + '\'' +
                '}';
    }
}
