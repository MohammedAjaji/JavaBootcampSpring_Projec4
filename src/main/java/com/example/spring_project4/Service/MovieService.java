package com.example.spring_project4.Service;


import com.example.spring_project4.ApiException.ApiException;
import com.example.spring_project4.Model.Director;
import com.example.spring_project4.Model.Movie;
import com.example.spring_project4.Repository.DirectorRepository;
import com.example.spring_project4.Repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;

    public List<Movie> getMovies(){
       List<Movie> movies = movieRepository.findAll();
       return movies;
    }

    public void addMovie(Movie movie){
       Director director = directorRepository.findDirectorById(movie.getDirectorID());
       if (director == null){
           throw new ApiException("directorID Not found");
       }
        movieRepository.save(movie);
    }

    public void updateMovie(Integer id, Movie movie){
        Movie oldMovie = movieRepository.findMovieById(id);
        Director director = directorRepository.findDirectorById(movie.getDirectorID());

        if (oldMovie == null){
            throw new ApiException("movieID Not found");
        }
        if (director == null){
            throw new ApiException("directorID Not found");
        }
        oldMovie.setName(movie.getName());
        oldMovie.setGenre(movie.getGenre());
        oldMovie.setRating(movie.getRating());
        oldMovie.setDuration(movie.getDuration());
        oldMovie.setDirectorID(movie.getDirectorID());

        movieRepository.save(oldMovie);
    }

    public void deleteMovie(Integer id){
        Movie movie = movieRepository.findMovieById(id);
        if (movie == null){
            throw new ApiException("ID Not Found");
        }
        movieRepository.delete(movie);
    }

    public Movie getMovieByName(String name){
        Movie movie = movieRepository.findMovieByName(name);
        if (movie == null){
            throw new ApiException("Movie Not Found");
        }
        return movie;
    }

    public Integer getMovieDuration(String name){
        Movie movie = movieRepository.findMovieByName(name);
        if (movie == null){
            throw new ApiException("Movie Not Found");
        }
        return movie.getDuration();
    }

    public String getMovieDirector(String MovieName){
        Movie movie = movieRepository.findMovieByName(MovieName);
        if (movie == null){
            throw new ApiException("Movie Not Found");
        }
        Director director = directorRepository.findDirectorById(movie.getDirectorID());
        return director.getName();
    }

    public Integer getMovieRating(String MovieName){
        Movie movie = movieRepository.findMovieByName(MovieName);
        if (movie == null){
            throw new ApiException("Movie Not Found");
        }
        return movie.getRating();
    }

    public List<Movie> getMoviesRatingGreaterThan(Integer rate){
        List<Movie> movies = movieRepository.findAllByRatingGreaterThan(rate);
        if (movies.isEmpty()){
            throw new ApiException("Movie Not Found");
        }
        return movies;
    }

    public List<Movie> getMoviesByGenre(String genre){
        List<Movie> movies = movieRepository.findAllByGenre(genre);
        if (movies.isEmpty()){
            throw new ApiException("Movie Not Found");
        }
        return movies;
    }





}
