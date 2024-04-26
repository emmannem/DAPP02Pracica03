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
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Empleado> put(@PathVariable Long id, @RequestBody Empleado empleado) {
        Optional<Empleado> dataEmpleado = repositoryEmpleado.findById(id);
        if (dataEmpleado.isPresent()) {
            Empleado _empleado = dataEmpleado.get();
            _empleado.setNombre(empleado.getNombre());
            _empleado.setDireccion(empleado.getDireccion());
            _empleado.setTelefono(empleado.getTelefono());
            repositoryEmpleado.save(_empleado);
            return ResponseEntity.ok().body(_empleado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Empleado> post(@RequestBody Empleado empleado) {
        try {
            Empleado savedEmpleado = repositoryEmpleado.save(empleado);
            return ResponseEntity.ok().body(savedEmpleado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Empleado> delete(@PathVariable Long id) {
        try {
            repositoryEmpleado.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
