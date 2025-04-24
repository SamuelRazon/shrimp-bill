import { Component, EventEmitter, Output } from '@angular/core';
import { faAngleLeft, faBusSimple, faCircleQuestion} from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-check-data',
  imports: [FontAwesomeModule, CommonModule],
  templateUrl: './check-data.component.html',
  styleUrl: './check-data.component.css'
})
export class CheckDataComponent {
  @Output() sendNextStep = new EventEmitter<void>();
  serviceData = sessionStorage.getItem('serviceData');
  fiscalData = sessionStorage.getItem('fiscalData');


  entriesService: ServiceData = {
    token: '',
    date: '',
    time: '',
    service: ''
  };

  entriesFiscal : FiscalData =  {
    rfc: '',
    razonSocial: '',
    usoCfdi: '',
    regimenFiscal: '',
    correoElectronico: '',
    codigoPostal: ''
  };

  ngOnInit() {
    if (this.serviceData) {
      this.entriesService = JSON.parse(this.serviceData) as ServiceData;
    }
    if (this.fiscalData){
      this.entriesFiscal = JSON.parse(this.fiscalData) as FiscalData;
    }
  }


  faAngleLeft = faAngleLeft;
  alertNextStep(){
    console.log("Neext!")
    sessionStorage.removeItem('serviceData')
    sessionStorage.removeItem('fiscalData')
    this.sendNextStep.emit()
  }

}
interface ServiceData {
  token: string;
  date: string;
  time: string;
  service: string;
}

interface FiscalData {
  rfc: string;
  razonSocial: string;
  usoCfdi: string;
  regimenFiscal: string;
  correoElectronico: string;
  codigoPostal: string;
}