package com.tobrasil.apiAluno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobrasil.apiAluno.handler.ResourceNotFoundException;
import com.tobrasil.apiAluno.model.Aluno;
import com.tobrasil.apiAluno.repository.AlunoRepository;


@RestController
@RequestMapping("alunos")
public class AlunoController {
	
	private final AlunoRepository alunoRepository;
	
	@Autowired
	public AlunoController(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository; }
	 

	@GetMapping
	public ResponseEntity<?> listAll(){
		
		return new ResponseEntity<>(alunoRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getAlunoById(@PathVariable("id") Long id){
		
		verifyIfAlunoExists(id);
		return new ResponseEntity<>(alunoRepository.findById(id), HttpStatus.OK);
	}
	
	
	  @GetMapping(path = "/findByNome/{nome}") public ResponseEntity<?>
	  findAlunoByName(@PathVariable String nome){ return new
	  ResponseEntity<>(alunoRepository.findByNomeIgnoreCaseContaining(nome), HttpStatus.OK); }
	 
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Aluno aluno){
		return new ResponseEntity<>(alunoRepository.save(aluno), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		
		verifyIfAlunoExists(id);
		alunoRepository.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Aluno aluno){
		
		verifyIfAlunoExists(aluno.getId());
		return new ResponseEntity<>(alunoRepository.save(aluno), HttpStatus.OK);
	}
	
	public void verifyIfAlunoExists(Long id) {
		if (!alunoRepository.existsById(id))
			throw new ResourceNotFoundException("Aluno nao encontrado");
	}
}
