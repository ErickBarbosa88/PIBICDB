package com.aos.aplicacaospring.aos.model;

import com.aos.aplicacaospring.aos.model.Professor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Projeto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProjeto")
    private Long idProjeto;

    @Column(name = "nome", length = 200)
    @NotNull
    private String nome;

    @Column(name = "descricao", length = 200)
    @NotNull
    private String descricao;


    @JoinColumn(name = "idProfessor")
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Professor professor;
}
