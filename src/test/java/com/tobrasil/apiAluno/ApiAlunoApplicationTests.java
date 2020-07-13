package com.tobrasil.apiAluno;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tobrasil.apiAluno.model.Aluno;
import com.tobrasil.apiAluno.repository.AlunoRepository;

@SpringBootTest
class ApiAlunoApplicationTests {

	// @Test
	// void contextLoads() {
	// }

	@Autowired
	private AlunoRepository alunoRepository;

	@Test
	public void insertData() {
		Aluno aluno = new Aluno("Helder", 39);
		alunoRepository.save(aluno);
		assertNotNull(alunoRepository.findById(aluno.getId()));

	}

	@Test
	public void deleteData() {
		Aluno aluno = new Aluno("Aluno2", 39);
		alunoRepository.save(aluno);
		alunoRepository.delete(aluno);
		Optional<Aluno> optional = alunoRepository.findById(aluno.getId());
		assertFalse(optional.isPresent());
	}
	
	@Test
	public void updateData() {
		Aluno aluno = new Aluno("Aluno3", 39);
		alunoRepository.save(aluno);
		aluno.setNome("NomeAlterado");
		alunoRepository.save(aluno);
		Optional<Aluno> optional = alunoRepository.findById(aluno.getId());
		assertTrue(optional.isPresent());
		assertTrue(optional.get().getNome().equals("NomeAlterado"));
	}

}
