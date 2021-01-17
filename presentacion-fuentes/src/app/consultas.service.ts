import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Encuesta } from './model/encuesta';
import { catchError, map, tap } from 'rxjs/operators';
import { Observable } from 'rxjs/internal/Observable';
import { ObservableInput } from 'rxjs/internal/types';
import { Marca } from './model/marca';

@Injectable({
  providedIn: 'root'
})
export class ConsultasService {
  constructor(private http: HttpClient) { }

  listaMarcas(): any {
    return this.http.get<Marca[]>(environment.apiUrl + "/listaMarcas").pipe(
      tap(message => console.log('tap:' + message)),
      catchError(this.handleError('listaMarcas'))
    ) as Observable<Marca[]>;
  }

  listaEncuestas() : any {
    return this.http.get<Encuesta[]>(environment.apiUrl + "/listaEncuestas").pipe(
      tap(message => console.log('tap:' + message)),
      catchError(this.handleError('listaEncuestas'))
    ) as Observable<Encuesta[]>;
  }

  private handleError<T>(operation = 'operation') {
      return (error: HttpErrorResponse): Observable<T> => {

        console.error(error);

        const message = (error.error instanceof ErrorEvent) ?
          error.error.message :
         `server returned code ${error.status} with body "${error.error}"`;

        throw new Error(`${operation} failed: ${message}`);
      };

    }

  enviarEncuesta(encuesta: Encuesta) {
    return this.http.post<Encuesta>(environment.apiUrl + "/registrarFormulario", encuesta).pipe(
      tap(message => console.log('tap:' + message)),
      catchError(this.handleError('listaEncuestas'))
    ) as Observable<Encuesta>;
  }

  borrarEncuesta(id: number) {
    return this.http.delete<string>(environment.apiUrl + "/eliminarEncuesta/" + id).pipe(
      tap(message => console.log('tap:' + message)),
      catchError(this.handleError('listaEncuestas'))
    ) as Observable<string>;
  }

}
