package com.vti.testing.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class NewsDto {
    private int id;
    private String title;
    private String description;
    private String image;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime dateNews;
}
