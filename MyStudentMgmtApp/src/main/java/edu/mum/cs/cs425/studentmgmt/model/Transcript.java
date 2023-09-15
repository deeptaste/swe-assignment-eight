package edu.mum.cs.cs425.studentmgmt.model;

import jakarta.persistence.*;

@Entity
public class Transcript {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transcriptId;

    @Column(nullable = false, unique = true)
    private String degreeTitle;

    public Transcript() {
        this.degreeTitle = "";
    }

    public Transcript(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    public long getTranscriptId() {
        return transcriptId;
    }

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    @Override
    public String toString() {
        return "{" +
                "\n\t" + " transcriptId : " + transcriptId +
                "\n\t" + " degreeTitle : '" + degreeTitle + '\'' +
                "\n" + "}";
    }
}
