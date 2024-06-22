package com.kassymova.bookssocial.dto;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {

    private Integer id;
    private String title;
    private String author;
    private String owner;
}
