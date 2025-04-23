import { Component, inject, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';        // <-- importar aquí
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faEnvelope, faLock, faCircleUser } from '@fortawesome/free-solid-svg-icons';
import { RegisterRequest, AuthService } from '../../services/auth.service';

/*Este componente contiene el RouterLink, para permitir la interacción entre 
* los componentes de inicio de sesión, en este caso, que es login y register, 
* que son invocados en el app.component.html y dashboard.component*/

/*Además usa Font Awesome para los iconos, lo que hace, despues de tener la depedencia descargada
* solo seleccionas de la página oficial (https://fontawesome.com/) el icono, lo importas y lo invocas en la class LoginComponent*/
@Component({
  selector: 'app-register',
  standalone: true,
  imports: [RouterLink,  FontAwesomeModule, FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
    faEnvelope = faEnvelope;
    faLock = faLock;
    faCircleUser =  faCircleUser;

    form: RegisterRequest = {
      nombre: '',
      apellidos: '',
      email: '',
      password: ''
    };
    confirmPassword = '';
    errorMessage = '';
  
    constructor(private authService: AuthService, private router: Router) {}
  
    onSubmit() {
      if (this.form.password !== this.confirmPassword) {
        this.errorMessage = 'Las contraseñas no coinciden';
        return;
      }
      this.authService.register(this.form).subscribe({
        next: resp => {
          // Guardar token, e.g. localStorage
          localStorage.setItem('token', resp.token);
          // Redirigir a dashboard u otra ruta
          this.router.navigate(['/home']);
        },
        error: err => {
          console.error(err);
          this.errorMessage = 'Error al registrar: ' + err.error;
        }
      });
    }
}
