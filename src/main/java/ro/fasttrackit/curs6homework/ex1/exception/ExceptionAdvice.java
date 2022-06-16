package ro.fasttrackit.curs6homework.ex1.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    ApiError handleResourceNotFound(ProductNotFoundException ex) {
        return new ApiError("ERROR", ex.getMessage());
    }

    @ExceptionHandler(InvalidProductFoundException.class)
    @ResponseStatus(BAD_REQUEST)
    ApiError handleResourceNotFound(InvalidProductFoundException ex) {
        return new ApiError("ERROR", ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    ApiError handleAllExceptions(Exception ex) {
        log.error("Generic error", ex);
        return new ApiError("GENERIC ERROR", "Internal error occurred. Please check logs");
    }
}

record ApiError(String code, String message) {
}
