package re.dgnl.it211_session14_hackathon.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandle{
    @ExceptionHandler(PostNotFoundException.class)
    public String handlePostNotFoundException (PostNotFoundException ex) {
        return ex.getMessage();
    }
}
