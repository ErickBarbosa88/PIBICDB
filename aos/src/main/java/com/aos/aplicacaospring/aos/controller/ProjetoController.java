package com.aos.aplicacaospring.aos.controller;
import com.aos.aplicacaospring.aos.Repository.ProjetoRepository;
import com.aos.aplicacaospring.aos.model.Projeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/projeto")
public class ProjetoController {
    @Autowired
    ProjetoRepository projetoRepository;

    @GetMapping
    public ResponseEntity<List<Projeto>> getAllProjects(){
        List<Projeto> projetos = projetoRepository.findAll();
        if(!projetos.isEmpty()){
            return ResponseEntity.ok(projetos);
        }
            return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> getProjectById(@PathVariable Long id){
        Optional<Projeto> projeto = projetoRepository.findById(id);
        if(projeto.isPresent()){
            return ResponseEntity.ok(projeto.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Projeto> createProject (@RequestBody Projeto projeto){
        Projeto newProject = projetoRepository.save(projeto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProject);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Projeto> updateProject(@PathVariable Long id, @RequestBody Projeto projeto) {
        Optional<Projeto> existingProject = projetoRepository.findById(id);

        if (existingProject.isPresent()) {
            Projeto updatedProject = existingProject.get();
            updatedProject.setNome(projeto.getNome());
            updatedProject.setDescricao(projeto.getDescricao());
            updatedProject.setProfessor(projeto.getProfessor());

            Projeto savedProject = projetoRepository.save(updatedProject);
            return ResponseEntity.ok(savedProject);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject (@PathVariable Long id) {
        Optional<Projeto> existingProject = projetoRepository.findById(id);
        if(existingProject.isPresent()){
            projetoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
            return ResponseEntity.notFound().build();
    }

}
