import { Component } from '@angular/core';
import { AutenticacionService } from './autenticacion.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'presentacion-sic';
  autenticado : boolean = false;

  constructor(private auth: AutenticacionService) {
    this.cambiarAutenticacion();
  };

  cambiarAutenticacion() {
    setInterval(() => {
      this.autenticado = this.auth.autenticado
    }, 1000);
  }
}
