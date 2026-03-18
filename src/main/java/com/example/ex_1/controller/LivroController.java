package com.example.lista_exercicios.controller;

import com.example.lista_exercicios.model.Livro;
import com.example.lista_exercicios.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroService service;

    @GetMapping
    public ResponseEntity<List<Livro>> listarTodos() {
        List<Livro> request = service.listarTodos();

        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public Optional<Livro> listarPorId(@PathVariable Long id){
        return service.listarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody Livro livro){
        Livro request = service.cadastrar(livro);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getId()).toUri();

        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarLivro(@PathVariable Long id){
        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
