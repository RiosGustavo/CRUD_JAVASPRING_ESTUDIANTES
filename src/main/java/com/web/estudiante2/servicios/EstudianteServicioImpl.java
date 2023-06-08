package com.web.estudiante2.servicios;

//// va a implementar de EstudianteServicio interfaz
import com.web.estudiante2.entidades.Estudiante;
import com.web.estudiante2.repositorios.EstudianteRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServicioImpl implements EstudianteServicio {

    /// inyectamos el repostorio en esta clase atraves del Autowired
    @Autowired
    private EstudianteRepositorio repositorioEstudiante;

    ////implemanetamos los metodos abastractos 
    /// impelmentmos metodo para listar estudiantes
    @Override
    public List<Estudiante> listarTodosLosEstudiantes() {
        return repositorioEstudiante.findAll();
    }

    /// impelmentmos metodo para guardar estudiantes
    @Override
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return repositorioEstudiante.save(estudiante);
    }
    
    @Override
    public Estudiante obtenerEstudiantePorId(String id) {
        
        return repositorioEstudiante.findById(id).get();
    }
    
    @Override
    public Estudiante actulizarEstudiante(Estudiante estudiante) {
        return repositorioEstudiante.save(estudiante);
    }
    
    @Override
    public void eliminarEstudiante(String id) {
        repositorioEstudiante.deleteById(id);
    }
    
}
