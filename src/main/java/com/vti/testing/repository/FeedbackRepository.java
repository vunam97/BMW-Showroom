package com.vti.testing.repository;

import com.vti.testing.entity.Feedback;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByFullName(String fullName, Pageable pageable);
    void deleteFeedbackById(long id);
}