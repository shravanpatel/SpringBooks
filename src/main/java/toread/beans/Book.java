package toread.beans;

import java.util.ArrayList;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Entity
@Table(name="bookrecords")
public @Data class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="book_title", updatable=false, insertable=false)
	private String title;
	@Autowired
	@AttributeOverrides({
		  @AttributeOverride( name = "name", column = @Column(name = "author")),
		  @AttributeOverride( name = "expertise", column = @Column(name = "author_expertise")),
		  @AttributeOverride( name = "profession", column = @Column(name = "author_profession"))
	})
	private Author author;
	private ArrayList<String> subjects;
	@Embedded
	private Publisher publisher;
	private String isbn;
	private double cost;

	
	public Book() {
		super();
	}
	
	public Book(String title, Author author, Publisher publisher, ArrayList<String> subjects, String isbn,
			double cost) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.subjects = subjects;
		this.isbn = isbn;
		this.cost = cost;
	}

	public Book(String title) {
		super();
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publisher=" + publisher + ", subjects="
				+ subjects + ", isbn=" + isbn + ", cost=" + cost + "]";
	}

	public Book(long id, String title, Author author, Publisher publisher, ArrayList<String> subjects, String isbn,
			double cost) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.subjects = subjects;
		this.isbn = isbn;
		this.cost = cost;
	}
}
