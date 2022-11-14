package com.example.disney.utils;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
public class PostResponse {

    private String link;
    private HttpStatus httpStatus;
}