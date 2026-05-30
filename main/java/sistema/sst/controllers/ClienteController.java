package sistema.sst.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

import org.springframework.ui.Model;
import sistema.sst.models.Cliente;
import sistema.sst.services.ClienteService;


@Controller
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public String listar(Model model){
        model.addAttribute("clientes", clienteService.listarTodos());
        return "clientes/lista";
    }

    @GetMapping("/novo")
    public String cadastrar(Model model){
        model.addAttribute("cliente", new Cliente());
        return "clientes/formulario";
    }
    @PostMapping
    public String salvar(@ModelAttribute Cliente cliente){
        clienteService.salvar(cliente);
        return "redirect:/lista-empresas";
    } 
}
