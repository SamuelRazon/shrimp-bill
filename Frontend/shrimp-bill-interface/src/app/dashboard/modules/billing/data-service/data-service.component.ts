import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-data-service',
  imports: [],
  templateUrl: './data-service.component.html',
  styleUrl: './data-service.component.css'
})
export class DataServiceComponent {
  @Output() sendNextStep = new EventEmitter<void>();

  alertNextStep(){
    console.log("Neext!")
    this.sendNextStep.emit()
  }

}
