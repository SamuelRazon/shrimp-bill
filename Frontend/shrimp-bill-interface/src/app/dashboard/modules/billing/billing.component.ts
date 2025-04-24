import { Component } from '@angular/core';
import { SelectServiceComponent } from "./select-service/select-service.component";
import { DataServiceComponent } from "./data-service/data-service.component";
import { FiscalDataComponent } from "./fiscal-data/fiscal-data.component";
import { CheckDataComponent } from "./check-data/check-data.component";
import { ActivatedRoute, Router } from '@angular/router';
import { FinishComponent } from "./finish/finish.component";
/**
 * Se encarga de la demostración de ser el avanzador entre los archivos con una invocación, 
 * que usa OutPut para ser llamados, de esa forma, se establece quien va de quien, y solamente
 * se indica con una condicional el límite que debe parar. 
*/

/*Además usa Font Awesome para los iconos, lo que hace, despues de tener la depedencia descargada
* solo seleccionas de la página oficial (https://fontawesome.com/)*/
@Component({
  selector: 'app-billing',
  imports: [SelectServiceComponent, DataServiceComponent, FiscalDataComponent, CheckDataComponent, FinishComponent],
  templateUrl: './billing.component.html',
  styleUrl: './billing.component.css'
})
export class BillingComponent {
  constructor(private route: ActivatedRoute, private router: Router) {} 
  Router = Router
  step = 1

  ngOnInit(): void {
    if(sessionStorage.getItem('qrData') && this.step === 1){
      const qrData = sessionStorage.getItem('qrData');
      if (qrData !== null) {
        sessionStorage.setItem('serviceData', qrData);
        this.step = 3;
        sessionStorage.removeItem('qrData');
      }
      
    }
    this.checkSessionStorage();
  }

  nextstep(){
    if(this.step <= 5){
      console.log(this.step);
      this.step = this.step + 1;
      this.checkSessionStorage();
    }
  }

  checkSessionStorage(): void{
    const fiscalData = sessionStorage.getItem('fiscalData');
    if(fiscalData !== null &&  this.step === 3){
      this.step = 4;
    }

    return
  }

  goHome(){
    this.router.navigate(['/home']);
  }
  
}
