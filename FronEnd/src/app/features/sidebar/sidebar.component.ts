import { Component } from '@angular/core';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css'],

})
export class SidebarComponent {
  isExpanded = false;

  toggleMenu(event: Event) {
    event.preventDefault(); // Previene la navegación si es un enlace
    this.isExpanded = !this.isExpanded;
  }
}
