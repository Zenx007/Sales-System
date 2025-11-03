package br.com.papelcia.sistemadevendas.Controller;

import br.com.papelcia.sistemadevendas.Model.Funcionario;
import br.com.papelcia.sistemadevendas.Repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping
    public String listarFuncionarios(Model model) {
        List<Funcionario> listaDeFuncionarios = funcionarioRepository.findAll();
        model.addAttribute("funcionarios", listaDeFuncionarios);
        return "listarfuncionarios";
    }


    @GetMapping("/novo")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "formfuncionario";
    }


    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable("id") Integer id, Model model) {
        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);
        if (funcionarioOptional.isPresent()) {
            model.addAttribute("funcionario", funcionarioOptional.get());
        } else {
            return "redirect:/funcionarios";
        }
        return "formfuncionario";
    }

    @PostMapping("/salvar")
    public String salvarFuncionario(@ModelAttribute("funcionario") Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
        return "redirect:/funcionarios";
    }
}