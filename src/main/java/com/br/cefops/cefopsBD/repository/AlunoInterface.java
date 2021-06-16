package com.br.cefops.cefopsBD.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.br.cefops.cefopsBD.domain.Alunos;

public interface AlunoInterface extends  JpaRepository<Alunos,Integer> {

}
