package com.aos.aplicacaospring.aos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "Professor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProfessor")
    private Long idProfessor;

    @Column(name = "email", length = 200)
    @NotNull
    private String email;

    @Column(name = "nome", length = 200)
    @NotNull
    private String nome;

    @Column(name = "titulacao", length = 200)
    @NotNull
    private String titulacao;

    @Column(name = "matricula", length = 200)
    @NotNull
    private String matricula;

    @Column(name = "cpf", length = 200)
    @NotNull
    private String cpf;

    @Column(name = "curso", length = 200)
    @NotNull
    private String curso;

    @Column(name = "telefone", length = 200)
    @NotNull
    private String telefone;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<Projeto> projetos;
}
