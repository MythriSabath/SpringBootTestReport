package com.training.boothibernate.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.training.boothibernate.entity.Book;
import com.training.boothibernate.entity.Subject;
import com.training.boothibernate.exceptions.BookNotFoundException;
import com.training.boothibernate.exceptions.CustomException;
import com.training.boothibernate.exceptions.SubjectNotFoundException;
import com.training.boothibernate.services.BookService;
import com.training.boothibernate.services.SubjectService;

@RestController
public class MyAppController {
	
	@Autowired
	SubjectService subjectService;
	
	@Autowired
	BookService bookService;

	@PostMapping("/addSubject")
	public Subject addSubject(@RequestBody Subject subject) {
		if(!this.subjectService.add(subject)) {
			throw new CustomException("Cannot add new Subject!!!");
		}
		return subject;
	}
	
	@PostMapping("/addBook")
	public Book addBook(@RequestBody Book book) {
		if(!this.bookService.add(book)) {
			throw new CustomException("Cannot add new Book!!!");
		}
		return book;
	}
	
	@GetMapping("/searchSubject/{subjectId}")
	public Subject searchSubject(@PathVariable("subjectId")Long subjectId) {
		Subject searchedSubject = subjectService.get(subjectId);
		if(searchedSubject==null) {
			throw new SubjectNotFoundException("Subject id not found - " + subjectId);
		}
		return searchedSubject;
	}
	
	@GetMapping("/searchBook/{bookId}")
	public Book searchBook(@PathVariable("bookId")Integer bookId) {
		Book searchedBook = bookService.get(bookId);
		if(searchedBook==null) {
			throw new BookNotFoundException("Book id not found - " + bookId);
		}
		return searchedBook;
	}
	
	@DeleteMapping("/deleteSubject/{subjectId}")
	public Subject deleteSubject(@PathVariable("subjectId")Long subjectId) {
		Subject subject=this.subjectService.get(subjectId);
		if(subject==null) {
			throw new SubjectNotFoundException("Subject id not found - " + subjectId);
		}
		if(!this.subjectService.delete(subjectId)) {
			throw new CustomException("Cannot delete Subject with id - " + subjectId);
		}
		return subject;
	}
	
	@DeleteMapping("/deleteBook/{bookId}")
	public Book deleteBook(@PathVariable("bookId")Integer bookId) {
		Book book=this.bookService.get(bookId);
		if(book==null) {
			throw new BookNotFoundException("Book id not found - " + bookId);
		}
		if(!this.bookService.delete(bookId)) {
			throw new CustomException("Cannot delete Book with id - " + bookId);
		}
		return book;
	}
	
	@GetMapping("/searchBookByTitle/{title}")
	public List<Book> searchBookByTitle(@PathVariable("title")String title) {
		List<Book> searchedBooks = bookService.findBookByTitle(title);
		if(searchedBooks == null) {
			throw new BookNotFoundException("Book title not found - " + title);
		}
		return searchedBooks;
	}
	
	@GetMapping("/searchSubjectByDuration/{duration}")
	public List<Subject> searchSubjectByDuration(@PathVariable("duration")Integer duration) {
		List<Subject> searchedSubjects = subjectService.findSubjectByDuration(duration);
		if(searchedSubjects == null) {
			throw new SubjectNotFoundException("Subject with duration not found - " + duration);
		}
		return searchedSubjects;
	}
}
