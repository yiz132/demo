import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
// tslint:disable-next-line:import-blacklist
import { Observable } from 'rxjs/Rx';
import { Cookie } from 'ng2-cookies/ng2-cookies';

import {Constants} from '../app/app.constants';
import {User} from '../app/models/User';

@Injectable()
export class UsersService {
  private headers: Headers;

  constructor(private http: Http) {
    this.headers = new Headers();
    this.headers.append('Content-Type', 'application/json');
    this.headers.append('Accept', 'application/json');
  }

  public register = (user: User): Observable<User> => {
    const toAdd = JSON.stringify(user);
    const actionUrl = Constants.apiServer + '/service/user/register';
    return this.http.post(actionUrl, toAdd, {headers: this.headers})
        .map((response: Response) => {
          if (response && response.json()) {
            return response.json() as User;
          }
        })
        .catch(this.handleError);
  }

  public login = (user: User): Observable<User> => {
    const toAdd = JSON.stringify(user);
    const actionUrl = Constants.apiServer + '/service/user/login';
    return this.http.post(actionUrl, toAdd, {headers: this.headers})
        .map((response: Response) => {
          if (response && response.json()) {
            return response.json() as User;
          }
        })
        .catch(this.handleError);
  }

  private handleError(error: Response) {
    console.error(error);
    return Observable.throw(error.json().error || 'Server error');
  }

  public getUser = (user: User): Observable<User> => {
    const actionUrl = Constants.apiServer + '/service/user/getUser/' + user.id;
    return this.http.get(actionUrl, {headers: this.headers})
        .map((response: Response) => response.json() as User)
        .catch(this.handleError);
  }
}
