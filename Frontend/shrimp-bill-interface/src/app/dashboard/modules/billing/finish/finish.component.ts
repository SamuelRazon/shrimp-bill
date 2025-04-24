import { Component, EventEmitter, Output } from '@angular/core';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faAngleLeft, faBusSimple, faCircleQuestion} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-finish',
  imports: [FontAwesomeModule],
  templateUrl: './finish.component.html',
  styleUrl: './finish.component.css'
})
export class FinishComponent {
  @Output() sendNextStep = new EventEmitter<void>();
  faAngleLeft = faAngleLeft
  alertNextStep(){
    console.log("Neext!")
    this.sendNextStep.emit()
  }
}
