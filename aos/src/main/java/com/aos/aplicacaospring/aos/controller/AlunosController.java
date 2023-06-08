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
   
    @GetMapping("/")
    public List<Alunos> listar(){

        return alunoRepository.findAll();
    }
    @PostMapping("/create")
    public Alunos criar (@RequestBody Alunos alunos){
        return alunoRepository.save(alunos);
    }


    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editar(@PathVariable Long id, @RequestBody Alunos alunoAtualizado) {
        Optional<Alunos> alunoExistente = alunoRepository.findById(id);

        if (alunoExistente.isPresent()) {
            Alunos aluno = alunoExistente.get();
            aluno.setNome(alunoAtualizado.getNome());
            aluno.setNome(alunoAtualizado.getEmail());

            alunoRepository.save(aluno);

            return new ResponseEntity<>("Aluno atualizado com sucesso", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Aluno não encontrado", HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity<String> delete (@RequestParam Long id) {
        alunoRepository.deleteById(id);
        return new ResponseEntity<String>("Aluno deletado com sucesso", HttpStatus.OK);
    }
}
