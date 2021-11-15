package id.liostech.springpus.services;

import id.liostech.springpus.entities.Author;
import id.liostech.springpus.models.AuthorCreateRequest;
import id.liostech.springpus.models.AuthorUpdateRequest;

import javax.transaction.Transactional;

@Transactional
public interface AuthorService {
    Author create(AuthorCreateRequest authorCreateRequest);
    Author update(AuthorUpdateRequest authorUpdateRequest);

}
