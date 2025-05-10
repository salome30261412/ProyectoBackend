package com.parqueadero.backend.repository;

import com.parqueadero.backend.dto.VehiculoDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public class VehiculoRepository {
	
	private List<VehiculoDTO> baseDatos;
	
	public VehiculoRepository() {
		this.baseDatos = new ArrayList<>();
		initData();
	}
	
	private void initData() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fecha = LocalDateTime.now().format(formatter);
		baseDatos.add(new VehiculoDTO("asd123", "moto", fecha));
	}
	
    public VehiculoDTO buscarVehiculo(String placa) { 
    	// (SELECT * FROM vehiculos WHERE placa = :placa)
    	for(VehiculoDTO vehiculo : baseDatos) {
    		if(vehiculo.getPlaca().equals(placa)) {
    			return vehiculo;
    		}
    	}
    	
    	return null;
    }
    
    public List<VehiculoDTO> findAll() {
    	return baseDatos;
    }
    
    public void save(VehiculoDTO vehiculo) {
    	// (INSERT INTO vehiculos (placa, tipo, horaEntrada) VALUES (---))
    	baseDatos.add(vehiculo);
    }
    
    public void delete(VehiculoDTO vehiculo) {
    	if (buscarVehiculo(vehiculo.getPlaca()) != null ) {
        	baseDatos.remove(vehiculo);    		
    	}
    }

	
}