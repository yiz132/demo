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

  public getUserReportsCount = (user: User): Observable<User> => {
    const actionUrl = Constants.apiServer + '/service/report/getUserReportsCount/' + user.id;
    return this.http.get(actionUrl)
      .map((response: Response) => response.json() as User)
      .catch(this.handleError);
  }


  // public getData = (user: User): Observable<any> => {
  //   const actionUrl = Constants.apiServer + '/controller/';
  //   return this.http.get(actionUrl)
  //     .map((response: Response) => <any>response.json())
  //     .catch(this.handleError);
  // }

  public getUserReports = (user: User): Observable<Report[]> => {
    const actionUrl = Constants.apiServer + '/service/report/getUserReports/' + user.id;
    return this.http.get(actionUrl)
      .map((response: Response) => response.json() as Report[])
      .catch(this.handleError);
  }
  public getAllReports = (): Observable<Report[]> => {
    const actionUrl = Constants.apiServer + '/service/report/getAllReports';
    return this.http.get(actionUrl)
      .map((response: Response) => response.json() as Report[])
      .catch(this.handleError);
  }

  public reserver = (report: Report): Observable<Report> => {
    const toAdd = JSON.stringify(report);
    const actionUrl = Constants.apiServer + '/service/report/reserver';
    return this.http.post(actionUrl, toAdd, { headers: this.headers })
      .map((response: Response) => {
        if (response && response.json()) {
          return response.json() as Report;
        }
      })
      .catch(this.handleError);
  }

  public review = (report: Report): Observable<Report> => {
    const toAdd = JSON.stringify(report);
    const actionUrl = Constants.apiServer + '/service/report/review';
    return this.http.post(actionUrl, toAdd, { headers: this.headers })
      .map((response: Response) => {
        if (response && response.json()) {
          return response.json() as Report;
        }
      })
      .catch(this.handleError);
  }

  public delete = (report: Report): Observable<String> => {
    const actionUrl = Constants.apiServer + '/service/report/delete/' + report.id;
    return this.http.get(actionUrl)
      .map((response: Response) => response.json() as String)
      .catch(this.handleError);
  }

  public confirmer = (report: Report): Observable<String> => {
    const toAdd = JSON.stringify(report);
    const actionUrl = Constants.apiServer + '/service/report/confirmer';
    return this.http.post(actionUrl, toAdd, { headers: this.headers })
      .map((response: Response) => {
        if (response && response.json()) {
          return response.json() as String;
        }
      })
      .catch(this.handleError);
  }

  public terminer = (report: Report): Observable<String> => {
    const actionUrl = Constants.apiServer + '/service/report/terminer/' + report.id;
    return this.http.get(actionUrl)
      .map((response: Response) => response.json() as String)
      .catch(this.handleError);
  }



  private handleError(error: Response) {
    console.error(error);
    return Observable.throw(error.json().error || 'Server error');
  }
}
