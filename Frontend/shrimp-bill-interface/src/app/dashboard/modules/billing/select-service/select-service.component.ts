import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-select-service',
  imports: [],
  templateUrl: './select-service.component.html',
  styleUrl: './select-service.component.css'
})
export class SelectServiceComponent {
 @Output() sendNextStep = new EventEmitter<void>();

  alertNextStep(){
    console.log("Neext!")
    this.sendNextStep.emit()
  }

}
