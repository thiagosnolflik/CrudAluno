package br.com.aluno.aluno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.aluno.aluno.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
  
  Aluno findByMatricula(String matricula);

}
