package com.parqueadero.backend.service.impl;

import com.parqueadero.backend.dto.VehiculoDTO;
import com.parqueadero.backend.entity.Vehiculo;
import com.parqueadero.backend.repository.VehiculoRepository;
import com.parqueadero.backend.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    private static final int COSTO_POR_MINUTO = 100;

  
    @Override
    public VehiculoDTO registrarIngreso(VehiculoDTO dto) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    	VehiculoDTO vehiculo = new VehiculoDTO();
        vehiculo.setPlaca(dto.getPlaca());
        vehiculo.setTipo(dto.getTipo());
        vehiculo.setHoraIngreso(LocalDateTime.now().format(formatter));

        vehiculoRepository.save(vehiculo);

        VehiculoDTO respuesta = new VehiculoDTO();
        respuesta.setPlaca(vehiculo.getPlaca());
        respuesta.setTipo(vehiculo.getTipo());
        respuesta.setHoraIngreso(vehiculo.getHoraIngreso());

        return respuesta;
    }


    @Override
    public Map<String, Object> registrarSalida(String placa) {
        VehiculoDTO vehiculo = vehiculoRepository.buscarVehiculo(placa);

        if (vehiculo == null) {
            throw new RuntimeException("Vehículo no encontrado");
        }

        LocalDateTime horaSalida = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fechaHora = LocalDateTime.parse(vehiculo.getHoraIngreso(), formatter);
        Duration duracion = Duration.between(fechaHora, horaSalida);
        long minutos = duracion.toMinutes();
        long costo = minutos * COSTO_POR_MINUTO;

        Map<String, Object> resultado = new HashMap<>();
        resultado.put("placa", vehiculo.getPlaca());
        resultado.put("tipo", vehiculo.getTipo());
        resultado.put("horaIngreso", vehiculo.getHoraIngreso());
        resultado.put("horaSalida", horaSalida);
        resultado.put("minutos", minutos);
        resultado.put("costo", costo);

        vehiculoRepository.delete(vehiculo); // simula que el vehículo ya salió

        return resultado;
    }
    @Override
    public List<VehiculoDTO> obtenerVehiculosEnParqueadero() {
        List<VehiculoDTO> vehiculos = vehiculoRepository.findAll();
        List<VehiculoDTO> respuesta = new ArrayList<>();

        for (VehiculoDTO vehiculo : vehiculos) {
            VehiculoDTO dto = new VehiculoDTO();
            dto.setPlaca(vehiculo.getPlaca());
            dto.setTipo(vehiculo.getTipo());
            dto.setHoraIngreso(vehiculo.getHoraIngreso());
            respuesta.add(dto);
        }

        return respuesta;
    }
    
    @Override
    public List<VehiculoDTO> listarVehiculos() {
        List<VehiculoDTO> vehiculos = vehiculoRepository.findAll();
        return vehiculos.stream().map(v -> {
            VehiculoDTO dto = new VehiculoDTO();
            dto.setPlaca(v.getPlaca());
            dto.setTipo(v.getTipo());
            dto.setHoraIngreso(v.getHoraIngreso());
            return dto;
        }).collect(Collectors.toList());
    }
    
    @Override
    public VehiculoDTO buscarVehiculo(String placa) {
    	return vehiculoRepository.buscarVehiculo(placa);
    }


}

