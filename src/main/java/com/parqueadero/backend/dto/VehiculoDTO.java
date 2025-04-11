package com.parqueadero.backend.dto;

import java.time.LocalDateTime;

public class VehiculoDTO {
    private String placa;
    private String tipo;
    private LocalDateTime horaIngreso; // ✅ agrega este campo

    public VehiculoDTO() {}

    public VehiculoDTO(String placa, String tipo, LocalDateTime horaIngreso) {
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

    public LocalDateTime getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(LocalDateTime horaIngreso) {
        this.horaIngreso = horaIngreso;
    }
}
