package com.management.firstjobapp.review.impl;

import com.management.firstjobapp.review.Review;
import com.management.firstjobapp.review.ReviewRepository;
import com.management.firstjobapp.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews =
        return List.of();
    }
}
