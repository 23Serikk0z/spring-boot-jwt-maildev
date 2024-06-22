package com.kassymova.bookssocial.service;


import com.kassymova.bookssocial.dto.BookResponse;
import com.kassymova.bookssocial.mapper.BookMapper;
import com.kassymova.bookssocial.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BooksService {

    private final BookRepository bookRepository;

    public BookResponse findById(Integer bookId) {
        return bookRepository.findById(bookId)
                .map(BookMapper::toBookResponse)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with ID: " + bookId));
    }
}
