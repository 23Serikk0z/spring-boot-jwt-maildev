package com.kassymova.bookssocial.handler;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Map;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionResponse {
    private Integer bussinessErrorCode;
    private String bussinessExceptionDescription;
    private String errorMessage;
    private Set<String> validationErrors;
    private Map<String, String> errors;


}
