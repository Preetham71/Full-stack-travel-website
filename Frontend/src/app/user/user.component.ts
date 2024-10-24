import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent implements OnInit{
 
  errorMessage: string = '';

  name:string = '';
  email:string = '';
  phone:string = '';
  address:string = '';
  role:string = '';

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    const userId = this.userService.getUserId();
    if (userId) {
      this.userService.getUserData(userId).subscribe(
        userData => {
          this.name = userData.userName;
          this.email = userData.userEmail;
          this.phone = userData.userPhone;
          this.address = userData.userAddress;
          this.role = userData.userRole;
        },
        error => {
          console.error('Error fetching user data:', error);
          this.errorMessage = 'Error fetching user data';
        }
      );
    }
  }
}
