package com.hotel.hotel.controller;

import com.hotel.hotel.model.Empleado;
import com.hotel.hotel.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;


import java.util.List;

@Controller
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping("/empleados")
    public String listarEmpleados(Model model) {
        List<Empleado> empleados = empleadoRepository.listarEmpleados();
        model.addAttribute("empleados", empleados);
        return "empleados";
    }
    
    @GetMapping("/empleados/test")
public ResponseEntity<String> test() {
    empleadoRepository.testConexion();
    return ResponseEntity.ok("Procedimiento ejecutado");
}

    
}
