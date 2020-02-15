import { Injectable } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
// tslint:disable-next-line:import-blacklist
// tslint:disable-next-line:import-blacklist
import {Constants} from '../app.constants';
import {catchError, retry} from 'rxjs/internal/operators';
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
export class ReportsService {
  private headers: Headers;
  constructor(private http: HttpClient) {
  }

  // public getFrom = (report: Report): Observable<String> => {
  //   const actionUrl = Constants.apiServer + 'form/' + report.id;
  //   return this.http.get(actionUrl)
  //       .map((response: Response) => <String>response.json())
  //       .catch(this.handleError);
  // }
  //
  // public save = (report: Report): Observable<Report> => {
  //   const toAdd = JSON.stringify(report);
  //   const actionUrl = Constants.apiServer + '/service/report/saveForm';
  //   return this.http.post(actionUrl, toAdd, { headers: this.headers })
  //       .map((response: Response) => {
  //         if (response && response.json()) {
  //           return <Report> response.json();
  //         }
  //       })
  //       .catch(this.handleError);
  // }
  //
  // public delete = (report: Report): Observable<String> => {
  //   const actionUrl = Constants.apiServer + '/service/report/delete/' + report.id;
  //   return this.http.get(actionUrl)
  //       .map((response: Response) => <String>response.json())
  //       .catch(this.handleError);
  // }
  //
  // public getAllForms = (): Observable<Report[]> => {
  //   const actionUrl = Constants.apiServer + '/service/report/getAllReports';
  //   return this.http.get(actionUrl)
  //       .map((response: Response) => <Report[]> response.json())
  //       .catch(this.handleError);
  // }
  //
  // private handleError(error: Response) {
  //   console.error(error);
  //   return Observable.throw(error.json().error || 'Server error');
  // }
}
