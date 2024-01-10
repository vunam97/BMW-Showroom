package com.vti.testing.service;

import com.vti.testing.dto.NewsDto;
import com.vti.testing.form.news.NewsCreateForm;
import com.vti.testing.form.news.NewsUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface INewsService {
    Page<NewsDto> findAll(Pageable pageable);

    NewsDto create(NewsCreateForm form);

    NewsDto update(NewsUpdateForm form);

    void deleteById(Integer id);
}
