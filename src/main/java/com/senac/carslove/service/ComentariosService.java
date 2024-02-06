
package com.senac.carslove.service;

import com.senac.carslove.model.Comentarios;
import com.senac.carslove.repository.ComentariosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentariosService {
 
   @Autowired
   ComentariosRepository comentariosRepository;      
    
   //CRUD
    public Comentarios criar(Comentarios com){
        com.setId(null);
        comentariosRepository.save(com);
        return com;
    }
    
    public List<Comentarios> listar(Integer idCarro){
        return comentariosRepository.findByCarroId(idCarro);
    }
   
}
