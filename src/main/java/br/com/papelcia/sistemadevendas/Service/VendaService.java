package br.com.papelcia.sistemadevendas.Service;

import br.com.papelcia.sistemadevendas.Model.Cliente;
import br.com.papelcia.sistemadevendas.Model.Funcionario;
import br.com.papelcia.sistemadevendas.Model.Produto;
import br.com.papelcia.sistemadevendas.Model.Venda;
import br.com.papelcia.sistemadevendas.Repository.ClienteRepository;
import br.com.papelcia.sistemadevendas.Repository.FuncionarioRepository;
import br.com.papelcia.sistemadevendas.Repository.ProdutoRepository;
import br.com.papelcia.sistemadevendas.Repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    /**
     * Executa a lógica de venda do Dia 12
     * @Transactional garante que ou tudo (Update Estoque + Insert Venda) funciona,
     * ou tudo é revertido (rollback) em caso de erro.
     */
    @Transactional
    public void realizarVenda(Venda venda) throws Exception {

        // 1. Validar e carregar o Produto (Verificar estoque) [cite: 1347-1363, 1388-1390]
        Optional<Produto> produtoOpt = produtoRepository.findById(venda.getProduto().getId_produto());
        if (produtoOpt.isEmpty()) {
            throw new Exception("Produto não encontrado.");
        }
        Produto produto = produtoOpt.get();

        // 2. Carregar Cliente e Funcionario (para garantir que os objetos estão completos)
        Optional<Cliente> clienteOpt = clienteRepository.findById(venda.getCliente().getId_pessoa());
        Optional<Funcionario> funcionarioOpt = funcionarioRepository.findById(venda.getFuncionario().getId_pessoa());

        if (clienteOpt.isEmpty() || funcionarioOpt.isEmpty()) {
            throw new Exception("Cliente ou Funcionário não encontrado.");
        }

        // 3. Verificar se há estoque suficiente [cite: 1390]
        if (produto.getEstoque() < venda.getQuantidade()) {
            throw new Exception("Estoque insuficiente. Restam apenas " + produto.getEstoque() + " unidades.");
        }

        // 4. Reduzir o estoque [cite: 1335-1346, 1406]
        produto.setEstoque(produto.getEstoque() - venda.getQuantidade());
        produtoRepository.save(produto);

        // 5. Salvar a Venda [cite: 1313-1329, 1405]
        venda.setProduto(produto); // Seta o objeto completo
        venda.setCliente(clienteOpt.get()); // Seta o objeto completo
        venda.setFuncionario(funcionarioOpt.get()); // Seta o objeto completo
        venda.setData_venda(new Date()); // Define a data da venda [cite: 1397]

        vendaRepository.save(venda);
    }
}