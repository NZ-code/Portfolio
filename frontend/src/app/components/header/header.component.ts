import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  link= 'mailto:zenevichnikita2001@gmail.com';
  redirectToMail() {
    window.location.href = this.link;
  }
}

