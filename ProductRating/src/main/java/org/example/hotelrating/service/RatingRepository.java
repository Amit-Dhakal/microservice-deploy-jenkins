package org.example.hotelrating.service;

import jakarta.persistence.Id;
import org.example.hotelrating.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Id> {


}
