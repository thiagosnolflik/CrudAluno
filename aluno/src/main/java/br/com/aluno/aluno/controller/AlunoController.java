package br.com.aluno.aluno.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.aluno.aluno.model.Aluno;
import br.com.aluno.aluno.model.AlunoRequestDto;
import br.com.aluno.aluno.service.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
  
  @Autowired
  AlunoService alunoService;

  @GetMapping
  public ResponseEntity<List<Aluno>> index() throws Exception {
    return ResponseEntity.ok(alunoService.listarAlunos());
  }

  @GetMapping("/{matricula}")
  public ResponseEntity<Aluno> buscarAluno(@PathVariable String matricula) throws Exception {
    return ResponseEntity.ok(alunoService.buscarAluno(matricula));
  }

  @PostMapping
  public ResponseEntity<Aluno> criarAluno(@RequestBody AlunoRequestDto dto) throws Exception {
    return ResponseEntity.ok(alunoService.salvarAluno(mapper(dto)));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> buscarAluno(@PathVariable Long id) throws Exception {
    return ResponseEntity.ok(alunoService.deletarAluno(id));
  }

  public Aluno mapper(AlunoRequestDto dto) {
    return new Aluno(dto.getId(), dto.getNome(), dto.getMatricula(), dto.getSexo(), dto.getIdade(), dto.getEndereco());
  }

}
