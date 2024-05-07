package com.Anime.AnimeProject.Controller;

import com.Anime.AnimeProject.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PutMapping("/{movieId}/like")
    public int incrementLikeNumbers(@PathVariable Integer movieId) {
        return movieService.incrementLikeNumbers(movieId);
    }
    @GetMapping("/{movieId}/rating")
    public ResponseEntity<Integer> getMovieRating(@PathVariable Integer  movieId) {
        Integer rating = movieService.getMovieRating(movieId);
        return ResponseEntity.ok(rating);
    }
    @GetMapping("/{movieId}/prefix")
    public ResponseEntity<String> getMoviePrefix(@PathVariable Integer movieId) {
        String prefix = movieService.getMoviePrefing(movieId);
        return ResponseEntity.ok(prefix);
    }
    @GetMapping("/search")
    public ResponseEntity<Object> searchMovieIdByName(@RequestParam("name") String name) {
        Integer movieId = movieService.findMovieIdByName(name);
        if (movieId != null) {
            return ResponseEntity.ok(movieId);
        } else {
            String errorMessage = "Movie with name '" + name + "' not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }


    }
