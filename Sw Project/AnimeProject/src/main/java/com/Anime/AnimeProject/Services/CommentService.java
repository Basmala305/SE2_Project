package com.Anime.AnimeProject.Services;
import com.Anime.AnimeProject.Model.Entity.Comment;
import com.Anime.AnimeProject.Model.Entity.Viewer;
import com.Anime.AnimeProject.Repository.CommentRepository;
import com.Anime.AnimeProject.Repository.ViewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    @Autowired
    private ViewerRepository viewerRepository;
    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment saveComment(Comment comment) {
        Viewer viewer = viewerRepository.findById(comment.getUserId()).orElseThrow(() -> new RuntimeException("Viewer not found"));

        return commentRepository.save(comment);
    }
}
