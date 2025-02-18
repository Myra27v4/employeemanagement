package com.example.employeemanagement.repository;

import com.example.employeemanagement.model.Rating;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class RatingRepository {

    private static final String RATING_FILE = "ratings.json";
    private ObjectMapper objectMapper = new ObjectMapper();

    public List<Rating> findAll() throws IOException {
        return List.of(objectMapper.readValue(new File(RATING_FILE), Rating[].class));
    }

    public void save(List<Rating> ratings) throws IOException {
        objectMapper.writeValue(new File(RATING_FILE), ratings);
    }
}

