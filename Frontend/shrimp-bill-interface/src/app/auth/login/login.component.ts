import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faEnvelope, faLock } from '@fortawesome/free-solid-svg-icons';

/*Este componente contiene el RouterLink, para permitir la interacción entre 
* los componentes de inicio de sesión, en este caso, que es login y register, 
* que son invocados en el app.component.html y dashboard.component*/

/*Además usa Font Awesome para los iconos, lo que hace, despues de tener la depedencia descargada
* solo seleccionas de la página oficial (https://fontawesome.com/) el icono, lo importas y lo 
* invocas en la class LoginComponent*/
@Component({
  selector: 'app-login',
  imports: [RouterLink, FontAwesomeModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
    faEnvelope = faEnvelope;
    faLock = faLock;
}
