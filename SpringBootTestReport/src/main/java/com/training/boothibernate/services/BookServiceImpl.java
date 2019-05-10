package com.training.boothibernate.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.training.boothibernate.dao.BookRepository;
import com.training.boothibernate.entity.Book;
import com.training.boothibernate.exceptions.BookNotFoundException;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getAll() {
		return bookRepository.findAll();
	}

	@Override
	public Book get(Integer id) {
		Optional<Book> result= this.bookRepository.findById(id);
	 	Book book = null;
	 	if(result.isPresent())
	 		book=result.get();
	 	else
	 		throw new BookNotFoundException("Book not found with id - " + id);
	 	return book;
	}

	@Override
	public boolean add(Book book) {
		this.bookRepository.save(book);
		return true;
	}

	@Override
	public boolean edit(Book book) {
		this.bookRepository.save(book);
		return true;
	}

	@Override
	public boolean delete(Integer id) {
		this.bookRepository.deleteById(id);
		return true;
	}

	@Override
	public List<Book> findBookByTitle(String title) {
		return this.bookRepository.findBookByTitle(title);
	}
}
