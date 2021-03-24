package toread.controller;

import org.springframework.context.annotation.Bean;

import toread.beans.Author;
import toread.beans.Book;

public class BeanConfiguration {
	@Bean
	public Book book(){
		Book bean = new Book("Zero to One");
		return bean;
	}
	
	@Bean
	public Author author() {
		Author bean = new Author("Peter Theil");
		return bean;
	}
}
