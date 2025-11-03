package br.com.papelcia.sistemadevendas.Controller;

import br.com.papelcia.sistemadevendas.Model.Cliente;
import br.com.papelcia.sistemadevendas.Model.Funcionario;
import br.com.papelcia.sistemadevendas.Model.Produto;
import br.com.papelcia.sistemadevendas.Model.Venda;
import br.com.papelcia.sistemadevendas.Repository.ClienteRepository;
import br.com.papelcia.sistemadevendas.Repository.FuncionarioRepository;
import br.com.papelcia.sistemadevendas.Repository.ProdutoRepository;
import br.com.papelcia.sistemadevendas.Repository.VendaRepository;
import br.com.papelcia.sistemadevendas.Service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/vendas")
public class VendaController {

    @Autowired private VendaService vendaService;
    @Autowired private VendaRepository vendaRepository;
    @Autowired private ProdutoRepository produtoRepository;
    @Autowired private ClienteRepository clienteRepository;
    @Autowired private FuncionarioRepository funcionarioRepository;

    /**
     * Lista todas as Vendas (Dia 07) [cite: 1640-1684, 1775-1781]
     */
    @GetMapping
    public String listarVendas(Model model) {
        List<Venda> listaDeVendas = vendaRepository.findAll();
        model.addAttribute("vendas", listaDeVendas);
        return "listarvendas"; // /WEB-INF/jsp/listarvendas.jsp
    }

    /**
     * Mostra o formulário de Venda (Dia 12) [cite: 1367-1372]
     */
    @GetMapping("/nova")
    public String mostrarFormularioVenda(Model model) {
        // Envia um objeto Venda vazio
        model.addAttribute("venda", new Venda());

        // Envia as listas para os dropdowns
        List<Produto> listaDeProdutos = produtoRepository.findAll();
        List<Cliente> listaDeClientes = clienteRepository.findAll();
        List<Funcionario> listaDeFuncionarios = funcionarioRepository.findAll();

        model.addAttribute("todosProdutos", listaDeProdutos);
        model.addAttribute("todosClientes", listaDeClientes);
        model.addAttribute("todosFuncionarios", listaDeFuncionarios);

        return "formvenda"; // /WEB-INF/jsp/formvenda.jsp
    }

    /**
     * Salva a Venda (Dia 12) [cite: 1377-1416]
     */
    @PostMapping("/salvar")
    public String salvarVenda(@ModelAttribute("venda") Venda venda, RedirectAttributes redirectAttributes) {
        try {
            vendaService.realizarVenda(venda);
            redirectAttributes.addFlashAttribute("mensagemSucesso", "Venda realizada com sucesso!");
        } catch (Exception e) {
            // Se der erro (ex: estoque), volta ao form com a mensagem [cite: 1409-1411]
            redirectAttributes.addFlashAttribute("mensagemErro", e.getMessage());
        }
        return "redirect:/vendas/nova";
    }
}