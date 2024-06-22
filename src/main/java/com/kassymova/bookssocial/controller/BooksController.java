package com.kassymova.bookssocial.controller;


import com.kassymova.bookssocial.dto.BookResponse;
import com.kassymova.bookssocial.entity.Book;
import com.kassymova.bookssocial.service.BooksService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@Tag(name = "Books")
public class BooksController {

    private BooksService booksService;

    @GetMapping("/{book_id}")
    public ResponseEntity<BookResponse> getBook(@PathVariable Integer book_id) {
        return ResponseEntity.ok(booksService.findById(book_id));
    }
}
