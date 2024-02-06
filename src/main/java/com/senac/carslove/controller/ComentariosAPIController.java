
package com.senac.carslove.controller;

import com.senac.carslove.model.Comentarios;
import com.senac.carslove.service.ComentariosService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comentarios")
public class ComentariosAPIController {
    
   @Autowired
   ComentariosService comentariosService;    
    
   @PostMapping("/adicionar")
   public ResponseEntity<Comentarios> addCarro(@RequestBody Comentarios com){
       var novoComentario = comentariosService.criar(com);
       return new ResponseEntity<>(novoComentario, HttpStatus.CREATED);
   }

   @GetMapping("/buscar/{idLivro}")
   public ResponseEntity<List> pesquisar(@PathVariable Integer idCarro){
       List<Comentarios> comentariosEncontrado = comentariosService.listar(idCarro);
       return new ResponseEntity<>(comentariosEncontrado, HttpStatus.OK);
   }   
   
    
}
