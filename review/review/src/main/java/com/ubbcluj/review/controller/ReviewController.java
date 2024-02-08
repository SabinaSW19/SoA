package com.ubbcluj.review.controller;


import com.ubbcluj.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @RequestMapping(value="/review/{title}",method= RequestMethod.GET)
    public ResponseEntity<?> getReviewsByTitle(@PathVariable("title") String title) throws IOException, TimeoutException {
        System.out.println("Calling getReviewsByTitle" + title);
        return new ResponseEntity<>(reviewService.getReviewsByTitle(title),HttpStatus.OK);
    }

}
