package id.liostech.springpus.services.impl;

import id.liostech.springpus.entities.Author;
import id.liostech.springpus.entities.Book;
import id.liostech.springpus.dto.request.BookCreateRequest;
import id.liostech.springpus.repositories.AuthorRepository;
import id.liostech.springpus.repositories.BookRepository;
import id.liostech.springpus.services.BookService;
import id.liostech.springpus.services.FileService;
import id.liostech.springpus.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ValidationUtil validationUtil;
    @Autowired
    private FileService fileService;

    @Override
    public Book create(BookCreateRequest bookCreateRequest) {
        validationUtil.validate(bookCreateRequest);

        Author author = authorRepository.getById(bookCreateRequest.getAuthorId());
        Book book = modelMapper.map(bookCreateRequest, Book.class);
        if(!bookCreateRequest.getImage().isEmpty()){
            fileService.store(bookCreateRequest.getImage());
            book.setImg(bookCreateRequest.getImage().getOriginalFilename());
        }
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    @Override
    public Iterable<Book> findAll() {
        return  bookRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Book book = bookRepository.getById(id);
        String image = book.getImg();
        fileService.delete(image);
        bookRepository.delete(book);
    }

    @Override
    public Iterable<Book> findByTitle(String title) {
        return bookRepository.findBookByTitleContaining(title);
    }

    @Override
    public Iterable<Book> findByTitleAndAuthor(String title, Long authorId) {
        return bookRepository.findBookByTitleContainingAndAuthorId(title, authorId);
    }
}
