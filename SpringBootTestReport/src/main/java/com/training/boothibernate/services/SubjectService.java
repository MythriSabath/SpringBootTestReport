package com.training.boothibernate.services;
import java.util.List;
import com.training.boothibernate.entity.Subject;

public interface SubjectService {
	List<Subject> getAll();
	Subject get(Long id);
	boolean add(Subject subject);
	boolean edit(Subject subject);
	boolean delete(Long id);
	List<Subject> findSubjectByDuration(int duration); 
}
