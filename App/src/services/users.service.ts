// tslint:disable-next-line:import-blacklist
import {Constants} from '../app.constants';
import {User} from '../models/User';
import {catchError, retry} from 'rxjs/internal/operators';
import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';

const apiUrl = Constants;
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'jwt-token'
  })
};


@Injectable()
export class UsersService {
  private headers: Headers;

  constructor(private http: HttpClient) {
  }

  // public register = (user: User): Observable<User> => {
  //   const toAdd = JSON.stringify(user);
  //   const actionUrl = Constants.apiServer + '/service/user/register';
  //   return this.http.post(actionUrl, toAdd, {headers: this.headers})
  //       .pipe(
  //           retry(1),
  //           catchError(this.errorHandl)
  //       )
  // }

  public login = (user: User): Observable<User> => {
    const toAdd = JSON.stringify(user);
    const actionUrl = Constants.apiServer + '/service/user/login';
    return this.http.post<User>(actionUrl, User, httpOptions)
        .pipe(
            catchError(this.handleError('login', user))
        );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      this.log(`${operation} failed: ${error.message}`);

      return of(result as T);
    };
  }

  private log(message: string) {
    console.log(message);
  }
  //
  // public getUser = (user: User): Observable<User> => {
  //   const actionUrl = Constants.apiServer + '/service/user/getUser/' + user.id;
  //   return this.http.get(actionUrl, {headers: this.headers})
  //       .map((response: Response) => response.json() as User)
  //       .catch(this.handleError);
  // }
}
