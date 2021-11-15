package id.liostech.springpus.controllers;

import id.liostech.springpus.dto.ApiResponse;
import id.liostech.springpus.dto.BookCreateRequest;
import id.liostech.springpus.entities.Book;
import id.liostech.springpus.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        ApiResponse response = new ApiResponse();
        try {
            response.setData(bookService.findAll());
            response.setStatus(true);
            response.getMessages().add("Load all books");
            return ResponseEntity.ok(response);
        }catch(Exception ex) {
            response.setStatus(false);
            response.getMessages().add(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    @PostMapping
    public ResponseEntity<?> createBook(@Valid @RequestBody BookCreateRequest bookCreateRequest, Errors errors){
        ApiResponse response = new ApiResponse();
        if(!errors.hasErrors()){
            Book book = bookService.create(bookCreateRequest);
            response.setStatus(true);
            response.getMessages().add("Buku berhasil ditambahkan");
            response.setData(book);
            return ResponseEntity.ok(response);
        }else{
            for (ObjectError err: errors.getAllErrors()){
                response.getMessages().add(err.getDefaultMessage());
            }
            response.setStatus(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
