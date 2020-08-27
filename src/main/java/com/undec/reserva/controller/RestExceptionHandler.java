package com.undec.reserva.controller;

import com.undec.reserva.dto.Response;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice(basePackages = "com.undec.reserva.controller")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Response> handleEntityNotFound(EntityNotFoundException e) {
        Response response = new Response();
        response.setStatus(100);
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
}

    @ExceptionHandler(NullPointerException.class)
    protected ResponseEntity<Response> handleNullPointerException(NullPointerException e) {
        Response response = new Response();
        response.setStatus(200);
        response.setMessage("Error de tipo: NullPointerException");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
