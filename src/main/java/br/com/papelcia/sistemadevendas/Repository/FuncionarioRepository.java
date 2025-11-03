package br.com.papelcia.sistemadevendas.Repository;

import br.com.papelcia.sistemadevendas.Model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}