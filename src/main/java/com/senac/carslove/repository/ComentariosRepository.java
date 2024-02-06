
package com.senac.carslove.repository;

import com.senac.carslove.model.Comentarios;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentariosRepository extends JpaRepository<Comentarios, Integer> {
    
    List<Comentarios> findByCarroId(Integer idCarro);
    
}
