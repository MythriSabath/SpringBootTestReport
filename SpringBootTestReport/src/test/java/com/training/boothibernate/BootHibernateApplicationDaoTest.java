package com.training.boothibernate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.training.boothibernate.dao.BookRepository;
import com.training.boothibernate.dao.SubjectRepository;
import com.training.boothibernate.entity.Book;
import com.training.boothibernate.entity.Subject;
import org.junit.Assert;
import org.junit.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootHibernateApplicationDaoTest {
	
	@MockBean
	private BookRepository bookRepository;
	
	@MockBean
	private SubjectRepository subjectRepository;
	
	@Test
	public void testAddSubject() throws Exception {
		Subject subject = new Subject(123L, "English", 30);
		System.out.println(subjectRepository.save(subject));
	}
	
	@Test
	public void testEditSubject() throws Exception {
		Subject subject = new Subject(123L, "English", 40);
		System.out.println(subjectRepository.save(subject));
	}
	
	@Test
	public void testGetAllSubjects() throws Exception {
		System.out.println(subjectRepository.findAll());
	}
	
	@Test
	public void testDeleteSubject() throws Exception {
		subjectRepository.deleteById(123L);
	}
	
	@Test
	public void testFindSubjectByDuration() throws Exception {
		System.out.println(subjectRepository.findSubjectByDuration(40));
	}
	
	@Test
	public void testAddBook() throws Exception {
		Book book = new Book(147, "English Grammar", 300, 3, "2019-03-01", 123L);
		System.out.println(bookRepository.save(book));
	}
	
	@Test
	public void testEditBook() throws Exception {
		Book book = new Book(147, "English Grammar Republished", 300, 3, "2019-03-01", 123L);
		System.out.println(bookRepository.save(book));
	}
	
	@Test
	public void testGetAllBooks() throws Exception {
		System.out.println(bookRepository.findAll());
	}
	
	@Test
	public void testDeleteBook() throws Exception {
		bookRepository.deleteById(147);
	}
	
	@Test
	public void testFindBookByTitle() throws Exception {
		System.out.println(bookRepository.findBookByTitle("English Grammar"));
	}
	
}

