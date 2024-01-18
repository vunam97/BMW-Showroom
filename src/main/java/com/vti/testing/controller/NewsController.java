package com.vti.testing.controller;

import com.vti.testing.dto.NewsDto;
import com.vti.testing.form.news.NewsCreateForm;
import com.vti.testing.form.news.NewsUpdateForm;
import com.vti.testing.service.INewsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class NewsController {
    @Autowired
    private INewsService newsService;

    @Autowired
    public ModelMapper modelMapper;

    @GetMapping("/news")
    public Page<NewsDto> findAll(Pageable pageable) {
        return newsService.findAll(pageable);
    }

    @PostMapping("/news")
    public NewsDto create(@RequestBody NewsCreateForm form) {
        return newsService.create(form);
    }

    @PutMapping("/news/{id}")
    public NewsDto create(@RequestBody NewsUpdateForm form, @PathVariable("id") Integer id) {
        form.setId(id);
        return newsService.update(form);
    }

    @DeleteMapping("/news/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        newsService.deleteById(id);
    }
}
