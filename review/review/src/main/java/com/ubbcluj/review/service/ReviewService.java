package com.ubbcluj.review.service;

import com.rabbitmq.client.*;
import com.ubbcluj.review.domain.Review;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Service
public class ReviewService {
    private List<Review> reviews=new ArrayList<>(Arrays.asList(new Review("Mistborn","Brandon Sanderson","the best"),
            new Review("Mistborn","Brandon Sanderson","the greatest"),
            new Review("Mistborn","Brandon Sanderson","kinda meh"),
            new Review("A Study in Drowning","Ava Reid","just wow")));

    public List<Review> getBooks() {
        return reviews;
    }

    public void setBooks(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Review> getReviewsByTitle(String title) throws IOException, TimeoutException {
        List<Review> reviewList = new ArrayList<>();
        for(Review r:reviews){
            if(title.equalsIgnoreCase(r.getTitle())){
               reviewList.add(r);
            }
        }

        return reviewList;
    }

}
