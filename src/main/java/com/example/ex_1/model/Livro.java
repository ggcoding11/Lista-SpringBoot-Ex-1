package com.example.ex_1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="coluna_titulo")
    private String titulo;

    @Column(name="coluna_autor")
    private String autor;

    @Column(name="coluna_ano_publicacao")
    private Integer anoPublicacao;
}
