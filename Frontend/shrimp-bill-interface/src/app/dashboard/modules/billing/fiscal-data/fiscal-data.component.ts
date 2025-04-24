import { Component, EventEmitter, Output } from '@angular/core';
import { RouterLink } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faAngleLeft, faBusSimple, faCircleQuestion} from '@fortawesome/free-solid-svg-icons';

/**
 * Se encarga de la demostración del rellenado de los datos fiscales, que son conformados
 * con los datos esenciales y a su vez, usa OutPut para avanzar al siguiente archivo, anteriormente
 * es invocado por data-service.  
*/

/*Además usa Font Awesome para los iconos, lo que hace, despues de tener la depedencia descargada
* solo seleccionas de la página oficial (https://fontawesome.com/) el icono, lo importas y lo invocas en la class LoginComponent*/
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
  faCircleQuestion = faCircleQuestion;
}
