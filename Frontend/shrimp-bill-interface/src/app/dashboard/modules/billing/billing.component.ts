import { Component } from '@angular/core';
import { SelectServiceComponent } from "./select-service/select-service.component";
import { DataServiceComponent } from "./data-service/data-service.component";
import { FiscalDataComponent } from "./fiscal-data/fiscal-data.component";
import { CheckDataComponent } from "./check-data/check-data.component";

/**
 * Se encarga de la demostración de ser el avanzador entre los archivos con una invocación, 
 * que usa OutPut para ser llamados, de esa forma, se establece quien va de quien, y solamente
 * se indica con una condicional el límite que debe parar. 
*/

/*Además usa Font Awesome para los iconos, lo que hace, despues de tener la depedencia descargada
* solo seleccionas de la página oficial (https://fontawesome.com/)*/
@Component({
  selector: 'app-billing',
  imports: [SelectServiceComponent, DataServiceComponent, FiscalDataComponent, CheckDataComponent],
  templateUrl: './billing.component.html',
  styleUrl: './billing.component.css'
})
export class BillingComponent {
  step = 1

  nextstep(){
    if(this.step <= 5){
      this.step = this.step + 1
      console.log("Neext recibido!")
    }
  }
}
