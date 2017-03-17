package com.hope.controllers;

import com.hope.models.Movie;
import com.hope.models.SearchResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private RestTemplate restTemplate = new RestTemplate();


    @GetMapping("")
    public Iterable<Movie> searchMovies(@RequestParam(value="q", required=true) String query) {
        String fullQuery = "http://www.omdbapi.com/?s=" + query;
//        String result = restTemplate.getForObject( fullQuery, String.class );
        SearchResult result = restTemplate.getForObject( fullQuery, SearchResult.class );
        return result.getSearch();
//        return null;
    }
}
