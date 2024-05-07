package com.Anime.AnimeProject.Model.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
@Table(name="commentm")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private Viewer user;
//
//    @ManyToOne
//    @JoinColumn(name = "movie_id", referencedColumnName = "id")
//    private Movie movie;
@Column(name = "user_id")
private Integer userId;

    @Column(name = "movie_id")
    private Integer movieId;



    @Column(name = "comment_text", columnDefinition = "TEXT")
    private String commentText;
    public Comment() {
        // Default constructor is required by Hibernate
    }

    public Comment(Integer userId, Integer movieId, String commentText) {
        this.userId = userId;
        this.movieId = movieId;
        this.commentText = commentText;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}
