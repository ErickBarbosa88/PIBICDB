package com.aos.aplicacaospring.aos.controller;

import com.aos.aplicacaospring.aos.Repository.AlunoRepository;
import com.aos.aplicacaospring.aos.model.Alunos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/alunos")
public class AlunosController {

    @Autowired
    AlunoRepository alunoRepository;

    @GetMapping()
    public List<Alunos> listar() {
        return alunoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alunos> getAlunoById(@PathVariable Long id) {
        Optional<Alunos> alunos = alunoRepository.findById(id);
        return alunos.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alunos> createAluno(@RequestBody Alunos alunos) {
        Alunos newAluno = alunoRepository.save(alunos);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAluno);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Alunos> updateAluno(@PathVariable Long id, @RequestBody Alunos aluno) {
        Optional<Alunos> existingAluno = alunoRepository.findById(id);

        if (existingAluno.isPresent()) {
           Alunos updateAluno = existingAluno.get();

            updateAluno.setNome(aluno.getNome());
            updateAluno.setMatricula(aluno.getMatricula());
            updateAluno.setCpf(aluno.getCpf());
            updateAluno.setRg(aluno.getRg());
            updateAluno.setTelefone(aluno.getTelefone());
            updateAluno.setCurso(aluno.getCurso());
            updateAluno.setEmail(aluno.getEmail());
            updateAluno.setEmailProfessor(aluno.getEmailProfessor());
            updateAluno.setCurriculo(aluno.getCurriculo());

            Alunos savedAluno = alunoRepository.save(updateAluno);
            return ResponseEntity.ok(savedAluno);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno (@PathVariable Long id) {
        Optional<Alunos> existingAluno = alunoRepository.findById(id);
        if(existingAluno.isPresent()){
            alunoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
