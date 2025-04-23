import { Component, EventEmitter, Output } from '@angular/core';
import { RouterLink } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faAngleLeft, faBusSimple} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-fiscal-data',
  imports: [FontAwesomeModule, RouterLink],
  templateUrl: './fiscal-data.component.html',
  styleUrl: './fiscal-data.component.css'
})
export class FiscalDataComponent {
  @Output() sendNextStep = new EventEmitter<void>();

  alertNextStep(){
    console.log("Neext!")
    this.sendNextStep.emit()
  }

  faAngleLeft = faAngleLeft;
  faBusSimple= faBusSimple;
}
