package com.Anime.AnimeProject.Repository;

import com.Anime.AnimeProject.Model.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
