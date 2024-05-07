package com.Anime.AnimeProject.Controller;

import com.Anime.AnimeProject.Model.Entity.Comment;
import com.Anime.AnimeProject.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.saveComment(comment);
    }
}
