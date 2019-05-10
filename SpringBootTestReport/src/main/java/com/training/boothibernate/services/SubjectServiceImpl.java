package com.training.boothibernate.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.training.boothibernate.dao.SubjectRepository;
import com.training.boothibernate.entity.Subject;
import com.training.boothibernate.exceptions.SubjectNotFoundException;

@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public List<Subject> getAll() {
		return this.subjectRepository.findAll();
	}

	@Override
	public Subject get(Long id) {
		Optional<Subject> result= this.subjectRepository.findById(id);
	 	Subject subject = null;
	 	if(result.isPresent())
	 		subject=result.get();
	 	else
	 		throw new SubjectNotFoundException("Subject not found with id - " + id);
	 	return subject;
	}

	@Override
	public boolean add(Subject subject) {
		this.subjectRepository.save(subject);
		return true;
	}

	@Override
	public boolean edit(Subject subject) {
		this.subjectRepository.save(subject);
		return true;
	}

	@Override
	public boolean delete(Long id) {
		this.subjectRepository.deleteById(id);
		return true;
	}

	@Override
	public List<Subject> findSubjectByDuration(int duration) {
		return this.subjectRepository.findSubjectByDuration(duration);
	}
}
