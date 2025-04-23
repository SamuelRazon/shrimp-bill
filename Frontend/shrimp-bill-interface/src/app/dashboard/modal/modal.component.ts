import { Component, OnInit  } from '@angular/core';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faTimes } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-modal',
  imports: [FontAwesomeModule],
  templateUrl: './modal.component.html',
  styleUrl: './modal.component.css'
})
export class ModalComponent implements OnInit{
  faTimes = faTimes; // Icono de cerrar el modal (FontAwesome)
  isVisible = true; // Estado del modal

  ngOnInit() {
    const modalClosed = localStorage.getItem('modalClosed');
    if (modalClosed === 'true') {
      this.isVisible = false;
    }
  }

  closeModal() {
    this.isVisible = false; // Cambiar el estado para cerrar el modal
    localStorage.setItem('modalClosed', 'true');
  }
}
