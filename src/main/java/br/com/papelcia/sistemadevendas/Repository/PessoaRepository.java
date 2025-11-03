package br.com.papelcia.sistemadevendas.Repository;

import br.com.papelcia.sistemadevendas.Model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}