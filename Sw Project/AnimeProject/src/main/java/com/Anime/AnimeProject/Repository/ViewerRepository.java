package com.Anime.AnimeProject.Repository;

import com.Anime.AnimeProject.Model.Entity.Viewer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViewerRepository extends JpaRepository<Viewer,Integer>{

    Viewer findByEmailAndPassword(String email, String password);
    Viewer findByEmail(String email);






}
