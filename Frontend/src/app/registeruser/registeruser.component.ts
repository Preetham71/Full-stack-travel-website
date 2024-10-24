import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoginServiceService } from '../services/login-service.service';

@Component({
  selector: 'app-registeruser',
  templateUrl: './registeruser.component.html',
  styleUrl: './registeruser.component.css'
})
export class RegisteruserComponent implements OnInit{
  registerForm: FormGroup;
  errorMessage: string = '';
  successMessage: string = '';

  constructor(private fb: FormBuilder, private loginServiceService: LoginServiceService) {
    this.registerForm = this.fb.group({
      userName: ['', Validators.required],
      userEmail: ['', [Validators.required, Validators.email]],
      userPhone: ['', Validators.required],
      userPassword: ['', [Validators.required, Validators.minLength(6)]],
      userAddress: ['', Validators.required],
      userRole: ['user', Validators.required]
    });
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this.errorMessage = '';

    if (this.registerForm.valid) {
      this.loginServiceService.register(this.registerForm.value).subscribe(
        response => {
          console.log('Registration successful:', response);
          this.successMessage = "User Registered Successfully";
        },
        error => {
          console.error('Error:', error);
          this.errorMessage = 'Registration failed. Please try again.';
        }
      );
    }
  }
}
