package bookstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookstore.data.BookRepository;
import bookstore.model.Book;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repo;

	public List<Book> findAll() {
		List<Book> list = new ArrayList<>();
		repo.findAll().forEach(list::add);
		return list;
	}
	
	public Book getBook(int bookId) {
       return repo.findOne(bookId);
	}
	
	public int save(Book book) {
	  return repo.save(book).getBookId();	
	}
	
	public void delete(Integer bookId) {
		repo.delete(bookId);
	}

	public List<Book> findByTitle(String title) {
		return repo.findByTitleStartingWith(title);
	}
	
}
