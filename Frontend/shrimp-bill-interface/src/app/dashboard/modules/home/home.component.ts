import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faFileLines, faMagnifyingGlassDollar } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-home',
  imports: [FontAwesomeModule, RouterLink],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  faFileLines = faFileLines;
  faMagnifyingGlassDollar = faMagnifyingGlassDollar;
}
