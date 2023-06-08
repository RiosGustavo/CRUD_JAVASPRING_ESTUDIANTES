
package com.web.estudiante2.controladores;

import com.web.estudiante2.entidades.Estudiante;
import com.web.estudiante2.servicios.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class EstudianteControlador {
    
    ///inyectamos el repositorio
    @Autowired
    private EstudianteServicio servicioEstudiante;
    
    /// agregamos una peticion Get
    /// se pueden agregar varias rutas con {"/estudiantes","/"} separadas por ,
    @GetMapping({"/estudiante","/"})
    public String listarEstudiantes(Model modelo){
        
        modelo.addAttribute("estudiantes", servicioEstudiante.listarTodosLosEstudiantes());
        return "estudiante_form.html"; // nos retorna al archivo html estudiantes
        
    }
    /// con este metodo creamos el formulario para reibir los datos
    @GetMapping("/estudiante/registrar")
    public String crearEstudianteFormulario(Model modelo){
        Estudiante  estudiante = new Estudiante();
        
        modelo.addAttribute("estudiante", estudiante); // estamos retornando un objeto estudiante 
                                                      //al formulario para que puedamos asignarle los atributos y persitirlo 
        return "estudiante_registrar.html";
               
    }
    /// con este metodo guardamos el estudiante
    @PostMapping("/estudiante")
    public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante){
        servicioEstudiante.guardarEstudiante(estudiante);
        return "redirect:/estudiante";
    }
    
    //// metodo para obtener el estudiante a modificar
    @GetMapping("/estudiante/modificar/{id}")
    public String formularioEditar(@PathVariable String id,Model modelo ){
        modelo.addAttribute("estudiante", servicioEstudiante.obtenerEstudiantePorId(id));
        return "editar_estudiante.html";
    }
    /// metodo para actualizar el estudiante
    @PostMapping("/estudiante/{id}")
    public String actulizarEstudiante(@PathVariable String id, @ModelAttribute("estudiante") Estudiante estudiante, Model modelo ){
         Estudiante estudianteExistente  = servicioEstudiante.obtenerEstudiantePorId(id);
         estudianteExistente.setId(id);
         estudianteExistente.setNombre(estudiante.getNombre());
         estudianteExistente.setApellido(estudiante.getApellido());
         estudianteExistente.setEmail(estudiante.getEmail());
         
         servicioEstudiante.actulizarEstudiante(estudiante);
         
        return "redirect:/estudiante";
        
    }
    
    //// metodo para eliminar Estudiante
    
    @GetMapping("/estudiante/{id}")
    public String eliminarEstudiante(@PathVariable String id){
        servicioEstudiante.eliminarEstudiante(id);
        return "redirect:/estudiante";
    }
    
    
}
