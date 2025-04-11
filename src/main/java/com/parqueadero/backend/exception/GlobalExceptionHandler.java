package com.parqueadero.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(VehiculoInvalidoException.class)
    public ResponseEntity<String> handleVehiculoInvalido(VehiculoInvalidoException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Puedes manejar más errores aquí
}
