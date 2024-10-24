import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PackageServiceService } from '../services/package-service.service';

@Component({
  selector: 'app-packages',
  templateUrl: './packages.component.html',
  styleUrls: ['./packages.component.css']
})
export class PackagesComponent implements OnInit {
  country: string | null = null;
  packageData: any[] = [];

  constructor(private route: ActivatedRoute, private packageService: PackageServiceService) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.country = params.get('name');
      if (this.country) {
        this.packageService.getPackageData(this.country).subscribe(
          (data: any) => {
            this.packageData = data;
            console.log("data is : "+JSON.stringify(this.packageData));
          },
          (error: any) => {
            console.error('Error fetching package data:', error);
          }
        );
      }
    });
  }
}
