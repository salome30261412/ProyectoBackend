package com.parqueadero.backend.exception;

public class VehiculoInvalidoException extends RuntimeException {
    public VehiculoInvalidoException(String mensaje) {
        super(mensaje);
    }
}
