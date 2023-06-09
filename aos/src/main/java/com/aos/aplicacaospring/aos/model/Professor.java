package com.aos.aplicacaospring.aos.model;

//import jakarta.persistence.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Professor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfessor;

    @Column(name = "email",length = 200)
    @NotNull
    private String email;

    @Column(name = "nome", length = 200)
    @NotNull
    private String nome;

    @Column(name = "titulacao", length = 200)
    @NotNull
    private String titulacao;

    @Column(name = "matricula",length = 200)
    @NotNull
    private String matricula;

    @Column(name = "cpf",length = 200)
    @NotNull
    private String cpf;

    @Column(name = "curso",length = 200)
    @NotNull
    private String curso;

    @Column(name = "telefone",length = 200)
    @NotNull
    private String telefone;

    @Column(name = "tituloDoProjetoDePesquisa",length = 200)
    @NotNull
    private String tituloDoProjetoDePesquisa;

    @Column(name = "areaDeConhecimentoDoCNPqDoProjetoDePesquisa",length = 200)
    @NotNull
    private String areaDeConhecimentoDoCNPqDoProjetoDePesquisa;

    @Column(name = "nomeDoGrupoDePesquisa",length = 200)
    @NotNull
    private String nomeDoGrupoDePesquisa;
}
