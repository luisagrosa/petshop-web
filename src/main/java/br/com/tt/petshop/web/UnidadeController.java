package br.com.tt.petshop.web;


import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.service.UnidadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class UnidadeController {

    private UnidadeService unidadeService;

    public UnidadeController(UnidadeService unidadeService) {
        this.unidadeService = unidadeService;
    }

    @GetMapping("/admin/unidades")
    public String listar(Model model){

        //Unidade unidade = new Unidade(1L, "Cantinho do Pet", "Borges de Medeiros, 24");
        //model.addAttribute("unidades", Arrays.asList(unidade));

        model.addAttribute("unidades",unidadeService.listar());
        return "unidades-page";
    }

    private final static Logger LOG = LoggerFactory.getLogger(UnidadeController.class);

    @PostMapping("/actions/criar-unidade")
    public String criar(Unidade unidadeCriacao, RedirectAttributes attributes){

    try {
        unidadeService.criar(unidadeCriacao);
        attributes.addFlashAttribute("mensagem", "Unidade Criada com sucesso");
    }
    catch(Exception e){
        LOG.error("Ocorreum um erro", e);
        String erro = String.format("Ocorreu um erro: %s", e.getMessage());
        attributes.addFlashAttribute("erro", erro);
    }
        return "redirect:/admin/unidades"; // o spring disse que quando queremos fazer um redirecionamento, usa-se assim. Ele vai retornar para o método listar

    }

    @PostMapping("/actions/editar-unidade")
    public String editar(Unidade unidadeEdição, RedirectAttributes attributes){

        try {
            unidadeService.editar(unidadeEdição);
            attributes.addFlashAttribute("mensagem", "Unidade editada com sucesso");
        }
        catch(Exception e){
            LOG.error("Ocorreu um erro", e);
            String erro = String.format("Ocorreu um erro: %s", e.getMessage());
            attributes.addFlashAttribute("erro", erro);
        }
        return "redirect:/admin/unidades";
    }

    @PostMapping("/actions/deletar-unidade")
    public String deletar(Unidade unidadeParaDeletar){
        unidadeService.deletar(unidadeParaDeletar);
        return "redirect:/admin/unidades";
    }


}
