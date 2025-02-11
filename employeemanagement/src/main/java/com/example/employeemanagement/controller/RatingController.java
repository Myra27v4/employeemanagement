package com.example.employeemanagement.controller;

import com.example.employeemanagement.model.Rating;
import com.example.employeemanagement.util.JsonDatastore;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @PostMapping("/departments/{id}/rating")
    public ResponseEntity<String> addRating(@PathVariable String id, @Valid @RequestBody Rating rating) throws IOException {
        Map<String, Object> data = JsonDatastore.readData();
        List<Rating> ratings = (List<Rating>) data.get("ratings");
        ratings.add(rating);
        JsonDatastore.writeData(data);
        return ResponseEntity.status(HttpStatus.CREATED).body("Rating added");
    }
}
