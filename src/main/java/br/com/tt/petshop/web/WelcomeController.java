package br.com.tt.petshop.web;

import br.com.tt.petshop.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller //aqui o controller é uma anotação que diz que essa classe é um controler web.
public class WelcomeController {


    private final WelcomeService welcomeService;//final é pra que só possa ser inicializado uma vez


    public WelcomeController(WelcomeService welcomeservice){
        this.welcomeService = welcomeservice;
    }

    @GetMapping //nao disse em nenhum lugar que quando abrisse o local host era pra abrir
    // o que roda desse codigo aqui. Essa anotação faz isso
    public String ola(Model model){

        model.addAttribute("versao", "v1.0.0.0"+ LocalDateTime.now().toString());

        List<String> notas = Arrays.asList("Criado Controller Welcome", "Criada pagina inicial",
                "usando thymeleaf");

        model.addAttribute("notas", notas);


        return "welcome-page";
    }
}
