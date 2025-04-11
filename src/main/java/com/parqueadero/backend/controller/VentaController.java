package com.parqueadero.backend.controller;

import com.parqueadero.backend.dto.VentaDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @PostMapping
    public String registrarVenta(@RequestBody VentaDTO venta) {
        return "Venta registrada: " + venta.getCantidad() + " unidad(es) de " + venta.getProducto();
    }
}
