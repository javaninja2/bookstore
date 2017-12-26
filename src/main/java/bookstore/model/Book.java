package bookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity (name = "book")
public class Book {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Integer bookId;
	
	String title;
	
	@ManyToOne (targetEntity = Author.class)
	Author author;
	
	public Book() {
		super();
	}

	public Book(Integer bookId, String title) {
		super();
		this.bookId = bookId;
		this.title = title;
	}
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + "]";
	}

	
	
}
