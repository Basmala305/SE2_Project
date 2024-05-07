package com.Anime.AnimeProject.Services;
import com.Anime.AnimeProject.Model.Entity.Movie;
import com.Anime.AnimeProject.Model.Entity.Viewer;
import com.Anime.AnimeProject.Repository.MovieRepository;
import com.Anime.AnimeProject.Repository.ViewerRepository;
import com.Anime.AnimeProject.Login.LoginRequest;
import com.Anime.AnimeProject.Login.LoginResponse;
import com.Anime.AnimeProject.security.JwtTokenProvider;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.regex.Pattern.matches;


@Service
public class ViewerService {

    private final ViewerRepository viewerRepository;
    private final MovieRepository movieRepository;


    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public ViewerService(ViewerRepository viewerRepository, MovieRepository movieRepository) {
        this.viewerRepository = viewerRepository;
        this.movieRepository = movieRepository;

    }
   public Viewer registerUser(Viewer user) {
       return viewerRepository.save(user);
  }


    public LoginResponse loginUser(LoginRequest loginRequest) {
        Viewer user = viewerRepository.findByEmailAndPassword(loginRequest.getEmail(),loginRequest.getPassword());
        if (user != null && matches((loginRequest.getPassword()), user.getPassword())) {
            String token = jwtTokenProvider.generateToken(user);
            return buildLoginResponse("Login Successfully", token);
        } else {
            return buildLoginResponse("Email or Password incorrect", null);
        }
    }
    public Long verifyToken(String token) {
        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("Token is required");
        }
        if (jwtTokenProvider.validateToken(token)) {
            return jwtTokenProvider.getUserIdFromJWT(token);
        } else {
            throw new IllegalArgumentException("Invalid token");
        }
    }


    private LoginResponse buildLoginResponse(String message, String token) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMessage(message);
        loginResponse.setToken(token);
        return loginResponse;
    }
//    public Viewer saveViewerWithImage(Viewer viewer, byte[] imageData) {
//        viewer.setImage(imageData);
//        return viewerRepository.save(viewer);
//    }

    public void addMovieToViewer(Integer viewerId, Integer movieId) throws JSONException {
        Viewer viewer = getViewerById(viewerId);
        Movie movie = getMovieById(movieId);

        JSONArray jsonArray = getMovieListAsJsonArray(viewer);

        JSONObject movieObject = createMovieJsonObject(movie);
        jsonArray.put(movieObject);

        updateViewerMovieList(viewer, jsonArray);
    }

    public void deleteMovieFromViewer(Integer viewerId, Integer movieId) throws JSONException {
        Viewer viewer = getViewerById(viewerId);

        JSONArray jsonArray = getMovieListAsJsonArray(viewer);

        removeMovieFromJsonArray(movieId, jsonArray);

        updateViewerMovieList(viewer, jsonArray);
    }

    private Viewer getViewerById(Integer viewerId) {
        return viewerRepository.findById(viewerId)
                .orElseThrow(() -> new RuntimeException("Viewer not found"));
    }

    private Movie getMovieById(Integer movieId) {
        return movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    private JSONArray getMovieListAsJsonArray(Viewer viewer) throws JSONException {
        String addMovieList = viewer.getAdd_movie_list();
        return addMovieList != null ? new JSONArray(addMovieList) : new JSONArray();
    }

    private JSONObject createMovieJsonObject(Movie movie) throws JSONException {
        JSONObject movieObject = new JSONObject();
        movieObject.put("id", movie.getId());
        movieObject.put("name", movie.getName());
        movieObject.put("likeNumbers", movie.getLike_numbers());
        movieObject.put("rating", movie.getRating());
        movieObject.put("prefix", movie.getPreif());
        return movieObject;
    }

    private void removeMovieFromJsonArray(Integer movieId, JSONArray jsonArray) throws JSONException {
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject movieObject = jsonArray.getJSONObject(i);
            if (movieObject.getInt("id") == movieId) {
                jsonArray.remove(i);
                break;
            }
        }
    }

    private void updateViewerMovieList(Viewer viewer, JSONArray jsonArray) {
        viewer.setAdd_movie_list(jsonArray.toString());
        viewerRepository.save(viewer);
    }
}















