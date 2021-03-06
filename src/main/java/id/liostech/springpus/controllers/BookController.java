package id.liostech.springpus.controllers;

import id.liostech.springpus.dto.response.ApiResponse;
import id.liostech.springpus.dto.request.BookCreateRequest;
import id.liostech.springpus.entities.Book;
import id.liostech.springpus.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> createBook(@ModelAttribute BookCreateRequest bookCreateRequest){
        ApiResponse response = new ApiResponse();
        Book book = bookService.create(bookCreateRequest);
        response.setStatus(true);
        response.getMessages().add("Buku berhasil ditambahkan");
        response.setData(book);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id){
        ApiResponse response = new ApiResponse();
        bookService.delete(id);
        response.setStatus(true);
        response.getMessages().add("Success Delete book");
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "search")
    public ResponseEntity<?> findByTitle(@RequestParam String title){
        ApiResponse response = new ApiResponse();
        response.setStatus(true);
        response.setData(bookService.findByTitle(title));
        response.getMessages().add("Success Delete book");
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "filter")
    public ResponseEntity<?> findByTitleAndAuthor(@RequestParam String title, @RequestParam Long authorId){
        ApiResponse response = new ApiResponse();
        response.setStatus(true);
        response.setData(bookService.findByTitleAndAuthor(title, authorId));
        response.getMessages().add("Success load book");
        return ResponseEntity.ok(response);
    }
}
