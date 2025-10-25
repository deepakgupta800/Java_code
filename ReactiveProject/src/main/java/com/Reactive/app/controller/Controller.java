package com.Reactive.app.controller;

import com.Reactive.app.Dto.Requestbook;
import com.Reactive.app.entity.Books;
import com.Reactive.app.impl.BookServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.print.Book;
import java.time.Duration;

@RestController
@RequestMapping("/books")
@Tag(name = "Book APIs", description = "Endpoints for managing books")
public class Controller {

    @Autowired
    BookServiceImpl service;

    @Operation(
            summary = "create a new Book",
            description = "Insert a new book"
    )
    @PostMapping
    public Mono<Books> createBook(@RequestBody Books books){

        return  service.create(books);
    }


    @Operation(
            summary = "Get all books",
            description = "Returns a list of all books in the system"
    )
    @GetMapping()
    public Flux<Books> getAllBooks(){
        return service.getAll().log().map(data->{
            data.setName(data.getName().toUpperCase());
            return data;
        });
    }

    @Operation(
            summary = "Get book by ID",
            description = "Returns a single book based on the ID provided"
    )
    @GetMapping("/{bookId}")
    public Mono<Books> findBookById(@PathVariable int bookId){
        return service.getById(bookId);
    }

    @Operation(
            summary = "update a book",
            description = "update a existing book with the help of Id"
    )
    @PutMapping("/{bid}")
    public Mono<Books> updateBook(@PathVariable("bid") int bookId, @RequestBody  Books book){
        return service.update(book,bookId);
    }

    @Operation(
            summary = "Delete a book",
            description = "Delete book with the use of bookId"
    )
    @DeleteMapping("/{bookId}")
    public Mono<Void> DeleteBookById(@PathVariable int bookId){
        return service.delete(bookId);
    }

    @Operation(
            summary = "find books",
            description = "Find Books with the help of Keyword"
    )
    @GetMapping("/search/{query}")
    public Flux<Books> searchNameByName(@PathVariable String query){

      return  service.search(query);
    }


    @Operation(
            summary = "find books from author name",
            description = "Find all the books with book of a particular author"
    )
    @GetMapping("/author")
    public Flux<Books> searchAllBookOfParticularAuthor(@RequestParam String name){
        return service.getAllBookOfAuthor(name);
    }
}
