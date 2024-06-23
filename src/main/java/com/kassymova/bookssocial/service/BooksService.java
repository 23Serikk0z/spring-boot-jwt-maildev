package com.kassymova.bookssocial.service;


import com.kassymova.bookssocial.dto.BookResponse;
import com.kassymova.bookssocial.entity.Book;
import com.kassymova.bookssocial.entity.User;
import com.kassymova.bookssocial.exception.OperationNotPermittedException;
import com.kassymova.bookssocial.mapper.BookMapper;
import com.kassymova.bookssocial.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BooksService {

    private final BookRepository bookRepository;

    public BookResponse findById(Integer id) {
        return bookRepository.findById(id)
                .map(BookMapper::toBookResponse)
                .orElseThrow(() -> new EntityNotFoundException("Book with the id not found"));
    }

    public List<BookResponse> findAll() {
        return bookRepository.findAll()
                .stream().map(BookMapper::toBookResponse).toList();
    }
    public BookResponse takeBook(Integer id, Authentication connectedUser) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book with the id not found"));

        User user = ((User) connectedUser.getPrincipal());
        if(Objects.equals(book.getOwner().getId(), user.getId())) {
            throw new OperationNotPermittedException("You cant own your book");
        }
        if(book.getStatus().name().equals("TAKEN")) {
            throw new OperationNotPermittedException("This book is taken");
        }
        return null;
    }


}
