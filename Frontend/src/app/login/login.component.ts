import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoginServiceService } from '../services/login-service.service';
import { UserService } from '../services/user.service';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  loginForm: FormGroup;
  successMessage: string = '';
  errorMessage: string = '';
  userName: string = '';

  constructor(private fb: FormBuilder, private loginServiceService: LoginServiceService, private userService:UserService) {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(12)]]
    });
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this.successMessage = '';
    this.errorMessage = '';
  
    if (this.loginForm.valid) {
  
      this.loginServiceService.login(this.loginForm.value).subscribe(
        response => {
          
          this.successMessage = response;
          this.getUserDetails(this.loginForm.value.email);
          this.loginForm.reset();
        },
        error => {
          console.error('Error:', error);
          this.errorMessage = 'Failed to Login. Please try again.';
        }
      );
    }
  }
  getUserDetails(email: string) {
    this.loginServiceService.getUserDetailsByEmail(email).subscribe(
      userDetails => {
        this.userName = userDetails.userName;
        this.userService.setUserId(userDetails.userId);
        console.log(this.userService.getUserId());
      },
      error => {
        console.error('Error fetching user details:', error);
      }
    );
  }
}
