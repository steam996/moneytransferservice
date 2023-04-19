package ru.netology.moneytransferservice.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> validException (MethodArgumentNotValidException exception){

        String[] messages = exception.getMessage().split(";");
        String message = messages[messages.length-1];
        String defaultMessage = message.substring(message.indexOf("[")+1, message.indexOf("]")-1);
        return new ResponseEntity<String>(defaultMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> httpMesException (HttpMessageNotReadableException exception){
        return new ResponseEntity<String>("Некоректный ввод", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<String> httpReqException (HttpRequestMethodNotSupportedException exception){
        return new ResponseEntity<String>("Server error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
