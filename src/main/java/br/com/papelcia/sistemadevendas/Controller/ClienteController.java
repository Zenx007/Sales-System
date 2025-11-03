package br.com.papelcia.sistemadevendas.Controller;

import br.com.papelcia.sistemadevendas.Model.Cliente;
import br.com.papelcia.sistemadevendas.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public String listarClientes(Model model) {
        List<Cliente> listaDeClientes = clienteRepository.findAll();
        model.addAttribute("clientes", listaDeClientes);
        return "listarclientes"; // /WEB-INF/jsp/listarclientes.jsp
    }

    @GetMapping("/novo")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "formcliente"; // /WEB-INF/jsp/formcliente.jsp
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable("id") Integer id, Model model) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            model.addAttribute("cliente", clienteOptional.get());
        } else {
            return "redirect:/clientes";
        }
        return "formcliente";
    }

    @PostMapping("/salvar")
    public String salvarCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/clientes";
    }
}