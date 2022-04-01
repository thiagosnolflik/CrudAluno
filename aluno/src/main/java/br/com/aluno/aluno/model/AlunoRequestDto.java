package br.com.aluno.aluno.model;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoRequestDto {
  
  private Long id;

  @NotBlank(message = "Não pode ficar vazio")
  private String nome;
  
  @NotBlank(message = "Não pode ficar vazio")
  private String matricula;
  
  @NotBlank(message = "Não pode ficar vazio")
  private String sexo;
  
  @NotBlank(message = "Não pode ficar vazio")
  private Long idade;
  
  @NotBlank(message = "Não pode ficar vazio")
  private String endereco;

}
