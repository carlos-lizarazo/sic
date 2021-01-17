import { Component, OnInit } from '@angular/core';
import { ConsultasService } from '../consultas.service';
import { Encuesta } from '../model/encuesta';

@Component({
  selector: 'app-consulta',
  templateUrl: './consulta.component.html',
  styleUrls: ['./consulta.component.css']
})
export class ConsultaComponent implements OnInit {
  encuestas : Encuesta [];

  constructor(private consultasService: ConsultasService) { }

  ngOnInit() {
    this.consultasService.listaEncuestas().subscribe((data: Encuesta []) => this.encuestas = data);
  }

  borrarEncuesta(encuesta : Encuesta) {
    this.consultasService.borrarEncuesta(encuesta.id)
    .subscribe(() => {
      this.consultasService.listaEncuestas().subscribe((data: Encuesta []) => this.encuestas = data);
    });
  }
}
