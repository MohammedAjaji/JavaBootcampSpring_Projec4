package com.example.spring_project4.Controller;


import com.example.spring_project4.Model.Movie;
import com.example.spring_project4.Service.MovieService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/get")
    public ResponseEntity getMovies(){
        List<Movie> movies = movieService.getMovies();
        return ResponseEntity.status(200).body(movies);
    }

    @PostMapping("/add")
    public ResponseEntity addMovie(@Valid @RequestBody Movie movie){
        movieService.addMovie(movie);
        return ResponseEntity.status(200).body("Movie Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMovie(@PathVariable Integer id, @Valid @RequestBody Movie movie){
        movieService.updateMovie(id, movie);
        return ResponseEntity.status(200).body("Movie Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMovie(@PathVariable Integer id){
        movieService.deleteMovie(id);
        return ResponseEntity.status(200).body("Movie deleted");
    }

    @GetMapping("/get-movie/{name}")
    public ResponseEntity getMovieByName(@PathVariable String name){
       Movie movie = movieService.getMovieByName(name);
       return ResponseEntity.status(200).body(movie);
    }

    @GetMapping("/get-duration/{name}")
    public ResponseEntity getMovieDuration(@PathVariable String name){
        Integer duration = movieService.getMovieDuration(name);
        return ResponseEntity.status(200).body("the duration of" + name + " is " + duration);
    }

    @GetMapping("/get-director/{name}")
    public ResponseEntity getMovieDirector(@PathVariable String name){
        String director = movieService.getMovieDirector(name);
        return ResponseEntity.status(200).body("the director of " + name + "is " + director);
    }

    @GetMapping("/get-rating/{name}")
    public ResponseEntity getMovieRating(@PathVariable String name){
        Integer rating = movieService.getMovieRating(name);
        return ResponseEntity.status(200).body("the rating of " + name + "is " + rating);
    }

    @GetMapping("/get-rating-more-than/{rate}")
    public ResponseEntity getMoviesRatingGreaterThan(@PathVariable Integer rate) {
        List<Movie> movies = movieService.getMoviesRatingGreaterThan(rate);
        return ResponseEntity.status(200).body(movies);
    }

    @GetMapping("/get-genre/{genre}")
    public ResponseEntity getMoviesByGenre(@PathVariable String genre) {
        List<Movie> movies = movieService.getMoviesByGenre(genre);
        return ResponseEntity.status(200).body(movies);
    }





}
