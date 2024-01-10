package com.vti.testing.service.impl;

import com.vti.testing.dto.NewsDto;
import com.vti.testing.entity.News;
import com.vti.testing.form.news.NewsCreateForm;
import com.vti.testing.form.news.NewsUpdateForm;
import com.vti.testing.repository.NewsRepository;
import com.vti.testing.service.INewsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NewServiceImpl implements INewsService {
    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<NewsDto> findAll(Pageable pageable) {
        return newsRepository.findAll(pageable).map(news -> modelMapper.map(news, NewsDto.class));
    }

    @Override
    public NewsDto create(NewsCreateForm form) {
        News news = modelMapper.map(form, News.class);
        var savedNews = newsRepository.save(news);
        return modelMapper.map(savedNews, NewsDto.class);
    }

    @Override
    public NewsDto update(NewsUpdateForm form) {
        News news = modelMapper.map(form, News.class);
        var savedNews = newsRepository.save(news);
        return modelMapper.map(savedNews, NewsDto.class);
    }

    @Override
    public void deleteById(Integer id) {
        newsRepository.deleteById(id);
    }
}
