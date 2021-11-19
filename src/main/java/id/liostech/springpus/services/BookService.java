package id.liostech.springpus.services;

import id.liostech.springpus.entities.Book;
import id.liostech.springpus.dto.request.BookCreateRequest;

import javax.transaction.Transactional;

@Transactional
public interface BookService {
    Book create(BookCreateRequest bookCreateRequest);
    Iterable<Book> findAll();
    void delete(Long id);
    Iterable<Book> findByTitle(String title);

    Iterable<Book> findByTitleAndAuthor(String title, Long authorId);
}
