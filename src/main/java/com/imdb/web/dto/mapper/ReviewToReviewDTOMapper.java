package com.imdb.web.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.imdb.model.Review;
import com.imdb.web.dto.ReviewDto;

@Component(value = "reviewToReviewDTOMapper")
public class ReviewToReviewDTOMapper implements GenericMapper<Review, ReviewDto> {

	@Override
	public ReviewDto map(Review source) {
		if (source == null)
			return null;
		ReviewDto target = new ReviewDto(source.getId(), source.getMovie().getId(), source.getComments(),
				source.getRating());
		return target;
	}

	@Override
	public List<ReviewDto> mapMultiple(List<Review> sourceList) {
		if (sourceList == null)
			return null;
		List<ReviewDto> targetList = new ArrayList<ReviewDto>(sourceList.size());
		for (Review source : sourceList) {
			targetList.add(map(source));
		}
		return targetList;
	}

	@Override
	public Review mapReverse(ReviewDto source) {
		if (source == null)
			return null;
		Review target = new Review(null, source.getComments(), source.getId());
		return target;
	}

}
