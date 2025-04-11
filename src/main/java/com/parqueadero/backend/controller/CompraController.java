package com.parqueadero.backend.controller;

import com.parqueadero.backend.dto.CompraDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @PostMapping
    public String registrarCompra(@RequestBody CompraDTO compra) {
        return "Compra registrada: " + compra.getProducto() + " por $" + compra.getMonto();
    }
}
