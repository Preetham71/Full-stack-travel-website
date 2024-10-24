import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

interface Login {
  email: string;
  password: number;
}

interface Register{
  userName:string;
  userEmail:string;
  userPhone:string;
  userPassword:string;
  userAddress:string;
  userRole:string;
}

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  loginUrl = 'http://localhost:8085/users/login';
  registerUrl = 'http://localhost:8085/users/register';

  constructor(private http: HttpClient) { }

  login(credentials: Login): Observable<any> {
    return this.http.post(this.loginUrl, credentials, { responseType: "text" }
    );
  }

  register(credentials: Register): Observable<any> {
    
    return this.http.post(this.registerUrl, credentials);
  }

  getUserDetailsByEmail(email: string): Observable<any> {
    return this.http.get(`http://localhost:8085/users/email/${email}`);
  }

}
