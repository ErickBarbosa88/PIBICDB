package com.aos.aplicacaospring.aos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Projeto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProjeto;

    @Column(name = "nome", length = 200)
    @NotNull
    private String nome;

    @Column(name = "descricao",length = 200)
    @NotNull
    private String descricao;

    @ManyToOne
    @JoinColumn(name="idProfessor")
    private Professor professor;
}
