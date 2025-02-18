package com.example.employeemanagement.service;

import com.example.employeemanagement.model.Department;
import com.example.employeemanagement.model.Rating;
import com.example.employeemanagement.repository.DepartmentRepository;
import com.example.employeemanagement.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public Rating captureRating(Long departmentId, Rating rating) {
        try {
            List<Rating> ratings = ratingRepository.findAll();
            ratings.add(rating);
            ratingRepository.save(ratings);

            // Update department rating
            List<Department> departments = departmentRepository.findAll();
            Department department = departments.stream().filter(d -> d.getId().equals(departmentId)).findFirst().orElse(null);
            if (department != null) {
                double averageRating = ratings.stream().filter(r -> r.getDepartmentId().equals(departmentId))
                        .mapToDouble(Rating::getRating).average().orElse(0.0);
                department.setRating(averageRating);
                departmentRepository.save(departments);
            }

            return rating;
        } catch (IOException e) {
            // Handle exception
            return null;
        }
    }
}
