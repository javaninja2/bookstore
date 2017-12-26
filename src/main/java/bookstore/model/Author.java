package bookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name = "author")
public class Author {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Integer authorId;
	
	String name;
	
	
	public Author() {
		super();
	}


	public Author(Integer authorId, String name) {
		super();
		this.authorId = authorId;
		this.name = name;
	}


	public Integer getAuthorId() {
		return authorId;
	}


	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", name=" + name + "]";
	}



	
	
}
