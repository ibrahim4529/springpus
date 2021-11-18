package id.liostech.springpus.controllers;

import id.liostech.springpus.dto.response.ApiResponse;
import id.liostech.springpus.entities.Author;
import id.liostech.springpus.dto.request.AuthorCreateRequest;
import id.liostech.springpus.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<?> createAuthor(@Valid @RequestBody AuthorCreateRequest authorCreateRequest, Errors errors){
        ApiResponse apiResponse = new ApiResponse();
        if(!errors.hasErrors()){
            Author author = authorService.create(authorCreateRequest);
            apiResponse.setStatus(true);
            apiResponse.getMessages().add("Author Berhasil di tambahkan");
            apiResponse.setData(author);
            return ResponseEntity.ok(apiResponse);
        }else{
            for (ObjectError err: errors.getAllErrors()){
                apiResponse.getMessages().add(err.getDefaultMessage());
            }
            apiResponse.setStatus(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
        }

    }
}
