import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PackageServiceService {

  constructor(private http: HttpClient) { }

  getPackageData(name: string): Observable<any> {
    return this.http.get(`http://localhost:8080/packages/package/${name}`);
  }

  
  getItenaryData(packageId: number): Observable<any> {
    return this.http.get(`http://localhost:8080/packages/${packageId}`);
  }
}
