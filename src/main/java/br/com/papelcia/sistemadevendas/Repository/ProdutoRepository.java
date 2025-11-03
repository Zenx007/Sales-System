package br.com.papelcia.sistemadevendas.Repository;

import br.com.papelcia.sistemadevendas.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
