package com.training.boothibernate.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.training.boothibernate.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

	@Query("select b from Book b where b.title like %:title%")
    List<Book> findBookByTitle(@Param("title") String title); 
	
}
