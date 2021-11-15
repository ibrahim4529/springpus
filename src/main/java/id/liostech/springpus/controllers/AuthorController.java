package id.liostech.springpus.controllers;

import id.liostech.springpus.entities.Author;
import id.liostech.springpus.models.AuthorCreateRequest;
import id.liostech.springpus.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/authors")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping
    public Author createAuthor(@RequestBody AuthorCreateRequest authorCreateRequest){
        return authorService.create(authorCreateRequest);
    }
}
