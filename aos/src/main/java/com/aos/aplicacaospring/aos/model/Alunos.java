package com.aos.aplicacaospring.aos.model;

//import jakarta.persistence.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "Alunos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Alunos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAluno;

    @Column(name = "nome", length = 200)
    @NotNull
    private String nome;

    @Column(name = "matricula",length = 200)
    @NotNull
    private String matricula;

    @Column(name = "endereco",length = 200)
    @NotNull
    private String endereco;

    @Column(name = "cpf",length = 200)
    @NotNull
    private String cpf;

    @Column(name = "rg",length = 200)
    @NotNull
    private String rg;

    @Column(name = "telefone",length = 200)
    @NotNull
    private String telefone;

    @Column(name = "curso",length = 200)
    @NotNull
    private String curso;

    @Column(name = "email",length = 200)
    @NotNull
    private String email;

    @Column(name = "emailProfessor",length = 200)
    @NotNull
    private String emailProfessor;

    @Column(name = "curriculo",length = 200)
    @NotNull
    private String curriculo;



}

