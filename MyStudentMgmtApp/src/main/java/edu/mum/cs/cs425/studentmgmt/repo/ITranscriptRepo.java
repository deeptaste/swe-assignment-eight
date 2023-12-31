package edu.mum.cs.cs425.studentmgmt.repo;

import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITranscriptRepo extends JpaRepository<Transcript, Long> {
    Transcript findByDegreeTitle(String degreeTitle);
}
