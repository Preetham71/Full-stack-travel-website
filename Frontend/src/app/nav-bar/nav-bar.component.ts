import { Component,HostListener } from '@angular/core';


@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrl: './nav-bar.component.css'
})
export class NavBarComponent {
  isScrolled: boolean = false;
  

  @HostListener('window:scroll', [])
  onWindowScroll() {
    // Detect if user has scrolled more than 100px (adjust the value as needed)
    this.isScrolled = window.scrollY > 70;
  }
}
