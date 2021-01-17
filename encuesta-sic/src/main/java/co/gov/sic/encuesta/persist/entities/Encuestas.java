package co.gov.sic.encuesta.persist.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Encuestas {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENCUESTAS_GEN")
    @SequenceGenerator(name = "ENCUESTAS_GEN", sequenceName = "ENCUESTAS_ID_SEQ",
        allocationSize = 0)
	private Integer id;
	
	@Column
	private Integer numeroDocumento;
	
	@Column
	private String email;
	
	@Column
	private String comentarios;

	@Column
	private Integer idMarcaFavorita;

	@Column
	@Temporal(TemporalType.DATE)
	private Date fechaRespuesta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(Integer numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Integer getIdMarcaFavorita() {
		return idMarcaFavorita;
	}

	public void setIdMarcaFavorita(Integer idMarcaFavorita) {
		this.idMarcaFavorita = idMarcaFavorita;
	}

	public Date getFechaRespuesta() {
		return fechaRespuesta;
	}

	public void setFechaRespuesta(Date fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}

	@Override
	public String toString() {
		return "Encuestas [id=" + id + ", numeroDocumento=" + numeroDocumento + ", email=" + email + ", comentarios="
				+ comentarios + ", idMarcaFavorita=" + idMarcaFavorita + ", fechaRespuesta=" + fechaRespuesta + "]";
	}

}
