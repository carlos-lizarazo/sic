package co.gov.sic.encuesta.persist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.gov.sic.encuesta.persist.entities.Encuestas;

public interface EncuestasRepository extends JpaRepository<Encuestas, Integer>{

}
