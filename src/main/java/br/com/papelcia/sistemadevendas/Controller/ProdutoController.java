package br.com.papelcia.sistemadevendas.Controller;

import br.com.papelcia.sistemadevendas.Model.Produto;
import br.com.papelcia.sistemadevendas.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;


    @GetMapping
    public String listarProdutos(Model model) {
        List<Produto> listaDeProdutos = produtoRepository.findAll();
        model.addAttribute("produtos", listaDeProdutos);
        return "listarprodutos";
    }

    @GetMapping("/novo")
    public String mostrarFormularioCadastro(Model model) {
        // Envia um objeto "produto" novo e vazio para o formulário
        model.addAttribute("produto", new Produto());
        return "formproduto";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable("id") Integer id, Model model) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);

        if (produtoOptional.isPresent()) {
            model.addAttribute("produto", produtoOptional.get());
        } else {
            return "redirect:/produtos";
        }

        return "formproduto";
    }

    /**
     * NOVO MÉTODO (POST para /produtos/salvar)
     * (Substitui o "doPost" para "salvarProduto" e "editarProduto" - Dia 08 e 11)
     [cite_start]* [cite: 2091-2115, 146-156]
     * Recebe os dados do formulário e salva no banco.
     */
    @PostMapping("/salvar")
    public String salvarProduto(@ModelAttribute("produto") Produto produto) {
        // O Spring preenche o objeto "produto" com os dados do formulário

        // O JPA é inteligente: se o ID é nulo ou 0, ele faz um INSERT.
        // Se o ID já existe, ele faz um UPDATE.
        produtoRepository.save(produto);

        // Redireciona de volta para a listagem após salvar
        return "redirect:/produtos";
    }
}