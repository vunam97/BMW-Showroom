package com.vti.testing.service.impl;

import com.vti.testing.dto.FeedbackDTO;
import com.vti.testing.entity.Feedback;
import com.vti.testing.repository.FeedbackRepository;
import com.vti.testing.service.IFeedbackService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FeedbackServiceImpl implements IFeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<Feedback> getAllFeedbacks(Pageable pageable){
        return feedbackRepository.findAll(pageable);
    }

    @Override
    public Feedback getFeedbackById(long id){
        return feedbackRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Feedback not found with id: " + id));
    }

    @Override
    public List<Feedback> getFeedbacksByFullName(String fullName, Pageable pageable){
        return (List<Feedback>) feedbackRepository.findByFullName(fullName,pageable);
    }

    @Override
    public void createFeedback(FeedbackDTO feedbackDTO){
        Feedback feedback = modelMapper.map(feedbackDTO, Feedback.class);
        feedback.setSendDate(LocalDateTime.now());
        feedbackRepository.save(feedback);
    }

    @Override
    public void deleteFeedbackById(long id){
        feedbackRepository.deleteById(id);
    }
}
