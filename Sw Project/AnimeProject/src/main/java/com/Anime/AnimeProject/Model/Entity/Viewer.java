package com.Anime.AnimeProject.Model.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Table(name="viewer")
@Entity
@Data
@Builder
public class Viewer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(unique = true ,nullable = false)
    private String email;
    @Column(nullable = false)
    private String  password;
    @Column(columnDefinition = "JSON")
    private String add_movie_list;
    private byte[] image;

    public Viewer() {
    }


    public Viewer(Integer id, String name, String email, String password, String add_movie_list, byte [] image) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.add_movie_list = add_movie_list;
        this.image=image;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdd_movie_list() {
        return add_movie_list;
    }

    public void setAdd_movie_list(String add_movie_list) {
        this.add_movie_list = add_movie_list;
    }
}
