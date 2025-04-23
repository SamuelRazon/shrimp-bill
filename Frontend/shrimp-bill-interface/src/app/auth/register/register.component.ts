import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faEnvelope, faLock, faCircleUser } from '@fortawesome/free-solid-svg-icons';

/*Este componente contiene el RouterLink, para permitir la interacción entre 
* los componentes de inicio de sesión, en este caso, que es login y register, 
* que son invocados en el app.component.html y dashboard.component*/

/*Además usa Font Awesome para los iconos, lo que hace, despues de tener la depedencia descargada
* solo seleccionas de la página oficial (https://fontawesome.com/) el icono, lo importas y lo invocas en la class LoginComponent*/
@Component({
  selector: 'app-register',
  imports: [RouterLink, FontAwesomeModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
    faEnvelope = faEnvelope;
    faLock = faLock;
    faCircleUser =  faCircleUser;
}
