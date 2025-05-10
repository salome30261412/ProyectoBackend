package com.parqueadero.backend.service;


import com.parqueadero.backend.dto.VehiculoDTO;
import java.util.Map;

import java.util.List;

public interface VehiculoService {
    VehiculoDTO registrarIngreso(VehiculoDTO dto);
    Map<String, Object> registrarSalida(String placa);
    List<VehiculoDTO> obtenerVehiculosEnParqueadero();
    List<VehiculoDTO> listarVehiculos();
    VehiculoDTO buscarVehiculo(String placa);
}