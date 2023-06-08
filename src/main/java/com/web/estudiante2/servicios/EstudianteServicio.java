
package com.web.estudiante2.servicios;

import com.web.estudiante2.entidades.Estudiante;
import java.util.List;


public interface EstudianteServicio {
    
    
    /// metodo de la interfaz para listar estudiantes
    public List<Estudiante> listarTodosLosEstudiantes();
    
    /// metodo de la interfaz para guardar el  estudiante
    public Estudiante guardarEstudiante(Estudiante estudiante);
    
    /// obtenr estudiante por id
    public Estudiante obtenerEstudiantePorId(String id);
    
    /// actulizar estudiante
    public Estudiante actulizarEstudiante(Estudiante estudiante);
    
    /// Eliminar estudiante
    public void eliminarEstudiante(String id);
    
}
