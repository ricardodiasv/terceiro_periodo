package com.example.projetoPOO1202401.controller;

import com.example.projetoPOO1202401.entity.Estado;
import com.example.projetoPOO1202401.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class estadocontroller {

    @Autowired
    private EstadoRepository estadoRepository;


    @PostMapping("/estado")
    public ResponseEntity<Estado> cadastrar(@RequestBody Estado estado) {
        return ResponseEntity.status(HttpStatus.OK).body(estadoRepository.save(estado));
    }

    @GetMapping("/estado")
    public ResponseEntity<List<Estado>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(estadoRepository.findAll());
    }

    @GetMapping("estado/{id}")
    public ResponseEntity<Estado> buscarPorId(@PathVariable Long id){

        Optional<Estado> response = estadoRepository.findById(id);
        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/estado/{id}")
    public ResponseEntity<Object> update(@PathVariable(name = "id") Long id) {
        Optional<Estado> teste0 = estadoRepository.findById(id);
        if (teste0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estado não cadastrado");
        }
        var Estado = teste0.get();
        estadoRepository.save(Estado);
        return ResponseEntity.status(HttpStatus.OK).body("estado atualizado");


    }

    @PutMapping()
    public ResponseEntity<Estado> update2(@RequestBody Estado estado){

        return ResponseEntity.ok(estadoRepository.save(estado));
    }

    @DeleteMapping("/estado/{id}")
    public ResponseEntity<Object> deletar(@PathVariable(name = "id") Long id) {
        Optional<Estado> teste0 = estadoRepository.findById(id);
        if (teste0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estado não cadastrado");
        }
        var Estado = teste0.get();
        estadoRepository.delete(Estado);
        return ResponseEntity.status(HttpStatus.OK).body("deletado");
    }
}
