package com.management.firstjobapp.review.impl;

import com.management.firstjobapp.company.Company;
import com.management.firstjobapp.company.CompanyService;
import com.management.firstjobapp.review.Review;
import com.management.firstjobapp.review.ReviewRepository;
import com.management.firstjobapp.review.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ResponseEntity<Review> getReview(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);

        Review review = reviews.stream()
                .filter(r -> r.getId().equals(reviewId))
                .findFirst()
                .orElse(null);

        if (review != null) {
            return ResponseEntity.ok(review);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updateReview) {
        if (companyService.getCompanyById(companyId) != null) {
            updateReview.setCompany(companyService.getCompanyById(companyId));
            updateReview.setId(reviewId);
            reviewRepository.save(updateReview);
            return true;
        }  else {
            return false;
        }
    }


}
