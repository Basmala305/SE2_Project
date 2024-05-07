package com.Anime.AnimeProject.aspect;

import com.Anime.AnimeProject.Model.Entity.Viewer;
import com.Anime.AnimeProject.Repository.ViewerRepository;
import jakarta.validation.ValidationException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class InputValidationAspect {
    @Autowired
    private ViewerRepository viewerRepository;
    @Before("execution(* com.Anime.AnimeProject.Controller.ViewerController.registerUser(..)) && args(user)")
    public void validateUserInput(Viewer user) {
        if (user.getName().length() < 3) {
            throw new ValidationException("Username must be at least 3 characters long");
        }

        if (!user.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new ValidationException("Invalid email format");
        }

        if (user.getPassword().length() < 8) {
            throw new ValidationException("Password must be at least 8 characters long");
        }


        if (viewerRepository.findByEmail(user.getEmail()) != null) {
            throw new ValidationException("Email already exists");
        }
    }
}
