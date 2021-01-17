package co.gov.sic.encuesta.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.gov.sic.encuesta.persist.entities.Encuestas;
import co.gov.sic.encuesta.persist.entities.MarcasFavoritas;
import co.gov.sic.encuesta.persist.repositories.EncuestasRepository;
import co.gov.sic.encuesta.persist.repositories.MarcasFavoritasRepository;
import co.gov.sic.encuesta.vo.EncuestaVo;

@CrossOrigin("*")
@RestController
public class EncuestaRest {
	private static final Logger log = LoggerFactory.getLogger(EncuestaRest.class);


	@Autowired
	EncuestasRepository encuestasRepository;
	
	@Autowired
	MarcasFavoritasRepository marcasFavoritasRepository;
    
	@GetMapping("/user")
	public Principal user(Principal user) {
		return user;
	}
	
	@PostMapping("/registrarFormulario")
	public ResponseEntity<Encuestas> registrarFormulario(@RequestBody EncuestaVo encuestaVo) {
		Encuestas encuesta;
		try {
			log.info("encuesta:" + encuestaVo);
			encuesta = new Encuestas();
			encuesta.setComentarios(encuestaVo.getComentarios());
			encuesta.setEmail(encuestaVo.getEmail());
			encuesta.setFechaRespuesta(new Date());
			encuesta.setIdMarcaFavorita(encuestaVo.getIdMarcaFavorita());
			encuesta.setNumeroDocumento(encuestaVo.getNumeroDocumento());
			encuesta = encuestasRepository.save(encuesta);
		} catch (Exception e) {
			log.error("falla grabando", e);
			return new ResponseEntity<Encuestas>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(encuesta);
	}

	@GetMapping("/listaEncuestas")
	public ResponseEntity<List<Encuestas>> listaEncuestas() {
		List<Encuestas> listaEncuestas = encuestasRepository.findAll();
		return ResponseEntity.ok(listaEncuestas);
	}
	
	@GetMapping("/listaMarcas")
	public ResponseEntity<List<MarcasFavoritas>> listaMarcas() {
		List<MarcasFavoritas> listaMarcas = marcasFavoritasRepository.findAll();
		return ResponseEntity.ok(listaMarcas);
	}
	
	@DeleteMapping("/eliminarEncuesta/{encuestaId}")
	public ResponseEntity eliminarEncuesta(@PathVariable("encuestaId") Integer encuestaId) {
		Optional<Encuestas> enc = encuestasRepository.findById(encuestaId);
		
		if (enc.isPresent()) {
			try {
				encuestasRepository.delete(enc.get());
			} catch (Exception e) {
				log.error("falla borrado", e);
				return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return ResponseEntity.ok().build();
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
}
