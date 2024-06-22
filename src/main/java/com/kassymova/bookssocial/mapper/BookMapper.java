package com.kassymova.bookssocial.mapper;


import com.kassymova.bookssocial.dto.BookResponse;
import com.kassymova.bookssocial.entity.Book;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {

    public static BookResponse toBookResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .owner(book.getOwner().getFullname())
                .build();
    }
}
