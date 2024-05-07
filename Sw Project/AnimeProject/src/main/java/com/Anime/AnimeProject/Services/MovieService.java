package com.Anime.AnimeProject.Services;

import com.Anime.AnimeProject.Model.Entity.Movie;
import com.Anime.AnimeProject.Repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }
    @Transactional
    public int incrementLikeNumbers(Integer movieId) {
        Movie movie = movieRepository.findById(movieId).orElse(null);
        if (movie != null) {
            int updatedLikes = movie.getLike_numbers() + 1;
            movie.setLike_numbers(updatedLikes);
            movieRepository.save(movie);
            return updatedLikes;
        }
        return -1;
    }
    public Integer getMovieRating(Integer movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("Movie not found"));
        return movie.getRating();
    }
    public String getMoviePrefing(Integer movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("Movie not found"));
        return movie.getPreif();
    }
    public Integer findMovieIdByName(String name) {
        Optional<Movie> movieOptional = movieRepository.findByName(name);
        return movieOptional.map(Movie::getId).orElse(null);
    }


}
