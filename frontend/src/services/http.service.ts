import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';

@Injectable()
export class HttpService {

  private backendPath = '/api';

  constructor(private http: HttpClient) {
  }

  public get(uri): Observable<any> {
    return this.http.get<any>(this.backendPath + uri);
  }

  public post(uri, body): Observable<any> {
    return this.http.post<any>(this.backendPath + uri, body);
  }

  public delete(uri): Observable<any> {
    return this.http.delete<any>(this.backendPath + uri);
  }
}
