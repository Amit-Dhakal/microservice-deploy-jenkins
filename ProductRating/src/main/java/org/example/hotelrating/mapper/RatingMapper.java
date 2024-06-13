package org.example.hotelrating.mapper;

import org.example.hotelrating.DTO.RatingDTO;
import org.example.hotelrating.model.Rating;

public class RatingMapper {
    public static RatingDTO entityToDTOConverter(Rating rating){
        RatingDTO ratingDTO=new RatingDTO();
        ratingDTO.setPr_id(rating.getPr_id());
        ratingDTO.setRating(rating.getRating());
        ratingDTO.setProduct_name(rating.getProduct_name());
        return ratingDTO;
    }
    public Rating dtoToEntityConvereter(RatingDTO ratingDTO){
        Rating rating=new Rating();
        rating.setPr_id(ratingDTO.getPr_id());
        rating.setRating(ratingDTO.getRating());
        rating.setProduct_name(ratingDTO.getProduct_name());
        return rating;
    }

}
