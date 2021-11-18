package id.liostech.springpus.services;

import id.liostech.springpus.entities.Author;
import id.liostech.springpus.dto.request.AuthorCreateRequest;

import javax.transaction.Transactional;

@Transactional
public interface AuthorService {
    Author create(AuthorCreateRequest authorCreateRequest);
}
