import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { ModalComponent } from "./dashboard/modal/modal.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, RouterLink, ModalComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'shrimp-bill-interface';
}
