package br.com.papelcia.sistemadevendas.Controller;

import br.com.papelcia.sistemadevendas.Model.Pessoa;
import br.com.papelcia.sistemadevendas.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;


    @GetMapping
    public String listarPessoas(Model model) {
        List<Pessoa> listaDePessoas = pessoaRepository.findAll();
        model.addAttribute("pessoas", listaDePessoas);
        return "listarpessoas";
    }
}