package com.example.lista_exercicios.service;

import com.example.lista_exercicios.model.Livro;
import com.example.lista_exercicios.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    @Autowired
    private LivroRepository repository;

    public List<Livro> listarTodos() {
        return repository.findAll();
    }

    public Optional<Livro> listarPorId(Long id) {
        return repository.findById(id);
    }

    public Livro cadastrar(Livro livro) {
        return repository.save(livro);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
