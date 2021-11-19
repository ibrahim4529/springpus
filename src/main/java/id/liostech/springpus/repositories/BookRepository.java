package id.liostech.springpus.repositories;

import id.liostech.springpus.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Long> {

    Iterable<Book> findBookByTitleContainingAndAuthorId(@Param("title") String title, @Param("authorId") Long authorId);
    Iterable<Book> findBookByTitleContaining(@Param("title") String title);
}