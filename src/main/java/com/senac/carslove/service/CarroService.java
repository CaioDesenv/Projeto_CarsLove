
package com.senac.carslove.service;

import com.senac.carslove.model.Carro;
import com.senac.carslove.repository.CarroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {
    @Autowired
   CarroRepository carroRepository;    
    
    //CRUD
    
    public List<Carro> listarTodos(){
        return carroRepository.findAll();
    }
    
    public Carro buscarPorId(Integer id){
        return carroRepository.findById(id).orElseThrow();
    }
    
    public void excluir(Integer id){
        Carro carroEncontrado = buscarPorId(id);
        carroRepository.deleteById(carroEncontrado.getId());
    }
    
    public Carro criar(Carro car){
        car.setId(null);
        carroRepository.save(car);
        return car;
    }
    
    public Carro atualizar(Integer id, Carro carroEnviado){
        Carro carroEncontrado = buscarPorId(id);
        carroEncontrado.setNome(carroEnviado.getNome());
        carroEncontrado.setMarca(carroEnviado.getMarca());
        carroEncontrado.setModelo(carroEnviado.getModelo());
        carroRepository.save(carroEncontrado);
        return carroEncontrado;
    }
}
