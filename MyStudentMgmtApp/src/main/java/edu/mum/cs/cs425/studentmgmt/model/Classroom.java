package edu.mum.cs.cs425.studentmgmt.model;

import edu.mum.cs.cs425.studentmgmt.Helper;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long classroomId;

    @Column(nullable = false, unique = true)
    private String buildingName;

    @Column(nullable = false)
    private String roomNumber;

    public Classroom() {
        this.buildingName = "";
        this.roomNumber = "";
    }

    public Classroom(String buildingName, String roomNumber) {
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
    }

    public long getClassroomId() {
        return classroomId;
    }

    public String getBuildingName() {
        return buildingName;
    }
    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "{" +
                "\n\t" + " classroomId : " + classroomId +
                "\n\t" + " buildingName : '" + buildingName + '\'' +
                "\n\t" + " roomNumber : '" + roomNumber + '\'' +
                "\n" + "}";
    }
}
