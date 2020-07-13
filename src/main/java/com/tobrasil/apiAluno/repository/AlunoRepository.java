package com.tobrasil.apiAluno.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tobrasil.apiAluno.model.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Long>{
	List<Aluno> findByNomeIgnoreCaseContaining(String nome);
}
