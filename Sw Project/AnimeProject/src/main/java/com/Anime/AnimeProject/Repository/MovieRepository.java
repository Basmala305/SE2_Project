package com.Anime.AnimeProject.Repository;
import com.Anime.AnimeProject.Model.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Optional<Movie> findByName(String name);
}
