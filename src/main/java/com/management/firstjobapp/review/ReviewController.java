package com.management.firstjobapp.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long id) {
        return new ResponseEntity(reviewService.getAllReviews(id), HttpStatus.OK);
    }
    @PostMapping("/reviews")

    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review) {

        boolean isReviewSaved = reviewService.addReview(companyId, review);
        if (isReviewSaved) {
            return new ResponseEntity<>("Review added Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review not Save", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        ResponseEntity<Review> response = reviewService.getReview(companyId, reviewId);

        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok(response.getBody());
        } else {
            return ResponseEntity.status(response.getStatusCode()).build();
        }
    }
    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId,
                                               @RequestBody Review review) {
        return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);

    }




}
