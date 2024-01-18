package com.vti.testing.service;

import com.vti.testing.dto.FeedbackDTO;
import com.vti.testing.entity.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFeedbackService {
    Page<Feedback> getAllFeedbacks(Pageable pageable);

    Feedback getFeedbackById(long id);

    List<Feedback> getFeedbacksByFullName(String fullName, Pageable pageable);

    void createFeedback(FeedbackDTO feedbackDTO);

    void deleteFeedbackById(long id);
}
