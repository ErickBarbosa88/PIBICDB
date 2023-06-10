package com.aos.aplicacaospring.aos.controller;

import com.aos.aplicacaospring.aos.Repository.ProfessorRepository;
import com.aos.aplicacaospring.aos.model.Alunos;
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

    @GetMapping("/")
    public List<Professor> listar(){

        return professorRepository.findAll();
    }
    @PostMapping("/create")
    public Professor criar (@RequestBody Professor professor){
        return professorRepository.save(professor);

    }


    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editar(@PathVariable Long id, @RequestBody Professor professorAtualizado) {
        Optional<Professor> professorExistente = professorRepository.findById(id);

        if (professorExistente.isPresent()) {
            Professor professor = professorExistente.get();
            professor.setNome(professorAtualizado.getNome());
            professor.setNome(professorAtualizado.getEmail());

            professorRepository.save(professor);

            return new ResponseEntity<>("Professor atualizado com sucesso", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Professor não encontrado", HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity<String> delete (@RequestParam Long id) {
        professorRepository.deleteById(id);
        return new ResponseEntity<String>("Aluno deletado com sucesso", HttpStatus.OK);
    }
}
