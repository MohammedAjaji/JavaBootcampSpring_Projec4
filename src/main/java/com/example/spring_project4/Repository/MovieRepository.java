package com.example.spring_project4.Repository;

import com.example.spring_project4.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Integer> {

    Movie findMovieById(Integer id);

    Movie findMovieByName(String name);

    List<Movie> findAllByDirectorID(Integer id);

    List<Movie> findAllByRatingGreaterThan(Integer rate);

    List<Movie> findAllByGenre(String genre);


}
