package edu.mum.cs.cs425.studentmgmt.model;

import edu.mum.cs.cs425.studentmgmt.Helper;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;

    @Column(nullable = false, unique = true)
    private String studentNumber;

    @Column(nullable = false)
    private String firstName;
    private String middleName;

    @Column(nullable = false)
    private String lastName;
    private double cgpa;

    @Column(nullable = false)
    private Date dateOfEnrollment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transcript_id", referencedColumnName = "transcriptId")
    private Transcript transcript;

    @ManyToOne
    @JoinColumn(name = "classroom_id", referencedColumnName = "classroomId")
    private Classroom classroom;

    public Student() {
        this.studentNumber = "";
        this.firstName = "";
        this.middleName = "";
        this.lastName = "";
        this.cgpa = 0.0;
        this.dateOfEnrollment = new Date();
    }

    public Student(String studentNumber, String firstName, String middleName, String lastName, double cgpa, Date dateOfEnrollment) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public long getStudentId() {
        return studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getCgpa() {
        return cgpa;
    }
    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public Date getDateOfEnrollment() {
        return dateOfEnrollment;
    }
    public void setDateOfEnrollment(Date dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public Transcript getTranscript() {
        return transcript;
    }
    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    public Classroom getClassroom() {
        return classroom;
    }
    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "{" +
                "\n\t" + " studentId : " + studentId +
                "\n\t" + " studentNumber : '" + studentNumber + '\'' +
                "\n\t" + " firstName : '" + firstName + '\'' +
                "\n\t" + " middleName : '" + middleName + '\'' +
                "\n\t" + " lastName : '" + lastName + '\'' +
                "\n\t" + " cgpa : " + cgpa +
                "\n\t" + " dateOfEnrollment : " + Helper.getFormattedDate(dateOfEnrollment) +
                "\n\t" + " transcript : " + transcript +
                "\n\t" + " classroom : " + classroom +
                "\n" + "}";
    }

}
