package br.com.aluno.aluno.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.aluno.aluno.model.Aluno;
import br.com.aluno.aluno.repository.AlunoRepository;

@Service
public class AlunoService {

  @Autowired
  AlunoRepository alunoRepository;

  public List<Aluno> listarAlunos() throws Exception {
    try {
      return alunoRepository.findAll();
    } catch(Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public Aluno salvarAluno(Aluno aluno) throws Exception {
    try {
      return alunoRepository.save(aluno);
    } catch(Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public String deletarAluno(Long id) throws Exception {
    try {
      Optional<Aluno> aluno = alunoRepository.findById(id);

      if(aluno.isPresent()) {
        alunoRepository.deleteById(id);
        return "Aluno removido com successo";
      } else {
        return "Não foi possível remover o aluno";
      }
    } catch(Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public Aluno buscarAluno(String matricula) throws Exception {
    try {
      return alunoRepository.findByMatricula(matricula);
    } catch(Exception e) {
      throw new Exception(e.getMessage());
    }
  }

}
