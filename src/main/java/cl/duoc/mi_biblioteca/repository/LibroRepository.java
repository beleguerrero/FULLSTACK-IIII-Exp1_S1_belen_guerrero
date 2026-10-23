package cl.duoc.mi_biblioteca.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.mi_biblioteca.entity.LibroEntity;

@Repository 
public interface LibroRepository extends JpaRepository<LibroEntity, Long> {
    // selects...
}
