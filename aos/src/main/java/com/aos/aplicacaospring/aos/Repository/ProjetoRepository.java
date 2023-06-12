package com.aos.aplicacaospring.aos.Repository;

import com.aos.aplicacaospring.aos.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
