package com.example.spring_project4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Movie {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   @NotEmpty(message = "name cannot be empty")
   @Size(min = 3, message = "name size should be more than 2")
   @Column(columnDefinition = "varchar(20) not null")
   private String name;

   @NotEmpty(message = "genre cannot be empty")
   @Column(columnDefinition = "varchar(20) not null check ( genre = 'drama' or genre = 'action' or genre = 'comedy' )")
   private String genre;

   @NotNull(message = "rating cannot be empty")
   @Min(value = 1, message = "Rating should be between 1 and 5")
   @Max(value = 5, message = "Rating should be between 1 and 5")
   @Column(columnDefinition = "int not null")
   private Integer rating;

   @NotNull(message = "duration cannot be empty")
   @Min(value = 60, message = "duration should be at least 60")
   @Column(columnDefinition = "int not null")
   private Integer duration;

   @NotNull(message = "directorID cannot be empty")
   @Column(columnDefinition = "int not null")
   private Integer directorID;
}
