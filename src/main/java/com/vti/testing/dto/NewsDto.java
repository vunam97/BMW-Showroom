package com.vti.testing.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class NewsDto {
    private int id;
    private String title;
    private String description;
    private String detail;
    private String image;
    private LocalDateTime dateNews;
}
