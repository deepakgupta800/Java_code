package com.Reactive.app.repository;

import com.Reactive.app.entity.Books;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Books, Integer> {

//    @Query("SELECT * FROM books WHERE name LIKE CONCAT('%', :query, '%')")

    @Query("SELECT * FROM books WHERE LOWER(name) LIKE CONCAT('%', LOWER(:query), '%')")
    Flux<Books> searchByName(String query);


    @Query("select * from books where author = :name")
    Flux<Books> getAllBooksByAuthor(String name);

}
