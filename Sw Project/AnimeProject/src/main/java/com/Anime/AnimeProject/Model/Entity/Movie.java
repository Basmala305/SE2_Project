package com.Anime.AnimeProject.Model.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
@Entity
@Data
@Builder
@Table(name="movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true ,nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer like_numbers;
    private Integer rating;
    private String  preif;

    public Movie() {
    }

    public Movie(Integer id, String name, Integer like_numbers, Integer rating, String preif) {
        this.id = id;
        this.name = name;
        this.like_numbers = like_numbers;
        this.rating = rating;
        this.preif = preif;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLike_numbers() {
        return like_numbers;
    }

    public void setLike_numbers(Integer like_numbers) {
        this.like_numbers = like_numbers;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getPreif() {
        return preif;
    }

    public void setPreif(String preif) {
        this.preif = preif;
    }
}
