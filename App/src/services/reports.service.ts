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

  public getFrom = (report: Report): Observable<String> => {
    const actionUrl = Constants.apiServer + 'form/' + report.id;
    return this.http.get(actionUrl)
        .map((response: Response) => <String>response.json())
        .catch(this.handleError);
  }

  public save = (report: Report): Observable<Report> => {
    const toAdd = JSON.stringify(report);
    const actionUrl = Constants.apiServer + '/service/report/saveForm';
    return this.http.post(actionUrl, toAdd, { headers: this.headers })
        .map((response: Response) => {
          if (response && response.json()) {
            return <Report> response.json();
          }
        })
        .catch(this.handleError);
  }

  public delete = (report: Report): Observable<String> => {
    const actionUrl = Constants.apiServer + '/service/report/delete/' + report.id;
    return this.http.get(actionUrl)
        .map((response: Response) => <String>response.json())
        .catch(this.handleError);
  }

  public getAllForms = (): Observable<Report[]> => {
    const actionUrl = Constants.apiServer + '/service/report/getAllReports';
    return this.http.get(actionUrl)
        .map((response: Response) => <Report[]> response.json())
        .catch(this.handleError);
  }

  private handleError(error: Response) {
    console.error(error);
    return Observable.throw(error.json().error || 'Server error');
  }
}
