package com.Anime.AnimeProject.Controller;

import com.Anime.AnimeProject.Model.Entity.Viewer;
import com.Anime.AnimeProject.Services.ViewerService;
import com.Anime.AnimeProject.Login.LoginRequest;
import com.Anime.AnimeProject.Login.LoginResponse;
import org.hibernate.annotations.Fetch;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Target;


@RestController
@RequestMapping("/viewers")
public class ViewerController {
    @Autowired
    private ViewerService viewerService;
    @PostMapping("/signup")
    public Viewer registerUser(@RequestBody Viewer user) {
        return viewerService.registerUser(user);
    }

    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody LoginRequest loginRequest) {
        return viewerService.loginUser(loginRequest);
    }

    @GetMapping("/verifyToken")
    public Long verifyToken(@RequestParam("token") String token) {
        return viewerService.verifyToken(token);
    }

//    @PostMapping("/addWithImage")
//    public Viewer addViewerWithImage(@ModelAttribute Viewer viewer, @RequestParam("imageFile") MultipartFile imageFile) throws IOException, IOException {
//        byte[] imageData = imageFile.getBytes();
//        return viewerService.saveViewerWithImage(viewer, imageData);
//    }

    @PostMapping("/{viewerId}/addmovie/{movieId}")
    public ResponseEntity<String> addMovieToViewer(@PathVariable Integer viewerId, @PathVariable Integer movieId) throws JSONException {
        viewerService.addMovieToViewer(viewerId, movieId);
        return ResponseEntity.ok("Movie added to viewer successfully.");
    }
    @DeleteMapping("/{viewerId}/deletemovie/{movieId}")
    public ResponseEntity<String> deleteMovieFromViewer(@PathVariable Integer viewerId, @PathVariable Integer movieId) throws JSONException {
        viewerService.deleteMovieFromViewer(viewerId, movieId);
        return ResponseEntity.ok("Movie deleted from viewer successfully.");
    }
}