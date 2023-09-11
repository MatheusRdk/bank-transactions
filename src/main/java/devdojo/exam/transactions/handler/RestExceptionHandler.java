package devdojo.exam.transactions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(AccessDeniedException.class)
    public ProblemDetail handlerAccessDeniedException() {
        return ProblemDetail.forStatusAndDetail(HttpStatus.FORBIDDEN, "Access denied for this user");
    }
}
