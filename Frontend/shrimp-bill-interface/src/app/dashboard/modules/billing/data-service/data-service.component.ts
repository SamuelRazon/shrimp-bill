import { Component, EventEmitter, Output } from '@angular/core';
import { RouterLink } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faAngleLeft, faBusSimple, faCloudArrowUp, faQrcode} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-data-service',
  imports: [FontAwesomeModule, RouterLink],
  templateUrl: './data-service.component.html',
  styleUrl: './data-service.component.css'
})
export class DataServiceComponent {
  @Output() sendNextStep = new EventEmitter<void>();

  alertNextStep(){
    console.log("Neext!")
    this.sendNextStep.emit()
  }

  faAngleLeft = faAngleLeft;
  faBusSimple= faBusSimple;
  faCloudArrowUp = faCloudArrowUp;
  faQrcode = faQrcode;
}
