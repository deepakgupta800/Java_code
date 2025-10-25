package com.Reactive.app.impl;

import com.Reactive.app.entity.Books;
import com.Reactive.app.repository.BookRepository;
import com.Reactive.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.print.Book;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;


    @Override
    public Mono<Books> create(Books book) {
        Mono<Books> bookCreated = bookRepository.save(book);
        return bookCreated;
    }

    @Override
    public Flux<Books> getAll() {

        return bookRepository.findAll();
    }

    @Override
    public Mono<Books> getById(int bookId) {

        return bookRepository.findById(bookId);
    }

    @Override
    public Mono<Books> update(Books book, int bookId) {

        Mono<Books> OldData = bookRepository.findById(bookId);
        return OldData.flatMap(books -> {

            books.setAuthor(book.getAuthor());
            books.setName(book.getName());
            books.setDescription(book.getDescription());
            books.setPublisher(book.getPublisher());
            return bookRepository.save(books);

        });


    }

    @Override
    public Mono<Void> delete(int bookId) {
       return bookRepository.deleteById(bookId);

    }

    @Override
    public Flux<Books> search(String query) {
        return bookRepository.searchByName(query);
    }

    @Override
    public Flux<Books> getAllBookOfAuthor(String name){
        return bookRepository.getAllBooksByAuthor(name);
    }
}
