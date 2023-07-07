import { Component } from '@angular/core';

@Component({
  selector: 'app-cover',
  templateUrl: './cover.component.html',
  styleUrls: ['./cover.component.css']
})
export class CoverComponent {
  link= 'mailto:zenevichnikita2001@gmail.com'
  redirectToMail() {
    window.location.href = this.link;
  }
}
