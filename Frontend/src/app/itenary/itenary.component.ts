import { Component } from '@angular/core';
import { ActivatedRoute} from '@angular/router';
import { PackageServiceService } from '../services/package-service.service';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router'; 


@Component({
  selector: 'app-itenary',
  templateUrl: './itenary.component.html',
  styleUrl: './itenary.component.css'
})

export class ItenaryComponent {
  packageId: number = 0;
  packageData : any | null =null;
 


  constructor(private route: ActivatedRoute,private router:Router,
    private packageServiceService: PackageServiceService, private userService:UserService) { }

  ngOnInit(): void {
    // Retrieve the ID parameter from the URL
    this.route.params.subscribe(params => {
      this.packageId = Number(params['id']);
      console.log("hello"+typeof Number(params['id']));
      this.packageServiceService.getItenaryData(this.packageId).subscribe(
        (data: any) => {
          this.packageData = data;
        },
        (error: any) => {
          console.error('Error fetching package data:', error);
        }
      );
    });
  }

  bookPackage() {
    const userID = this.userService.getUserId();
    if (userID === null) {
      alert("User not Logged in.")
      console.error('User ID is null. Please log in first.');
      return; // Handle this case appropriately, maybe by redirecting to a login page
    }
    // Assuming you have access to the necessary data for the booking
    else{
    const bookingData = {
      userID: userID, // Replace with the actual user ID
      packageID: this.packageId, // Replace with the actual package ID
      bookingDate:  '2024-12-31',
      travelDate: '2024-12-31', // Replace with the actual travel date
      noOfPersons: 2, // Replace with the actual number of persons
      totalAmount: this.packageData.packagePrice // Replace with the actual total amount
    };
  

    // Call the bookPackage method from the userService
    this.userService.bookPackage(bookingData).subscribe(
      response => {
        // Handle success response
        this.router.navigate(['/booking']) 
        console.log('Booking successful:', response);
        // Optionally, you can perform additional actions after successful booking
      },
      error => {
        // Handle error response
        console.error('Error:', error);
        // Optionally, you can display an error message to the user
      }
    );
  }
  }
}
