
package com.senac.carslove.repository;

import com.senac.carslove.model.Carro;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface CarroRepository extends JpaRepository<Carro,Integer> {
    
}
