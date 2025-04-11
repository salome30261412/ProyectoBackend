package com.parqueadero.backend.controller;

import com.parqueadero.backend.dto.SalidaVehiculoDTO;
import com.parqueadero.backend.dto.VehiculoDTO;
import com.parqueadero.backend.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    @Autowired
    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @PostMapping("/ingreso")
    public ResponseEntity<VehiculoDTO> registrarIngreso(@RequestBody VehiculoDTO dto) {
        VehiculoDTO respuesta = vehiculoService.registrarIngreso(dto);
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping("/salida")
    public ResponseEntity<Map<String, Object>> registrarSalida(@RequestBody SalidaVehiculoDTO dto) {
        Map<String, Object> resultado = vehiculoService.registrarSalida(dto.getPlaca());
        return ResponseEntity.ok(resultado);
    }
    @GetMapping("/parqueadero")
    public ResponseEntity<List<VehiculoDTO>> obtenerVehiculosEnParqueadero() {
        return ResponseEntity.ok(vehiculoService.obtenerVehiculosEnParqueadero());
    }

    @GetMapping("/todos")
    public ResponseEntity<List<VehiculoDTO>> listarTodosLosVehiculos() {
        return ResponseEntity.ok(vehiculoService.listarVehiculos());
    }


}

