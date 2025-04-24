import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faAngleLeft, faCircleQuestion} from '@fortawesome/free-solid-svg-icons';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule, FormGroup, FormControl, Validators } from '@angular/forms';


interface Food {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-recovery-cfdi',
  standalone: true,
  imports: [FontAwesomeModule, RouterLink, CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './recovery-cfdi.component.html',
  styleUrl: './recovery-cfdi.component.css'
})
export class RecoveryCfdiComponent {
  faAngleLeft = faAngleLeft;
  faCircleQuestion = faCircleQuestion;

  recoveryForm: FormGroup;
  clicked = false;  // nuevo estado para la animación

  constructor() {
    // Inicialización del formulario con validación
    this.recoveryForm = new FormGroup({
      tipoServicio: new FormControl('', [Validators.required]),
      token: new FormControl('', [Validators.required]),
      rfc: new FormControl('', [Validators.required])
    });
  }

  // Verificar si el formulario es válido
  get isFormValid() {
    console.log(this.recoveryForm.valid)
    return this.recoveryForm.valid;
  }

  onButtonClick() {
    if (this.isFormValid && !this.clicked) {
      this.clicked = true;
      // duración de la animación: 0.6s → volvemos a false tras 600ms
      setTimeout(() => this.clicked = false, 600);
      alert('Formulario válido, puedes continuar');
    } else if (!this.isFormValid) {
      alert('Por favor, completa todos los campos.');
    }
  }
}
