import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormularioComponent } from './formulario/formulario.component';
import { ConsultaComponent } from './consulta/consulta.component';


const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'formulario', component: FormularioComponent },
  { path: 'listaEncuestas', component: ConsultaComponent },
  { path: '**', component: LoginComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
