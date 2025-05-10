package com.parqueadero.backend.dto;

import java.time.LocalDateTime;

public class VehiculoDTO {
    private String placa;
    private String tipo;
    private String horaIngreso; // ✅ agrega este campo

    public VehiculoDTO() {}

    public VehiculoDTO(String placa, String tipo, String horaIngreso) {
        this.placa = placa;
        this.tipo = tipo;
        this.horaIngreso = horaIngreso;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(String horaIngreso) {
        this.horaIngreso = horaIngreso;
    }
}
