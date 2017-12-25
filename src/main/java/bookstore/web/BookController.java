package bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bookstore.model.Book;
import bookstore.service.BookService;


@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping( "/")
	public String defaultMethod() {
		return "reached root dir!";
	}
	
	@GetMapping ("/books")
	public List<Book> getBooks(@RequestParam(required = false) String title) {
		if (title != null) {
		   return bookService.findByTitle(title);
		} else {
		   return bookService.findAll();
	    }
	}
	
	@PostMapping ("/books")
	public String save(@RequestBody Book book) {
		System.out.println(book);
		int bookId =  bookService.save(book);
		return "New book saved with id:" + bookId;
	}

	@GetMapping("/books/{id}")
	public Book get(@PathVariable("id") int id) {
		return  bookService.getBook(id);
	}	

	
	@DeleteMapping ("/books/{id}")
	public void getBook(@PathVariable Integer id) {
		bookService.delete(id);
	}

}
