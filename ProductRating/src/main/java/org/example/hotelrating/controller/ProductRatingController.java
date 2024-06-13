package org.example.hotelrating.controller;
import org.example.hotelrating.DTO.RatingDTO;
import org.example.hotelrating.mapper.RatingMapper;
import org.example.hotelrating.model.Rating;
import org.example.hotelrating.service.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productrating")
public class ProductRatingController {
    @Autowired
    RatingRepository ratingRepository;
    @PostMapping("/save-rating")
    public ResponseEntity<?> saveRatings(@RequestBody RatingDTO ratingDTO){
        RatingMapper mapper=new RatingMapper();
        Rating rating=mapper.dtoToEntityConvereter(ratingDTO);
        ratingRepository.save(rating);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/get-rating-data")
    public ResponseEntity<?> getRatingData(){
        RatingMapper mapper=new RatingMapper();
        List<Rating> listRating= ratingRepository.findAll();
        List<RatingDTO> listRatingconverter= listRating.stream().map(RatingMapper::entityToDTOConverter).collect(Collectors.toList());
        return new ResponseEntity<>(listRatingconverter,HttpStatus.CREATED);
    }


}






//username==productname==rating
//