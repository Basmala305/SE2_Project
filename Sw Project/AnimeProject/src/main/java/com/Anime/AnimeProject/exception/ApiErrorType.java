package com.Anime.AnimeProject.exception;

public interface ApiErrorType<E extends Enum<E>> {

    String getErrorMessage();
    Integer getErrorCode();
}
