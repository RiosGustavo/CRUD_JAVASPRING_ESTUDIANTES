
package com.web.estudiante2.repositorios;

import com.web.estudiante2.entidades.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiante, String> {
    
}
