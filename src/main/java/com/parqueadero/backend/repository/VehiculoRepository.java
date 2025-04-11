package com.parqueadero.backend.repository;

import com.parqueadero.backend.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    Optional<Vehiculo> findByPlaca(String placa); // 

	
}
