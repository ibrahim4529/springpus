package id.liostech.springpus.services.impl;

import id.liostech.springpus.entities.Book;
import id.liostech.springpus.dto.BookCreateRequest;
import id.liostech.springpus.repositories.BookRepository;
import id.liostech.springpus.services.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Book create(BookCreateRequest bookCreateRequest) {
        Book book = modelMapper.map(bookCreateRequest, Book.class);
        return bookRepository.save(book);
    }
}
