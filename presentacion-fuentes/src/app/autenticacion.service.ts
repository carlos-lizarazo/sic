import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class AutenticacionService {
  autenticado : boolean = false;

  constructor(private http: HttpClient) {
  }

  login(username: string, password: string, callback) {
    const headers = new HttpHeaders( {
        authorization : 'Basic ' + btoa(username + ':' + password)
    });

    this.http.get(environment.apiUrl + '/user', {headers: headers}).subscribe(response => {
        if (response['name']) {
          console.log("get true");
          this.autenticado = true;
        } else {
          console.log("get false");
          this.autenticado = false;
        }
        return callback && callback();
    });
  }
}
