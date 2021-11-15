package id.liostech.springpus.repositories;

import id.liostech.springpus.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}