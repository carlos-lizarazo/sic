import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AutenticacionService } from '../autenticacion.service';

@Component({
    selector: 'login',
    templateUrl: 'login.component.html'
})
export class LoginComponent implements OnInit {
      usuario: string = "";
      clave: string = "";

      model: any = {};

      constructor(
          private router: Router,
          private auth: AutenticacionService
      ) { }

      ngOnInit() {
      }

      login() {
            this.auth.login(this.usuario, this.clave, () => {
            this.router.navigateByUrl('/formulario');
        });
      }
  }
