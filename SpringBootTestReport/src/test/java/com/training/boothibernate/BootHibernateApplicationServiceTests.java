package com.training.boothibernate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import com.training.boothibernate.dao.BookRepository;
import com.training.boothibernate.dao.SubjectRepository;
import com.training.boothibernate.entity.Book;
import com.training.boothibernate.entity.Subject;
import com.training.boothibernate.services.BookService;
import com.training.boothibernate.services.BookServiceImpl;
import com.training.boothibernate.services.SubjectService;
import com.training.boothibernate.services.SubjectServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootHibernateApplicationServiceTests {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private SubjectService subjectService;
	
	@TestConfiguration
    static class BootHibernateApplicationTestContextConfiguration {
  
        @Bean
        public BookService bookService() {
            return new BookServiceImpl();
        }
        
        @Bean
        public SubjectService subjectService() {
            return new SubjectServiceImpl();
        }
    }
	
	@MockBean
	private BookRepository bookRepository;
	
	@MockBean
	private SubjectRepository subjectRepository;
	
	@Test
	public void testAddSubject() throws Exception {
		Subject subject = new Subject(123L, "English", 30);
		System.out.println(subjectService.add(subject));
	}
	
	@Test
	public void testEditSubject() throws Exception {
		Subject subject = new Subject(123L, "English", 40);
		System.out.println(subjectService.edit(subject));
	}
	
	@Test
	public void testGetAllSubjects() throws Exception {
		System.out.println(subjectService.getAll());
	}
	
	@Test
	public void testDeleteSubject() throws Exception {
		System.out.println(subjectService.delete(123L));
	}
	
	@Test
	public void testFindSubjectByDuration() throws Exception {
		System.out.println(subjectService.findSubjectByDuration(40));
	}
	
	@Test
	public void testAddBook() throws Exception {
		Book book = new Book(147, "English Grammar", 300, 3, "2019-03-01", 123L);
		System.out.println(bookService.add(book));
	}
	
	@Test
	public void testEditBook() throws Exception {
		Book book = new Book(147, "English Grammar Republished", 300, 3, "2019-03-01", 123L);
		System.out.println(bookService.edit(book));
	}
	
	@Test
	public void testGetAllBooks() throws Exception {
		System.out.println(bookService.getAll());
	}
	
	@Test
	public void testDeleteBook() throws Exception {
		System.out.println(bookService.delete(147));
	}
	
	@Test
	public void testFindBookByTitle() throws Exception {
		System.out.println(bookService.findBookByTitle("English Grammar"));
	}
	
}

