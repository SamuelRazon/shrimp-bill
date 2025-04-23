import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-fiscal-data',
  imports: [],
  templateUrl: './fiscal-data.component.html',
  styleUrl: './fiscal-data.component.css'
})
export class FiscalDataComponent {
  @Output() sendNextStep = new EventEmitter<void>();

  alertNextStep(){
    console.log("Neext!")
    this.sendNextStep.emit()
  }

}
