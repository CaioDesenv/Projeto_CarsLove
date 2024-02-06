
package com.senac.carslove.controller;

import com.senac.carslove.model.Carro;
import com.senac.carslove.service.CarroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
public class CarroAPIController {
    
   @Autowired
   CarroService carroService;
   
   //CRUD
   @GetMapping("/listar")
   public ResponseEntity<List> listar(){
       List<Carro> listagem = carroService.listarTodos();
       return new ResponseEntity<>(listagem, HttpStatus.OK);
   } 
   
   @PostMapping("/adicionar")
   public ResponseEntity<Carro> addCarro(@RequestBody Carro car){
       var novoCarro = carroService.criar(car);
       return new ResponseEntity<>(novoCarro, HttpStatus.CREATED);
   }
   
   @GetMapping("/buscar/{id}")
   public ResponseEntity<Carro> pesquisar(@PathVariable Integer id){
       Carro carroEncontrado = carroService.buscarPorId(id);
       return new ResponseEntity<>(carroEncontrado, HttpStatus.OK);
   }
   
   @DeleteMapping("/excluir/{id}")
   public ResponseEntity<Carro> excluir(@PathVariable Integer id){
       carroService.excluir(id);
       return new ResponseEntity<>(HttpStatus.OK);
   }
   
   @PutMapping("/atualizar/{id}")
   public ResponseEntity<Carro> atualizandoLivro(@PathVariable Integer id, @RequestBody Carro car){
       var carroEditado = carroService.atualizar(id, car);
       return new ResponseEntity<>(carroEditado, HttpStatus.OK);
   }   
    
}
