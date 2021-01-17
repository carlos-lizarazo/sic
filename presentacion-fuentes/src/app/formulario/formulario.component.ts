import { Component, OnInit } from '@angular/core';
import { Encuesta } from '../model/encuesta';
import { Marca } from '../model/marca';
import { ConsultasService } from '../consultas.service';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {
  encuesta : Encuesta = new Encuesta(0, '', '', 0, 0);
  marcas : Marca [];

  constructor(private consultasService: ConsultasService) { }

  ngOnInit() {
    console.log("formulario inicio");
    this.consultasService.listaMarcas().subscribe((data: Marca []) => this.marcas = data);
  }

  enviarEncuesta() {
    this.consultasService.enviarEncuesta(this.encuesta).subscribe(() => {
      this.encuesta = new Encuesta(0, '', '', 0, 0);
    });
  }
}
