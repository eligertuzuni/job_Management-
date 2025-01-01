package com.management.firstjobapp.review;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId, Review review);
    ResponseEntity<Review> getReview(Long companyId, Long reviewId);
}
