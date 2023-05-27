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
public class DirectorService {

    private final DirectorRepository directorRepository;
    private final MovieRepository movieRepository;

    public List<Director> getDirectors(){
        List<Director> directors = directorRepository.findAll();
        return directors;
    }

    public void addDirector(Director director){
        directorRepository.save(director);
    }

    public void updateDirector(Integer id, Director director){
        Director oldDirector = directorRepository.findDirectorById(id);

        if (oldDirector == null){
            throw new ApiException("ID Not Found");
        }

        oldDirector.setName(director.getName());

        directorRepository.save(oldDirector);
    }

    public void deleteDirector(Integer id){
        Director director = directorRepository.findDirectorById(id);

        if (director == null){
            throw new ApiException("ID Not Found");
        }

        directorRepository.delete(director);
    }

    public List<Movie> getAllDirectorMovies(String directorName){
        Director director = directorRepository.findDirectorByName(directorName);

        if (director == null){
            throw new ApiException("Director Not Found");
        }

        List<Movie> movies = movieRepository.findAllByDirectorID(director.getId());
        if (movies.isEmpty()){
            throw new ApiException("Movies Not Found for this Director");
        }
        return movies;

    }


}
