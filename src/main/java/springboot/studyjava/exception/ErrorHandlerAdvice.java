package springboot.studyjava.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Struct;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandlerAdvice {
    @ExceptionHandler({
            RuntimeException.class
    })
    public ResponseEntity<Map<String, String>> handleGeneralError(RuntimeException e){
        Map<String, String> errors = new HashMap<>();
        errors.put("code", "1500");
        errors.put("message", "General error, internal server Error ");


        return  new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
