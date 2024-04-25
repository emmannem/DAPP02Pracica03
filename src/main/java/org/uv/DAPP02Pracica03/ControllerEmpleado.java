/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package org.uv.DAPP02Pracica03;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author JMRes
 */
@RestController
@RequestMapping("/api/empleado")
public class ControllerEmpleado {

    @Autowired
    private RepositoryEmpleado repositoryEmpleado;

    @GetMapping()
    public List<Empleado> list() {
        List<Empleado> lstEmpleado = repositoryEmpleado.findAll();
        return lstEmpleado;
    }

    @GetMapping("/{id}")
    public Object get(@PathVariable Long id) {
        Optional<Empleado> optEmpleado = repositoryEmpleado.findById(id);
        if (optEmpleado.isPresent()) {
            return optEmpleado;
        } else {
            return null;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Object input) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }

}
