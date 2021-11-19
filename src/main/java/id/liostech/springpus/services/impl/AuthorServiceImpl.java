package id.liostech.springpus.services.impl;

import id.liostech.springpus.dto.request.AuthorCreateRequest;
import id.liostech.springpus.entities.Author;
import id.liostech.springpus.repositories.AuthorRepository;
import id.liostech.springpus.services.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Author create(AuthorCreateRequest authorCreateRequest) {
        Author author = modelMapper.map(authorCreateRequest, Author.class);
        return authorRepository.save(author);
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Author author = authorRepository.getById(id);
        authorRepository.delete(author);
    }
}
