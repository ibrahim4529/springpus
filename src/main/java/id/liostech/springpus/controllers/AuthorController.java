package id.liostech.springpus.controllers;

import id.liostech.springpus.dto.request.AuthorCreateRequest;
import id.liostech.springpus.dto.response.ApiResponse;
import id.liostech.springpus.entities.Author;
import id.liostech.springpus.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<?> createAuthor(@RequestBody AuthorCreateRequest authorCreateRequest) {
        ApiResponse apiResponse = new ApiResponse();

        Author author = authorService.create(authorCreateRequest);
        apiResponse.setStatus(true);
        apiResponse.getMessages().add("Author Berhasil di tambahkan");
        apiResponse.setData(author);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus(true);
        apiResponse.getMessages().add("Author Berhasil di muat");
        apiResponse.setData(authorService.findAll());
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id){
        ApiResponse response = new ApiResponse();
        authorService.delete(id);
        response.setStatus(true);
        response.getMessages().add("Success Delete author");
        return ResponseEntity.ok(response);
    }


}
