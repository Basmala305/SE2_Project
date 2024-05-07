package com.Anime.AnimeProject.aspect;


import com.Anime.AnimeProject.exception.BaseException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserServiceErrorHandlingAspect {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceErrorHandlingAspect.class);

    @AfterThrowing(pointcut = "execution(* com.Anime.AnimeProject.Services.ViewerService.*(..))", throwing = "ex")
    public void handleExceptions(BaseException ex) {
        logException(ex);
        // Perform additional error handling if needed
    }

    private void logException(BaseException ex) {
        logger.error("Error occurred: " + ex.getErrorMessage(), ex);
    }
}