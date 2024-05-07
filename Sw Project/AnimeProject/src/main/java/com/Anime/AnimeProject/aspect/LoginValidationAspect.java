package com.Anime.AnimeProject.aspect;


import com.Anime.AnimeProject.Login.LoginRequest;
import jakarta.validation.ValidationException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginValidationAspect {

    @Before("execution(* com.Anime.AnimeProject.Controller.ViewerController.loginUser(..)) && args(loginRequest)")
    public void validateLoginRequest(LoginRequest loginRequest) {
        if (loginRequest.getEmail().isEmpty() || loginRequest.getPassword().isEmpty()) {
            throw new ValidationException("Username and password are required");
        }
    }
}