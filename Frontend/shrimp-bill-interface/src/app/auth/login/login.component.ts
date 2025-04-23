import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';   
import { RouterLink, Router } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faEnvelope, faLock } from '@fortawesome/free-solid-svg-icons';
import { LoginRequest, AuthService } from '../../services/auth.service';
import { UserService } from '../../services/user.service';

/*Este componente contiene el RouterLink, para permitir la interacción entre 
* los componentes de inicio de sesión, en este caso, que es login y register, 
* que son invocados en el app.component.html y dashboard.component*/

/*Además usa Font Awesome para los iconos, lo que hace, despues de tener la depedencia descargada
* solo seleccionas de la página oficial (https://fontawesome.com/) el icono, lo importas y lo 
* invocas en la class LoginComponent*/
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [RouterLink, FontAwesomeModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
    faEnvelope = faEnvelope;
    faLock = faLock;

    form: LoginRequest = {
          email: '',
          password: ''
    };
    errorMessage = '';
      
    constructor(private authService: AuthService, private router: Router, private userService: UserService) {}
      
    onSubmit() {
      this.authService.login(this.form).subscribe({
        next: resp => {
          localStorage.setItem('token', resp.token);
          // Carga el perfil y guárdalo en un servicio de usuario
          this.authService.profile().subscribe(profile => {
            this.userService.setProfile(profile);
            this.router.navigate(['/home']);
          });
        },
         error: err => {
          console.error(err);
          this.errorMessage = 'El correo electronico o la contraseña son incorrectos: ' + err.error;
        }
      });
    }
}
