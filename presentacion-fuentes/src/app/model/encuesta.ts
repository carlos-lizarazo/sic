export class Encuesta {
  id: number;
  numeroDocumento : number;
	email : string;
	comentarios : string;
  idMarcaFavorita : number;
  fecha: number;

    constructor(
      numeroDocumento : number,
    	email : string,
    	comentarios : string,
      idMarcaFavorita : number,
      fecha: number
    ) {
        this.numeroDocumento = numeroDocumento;
        this.email = email;
        this.comentarios = comentarios;
        this.idMarcaFavorita = idMarcaFavorita;
        this.fecha = fecha;
    }
}
