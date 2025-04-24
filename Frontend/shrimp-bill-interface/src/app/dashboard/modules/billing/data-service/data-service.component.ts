import { Component, EventEmitter, Output } from '@angular/core';
import { RouterLink } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faAngleLeft, faBusSimple, faCloudArrowUp, faQrcode, faCircleQuestion} from '@fortawesome/free-solid-svg-icons';

/**
 * Se encarga de la demostración del rellenado de los datos de información, que son conformados
 * con los datos esenciales y a su vez, usa OutPut para avanzar al siguiente archivo, anteriormente
 * es invocado por biling.component  
*/

/*Además usa Font Awesome para los iconos, lo que hace, despues de tener la depedencia descargada
* solo seleccionas de la página oficial (https://fontawesome.com/)*/
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
  faCircleQuestion = faCircleQuestion;
}
