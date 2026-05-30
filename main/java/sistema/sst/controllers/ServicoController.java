package sistema.sst.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

import org.springframework.ui.Model;
import sistema.sst.models.Servico;
import sistema.sst.services.ServicoService;

@Controller
@RequestMapping("/servicos")
@RequiredArgsConstructor
public class ServicoController {

    private final ServicoService servicoService;

    @GetMapping
    public String listar(Model model){
        model.addAttribute("servicos", servicoService.listarTodos());
        return "servicos/lista";
    }

    @GetMapping("/novo")
    public String cadastrar(Model model){
        model.addAttribute("servico", new Servico());
        return "servicos/formulario";
    }

    @PostMapping
    public String salvar(@ModelAttribute Servico servico){
        servicoService.salvar(servico);
        return "redirect:/lista-servicos";
    }
}
