package toread;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import toread.beans.Author;
import toread.beans.Book;
import toread.beans.Publisher;
import toread.controller.BeanConfiguration;
import toread.repository.BookRepository;

@SpringBootApplication
public class BooksApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}
	
	@Autowired
	BookRepository repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		Book book1 = appContext.getBean("book", Book.class);
		book1.setTitle("Da Vinci Code");
		book1.setCost(21.14);
		repo.save(book1);
		
		Book book2 = new Book("Beyond Order");
		Author author2 = new Author("Jordan Peterson", "Psychology", "Professor and clinical psychologist");
		Publisher publisher2 = new Publisher("Random House, Inc.", "books", "Canada");
		book2.setAuthor(author2);
		book2.setPublisher(publisher2);
		repo.save(book2);
		
		List<Book> allBooks = repo.findAll();
		for(Book b: allBooks) {
			System.out.println(b.toString());
		}

		((AbstractApplicationContext) appContext).close();
	}

}
