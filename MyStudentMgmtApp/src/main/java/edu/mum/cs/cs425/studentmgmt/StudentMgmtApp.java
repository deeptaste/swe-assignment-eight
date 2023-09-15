package edu.mum.cs.cs425.studentmgmt;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.repo.IClassroomRepo;
import edu.mum.cs.cs425.studentmgmt.repo.IStudentRepo;
import edu.mum.cs.cs425.studentmgmt.repo.ITranscriptRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentMgmtApp {

    private final IStudentRepo studentRepo;
    private final ITranscriptRepo transcriptRepo;
    private final IClassroomRepo classroomRepo;

    @Autowired
    public StudentMgmtApp(IStudentRepo studentRepo, ITranscriptRepo transcriptRepo, IClassroomRepo classroomRepo) {
        this.studentRepo = studentRepo;
        this.transcriptRepo = transcriptRepo;
        this.classroomRepo = classroomRepo;
    }

    @Transactional
    public Student saveStudent(Student student) {
        if(student == null) {
            throw new RuntimeException("Student cannot be null");
        }

        if(student.getStudentId() == 0) {
            Student existingStudent = getStudentByStudentNumber(student.getStudentNumber());
            if(existingStudent != null) {
                throw new RuntimeException("Student with this student number already exists");
            }
        }

        return studentRepo.save(student);
    }

    public Classroom saveClassroom(Classroom classroom) {
        if(classroom == null) {
            throw new RuntimeException("Classroom cannot be null");
        }

        if(classroom.getClassroomId() == 0) {
            Classroom existingClassroom = getClassroomByBuildingNameAndRoomNumber(classroom.getBuildingName(), classroom.getRoomNumber());
            if(existingClassroom != null) {
                throw new RuntimeException("Classroom with this building name and room number already exists");
            }
        }

        return classroomRepo.save(classroom);
    }

    public Transcript saveTranscript(Transcript transcript) {
        if(transcript == null) {
            throw new RuntimeException("Transcript cannot be null");
        }

        if (transcript.getTranscriptId() == 0) {
            Transcript existingTranscript = getTranscriptByDegreeTitle(transcript.getDegreeTitle());
            if(existingTranscript != null) {
                throw new RuntimeException("Transcript with this degree title already exists");
            }
        }

        return transcriptRepo.save(transcript);
    }

    public Student getStudentByStudentNumber(String studentNumber) {
        return studentRepo.findByStudentNumber(studentNumber);
    }

    public Transcript getTranscriptByDegreeTitle(String degreeTitle) {
        return transcriptRepo.findByDegreeTitle(degreeTitle);
    }

    public Classroom getClassroomByBuildingNameAndRoomNumber(String buildingName, String roomNumber) {
        return classroomRepo.findByBuildingNameAndRoomNumber(buildingName, roomNumber);
    }
}
