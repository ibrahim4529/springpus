package id.liostech.springpus.services;

import id.liostech.springpus.entities.Book;
import id.liostech.springpus.dto.BookCreateRequest;

import javax.transaction.Transactional;

@Transactional
public interface BookService {
    Book create(BookCreateRequest bookCreateRequest);
    Iterable<Book> findAll();
}
