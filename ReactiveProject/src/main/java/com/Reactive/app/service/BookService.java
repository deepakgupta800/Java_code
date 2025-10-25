package com.Reactive.app.service;

import com.Reactive.app.entity.Books;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.print.Book;

public interface BookService {

     Mono<Books> create(Books book);

     Flux<Books> getAll();

     Mono<Books> getById(int bookId);

     Mono<Books> update(Books book, int bookId);
     Mono<Void> delete(int bookId);

     Flux<Books> search(String query);

     Flux<Books> getAllBookOfAuthor(String name);


}
