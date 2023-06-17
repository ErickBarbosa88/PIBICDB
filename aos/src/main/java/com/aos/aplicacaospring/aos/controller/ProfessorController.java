package com.aos.aplicacaospring.aos.controller;
import com.aos.aplicacaospring.aos.Repository.ProfessorRepository;
import com.aos.aplicacaospring.aos.model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/professor")
public class ProfessorController {
    @Autowired
    ProfessorRepository professorRepository;

    @GetMapping
    public ResponseEntity<List<Professor>> getAllProfessor(){
        List<Professor> professores = professorRepository.findAll();
        if(!professores.isEmpty()){
            return ResponseEntity.ok(professores);
        }
            return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable Long id){
        Optional<Professor> professor = professorRepository.findById(id);
        if(professor.isPresent()){
            return ResponseEntity.ok(professor.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Professor> createProfessor (@RequestBody Professor professor){
        Professor newProfessor = professorRepository.save(professor);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProfessor);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable Long id, @RequestBody Professor professor) {
        Optional<Professor> existingProfessor = professorRepository.findById(id);

        if (existingProfessor.isPresent()) {
            Professor updatedProfessor = existingProfessor.get();
            updatedProfessor.setEmail(professor.getEmail());
            updatedProfessor.setNome(professor.getNome());
            updatedProfessor.setTitulacao(professor.getTitulacao());
            updatedProfessor.setMatricula(professor.getMatricula());
            updatedProfessor.setCpf(professor.getCpf());
            updatedProfessor.setCurso(professor.getCurso());
            updatedProfessor.setTelefone(professor.getTelefone());


            Professor savedProfessor = professorRepository.save(updatedProfessor);
            return ResponseEntity.ok(savedProfessor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject (@PathVariable Long id) {
        Optional<Professor> existingProfessor = professorRepository.findById(id);
        if(existingProfessor.isPresent()){
            professorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
            return ResponseEntity.notFound().build();
    }

}