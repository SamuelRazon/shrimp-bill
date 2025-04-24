import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { ModalComponent } from "./dashboard/modal/modal.component";
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faCircleQuestion} from '@fortawesome/free-solid-svg-icons';


/*Además usa Font Awesome para los iconos, lo que hace, despues de tener la depedencia descargada
* solo seleccionas de la página oficial (https://fontawesome.com/) el icono, lo importas y lo invocas en la class LoginComponent*/
@Component({
  selector: 'app-root',
  imports: [RouterOutlet, RouterLink, ModalComponent, FontAwesomeModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'shrimp-bill-interface';

  faCircleQuestion = faCircleQuestion;
}
