package toread.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import toread.beans.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
