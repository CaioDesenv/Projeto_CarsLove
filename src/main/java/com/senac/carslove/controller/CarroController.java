package com.senac.carslove.controller;

import com.senac.carslove.model.Carro;
import com.senac.carslove.model.Comentarios;
import com.senac.carslove.service.CarroService;
import com.senac.carslove.service.ComentariosService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarroController {

    private List<Carro> listaCarros = new ArrayList<>();
    private List<Comentarios> listaComentarios = new ArrayList<>();

    @Autowired
    CarroService carroService;
    
    @Autowired
    ComentariosService comentariosService;    

    @GetMapping("/") //eh definido a URL que sera chamada
    public String inicio() {
        return "index"; //onde sera apontado o arquivo HTML
    }

    @GetMapping("/inicio") //eh definido a URL que sera chamada
    public String inicio2() {
        //return "redirect:/";
        return "index"; //onde sera apontado o arquivo HTML
    }

    @GetMapping("/inserir-carro") //eh definido a URL que sera chamada
    public String cadastramento(Model model) {
        model.addAttribute("carro", new Carro());
        return "cadastro"; //onde sera apontado o arquivo HTML
    }

    @PostMapping("/gravar-carro")
    public String salvando(@ModelAttribute Carro carro, Model model) {
        carroService.criar(carro);
        return "redirect:/listagem";
    }

    @GetMapping("/listagem")
    public String listaForm(Model model) {
        model.addAttribute("lista", carroService.listarTodos());
        return "lista"; //onde sera apontado o arquivo HTML
    }

    @GetMapping("/exibir")
    public String mostraDetalhesLivro(Model model, @RequestParam String id) {

        Integer idCarro = Integer.parseInt(id);

        Carro carroEncontrado = new Carro();
        carroEncontrado = carroService.buscarPorId(idCarro);

        List<Comentarios> comentariosEncontrado = new ArrayList<>();
        comentariosEncontrado = comentariosService.listar(idCarro);

        model.addAttribute("carro", carroEncontrado);
        model.addAttribute("comentario", new Comentarios());
        model.addAttribute("comentarios", comentariosEncontrado);
        return "exibir";
    }

    @PostMapping("/gravar-comentario")
    public String gravarComentarioUsuario(@ModelAttribute Carro carro, @ModelAttribute Comentarios comentario, Model model) {
        comentario.setCarro(carro);
        comentariosService.criar(comentario);
        return "redirect:/listagem";
    }

}
