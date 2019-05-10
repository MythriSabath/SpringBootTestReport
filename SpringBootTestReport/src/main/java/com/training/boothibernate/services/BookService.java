package com.training.boothibernate.services;
import java.util.List;
import com.training.boothibernate.entity.Book;

public interface BookService {
	List<Book> getAll();
	Book get(Integer id);
	boolean add(Book book);
	boolean edit(Book book);
	boolean delete(Integer id);
	List<Book> findBookByTitle(String title); 
}
