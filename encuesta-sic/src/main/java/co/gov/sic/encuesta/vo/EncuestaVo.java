package co.gov.sic.encuesta.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class EncuestaVo {
	private Integer id;
	private Integer numeroDocumento;
	private String email;
	private String comentarios;
	private Integer idMarcaFavorita;
	private Date fecha;
	
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
