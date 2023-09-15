package edu.mum.cs.cs425.studentmgmt;
import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyStudentMgmtAppApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyStudentMgmtAppApplication.class, args);
        StudentMgmtApp studentMgmtApp = context.getBean(StudentMgmtApp.class);

        Transcript transcript = new Transcript();
        transcript.setDegreeTitle("BS Computer Science");

        Transcript savedTranscript = studentMgmtApp.saveTranscript(transcript);
        System.out.println("Saved Transcript: \n" + savedTranscript);

        // Create a Classroom
        Classroom classroom = new Classroom();
        classroom.setBuildingName("McLaughlin building");
        classroom.setRoomNumber("M105");

        Classroom savedClassroom = studentMgmtApp.saveClassroom(classroom);
        System.out.println("Saved Classroom: \n" + savedClassroom);

        Student s1 = new Student();
        s1.setStudentNumber("000-61-0001");
        s1.setFirstName("Anna");
        s1.setMiddleName("Lynn");
        s1.setLastName("Smith");
        s1.setCgpa(3.45);
        s1.setDateOfEnrollment(Helper.parseDate("2019/5/24"));

        Student savedStudent = studentMgmtApp.saveStudent(s1);
        System.out.println("Saved Student: \n" + savedStudent);

        Transcript transcript1 = studentMgmtApp.getTranscriptByDegreeTitle("BS Computer Science");
        if(transcript1 != null)
            s1.setTranscript(savedTranscript);

        Classroom classroom1 = studentMgmtApp.getClassroomByBuildingNameAndRoomNumber("McLaughlin building", "M105");
        if(classroom1 != null)
            s1.setClassroom(savedClassroom);

        savedStudent = studentMgmtApp.saveStudent(s1);
        System.out.println("Updated Student: \n" + savedStudent);
    }
}
