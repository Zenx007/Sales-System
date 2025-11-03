package br.com.papelcia.sistemadevendas.Repository;

import br.com.papelcia.sistemadevendas.Model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Integer> {
}