import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-check-data',
  imports: [],
  templateUrl: './check-data.component.html',
  styleUrl: './check-data.component.css'
})
export class CheckDataComponent {
  @Output() sendNextStep = new EventEmitter<void>();

  alertNextStep(){
    console.log("Neext!")
    this.sendNextStep.emit()
  }

}
