import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

interface Booking{
  userID:number;
  packageID:number;
  bookingDate:string;
  travelDate:string;
  noOfPersons:number;
  totalAmount:number;
}

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private userId: number | null = null;

  constructor(private http: HttpClient) { }

  setUserId(userId: number) {
    this.userId = userId;
  }

  getUserId(): number | null {
    return this.userId;
  }

  getUserData(userId: number): Observable<any> {
    return this.http.get(`http://localhost:8085/users/${userId}`);
  }

  bookPackage(credentials: Booking): Observable<any> {
    console.log(credentials);
    console.log(typeof credentials.packageID);
    return this.http.post('http://localhost:8090/bookings', credentials);
  }
}
