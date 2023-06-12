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

    @GetMapping("/")
    public List<Projeto> listar(){

        return projetoRepository.findAll();
    }
    @PostMapping("/create")
    public Projeto criar (@RequestBody Projeto projeto){
        return projetoRepository.save(projeto);
    }


    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editar(@PathVariable Long id, @RequestBody Projeto projetoAtualizado) {
        Optional<Projeto> projetoExistente = projetoRepository.findById(id);

        if (projetoExistente.isPresent()) {
            Projeto projeto = projetoExistente.get();
            projeto.setNome(projetoAtualizado.getNome());
            projeto.setDescricao(projetoAtualizado.getDescricao());
            projeto.setProfessor(projetoAtualizado.getProfessor());

            projetoRepository.save(projeto);

            return new ResponseEntity<>("Projeto foi atualizado com sucesso", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Projeto não foi encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity<String> delete (@RequestParam Long id) {
        projetoRepository.deleteById(id);
        return new ResponseEntity<String>("Projeto deletado com sucesso", HttpStatus.OK);
    }

}
