package com.training.boothibernate.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.training.boothibernate.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{
	@Query("select sub from Subject sub where sub.durationInHours = :duration")
    List<Subject> findSubjectByDuration(@Param("duration") int duration); 
}
