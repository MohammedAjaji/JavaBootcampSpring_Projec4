package com.example.spring_project4.Repository;

import com.example.spring_project4.Model.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director,Integer> {

    Director findDirectorById(Integer id);

    Director findDirectorByName(String name);
}
