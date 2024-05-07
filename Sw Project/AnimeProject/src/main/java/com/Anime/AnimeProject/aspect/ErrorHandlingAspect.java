package com.Anime.AnimeProject.aspect;
import com.Anime.AnimeProject.exception.BaseException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ErrorHandlingAspect {

    private static final Logger logger = LoggerFactory.getLogger(ErrorHandlingAspect.class);

    @AfterThrowing(pointcut = "execution(* com.Anime.AnimeProject.Services.*.*(..))", throwing = "ex")
    public void handleServiceExceptions(BaseException ex) {
        logException(ex);
        // Perform additional error handling if needed
    }

    @AfterThrowing(pointcut = "execution(* com.Anime.AnimeProject.Controller.*.*(..))", throwing = "ex")
    public void handleControllerExceptions(BaseException ex) {
        logException(ex);
        // Perform additional error handling if needed
    }

    private void logException(BaseException ex) {
        logger.error("Error occurred: " + ex.getErrorMessage(), ex);
    }
}
