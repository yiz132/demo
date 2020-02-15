import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import {User} from '../app/models/User';
// tslint:disable-next-line:import-blacklist
import { Observable } from 'rxjs/Rx';
import {Constants} from '../app/app.constants';
import {Report} from '../app/models/Report';

@Injectable()
export class ReportsService {
  private headers: Headers;
  constructor(private http: Http) {
    this.headers = new Headers();
    this.headers.append('Content-Type', 'application/json');
    this.headers.append('Accept', 'application/json');
  }

  private handleError(error: Response) {
    console.error(error);
    return Observable.throw(error.json().error || 'Server error');
  }
}
