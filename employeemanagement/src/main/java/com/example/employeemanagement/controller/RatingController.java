package com.example.employeemanagement.controller;

import com.example.employeemanagement.model.Rating;
import com.example.employeemanagement.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/departments/{id}/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> captureRating(@PathVariable Long id, @Valid @RequestBody Rating rating) {
        Rating capturedRating = ratingService.captureRating(id, rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(capturedRating);
    }
}

