package bookstore.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bookstore.model.Book;;

public interface BookRepository extends CrudRepository<Book, Integer> {
 
	 List<Book> findByTitleStartingWith(String title);
}
