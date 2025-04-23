import { Component, EventEmitter, Output } from '@angular/core';
import { RouterLink } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faBusSimple, faAppleWhole, faBox, faAngleLeft } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-select-service',
  imports: [FontAwesomeModule, RouterLink],
  templateUrl: './select-service.component.html',
  styleUrl: './select-service.component.css'
})
export class SelectServiceComponent {
 @Output() sendNextStep = new EventEmitter<void>();

  alertNextStep(){
    console.log("Neext!")
    this.sendNextStep.emit()
  }

  faBusSimple = faBusSimple;
  faAppleWhole = faAppleWhole;
  faBox = faBox;
  faAngleLeft = faAngleLeft;
}
