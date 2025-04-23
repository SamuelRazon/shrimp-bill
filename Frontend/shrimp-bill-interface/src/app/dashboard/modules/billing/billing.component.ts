import { Component } from '@angular/core';
import { SelectServiceComponent } from "./select-service/select-service.component";
import { DataServiceComponent } from "./data-service/data-service.component";
import { FiscalDataComponent } from "./fiscal-data/fiscal-data.component";
import { CheckDataComponent } from "./check-data/check-data.component";

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
