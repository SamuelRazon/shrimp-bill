import { Component, EventEmitter, Output } from '@angular/core';
import { RouterLink } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faBusSimple, faAppleWhole, faBox, faAngleLeft, faQrcode } from '@fortawesome/free-solid-svg-icons';
import { ScanQrComponent } from "./scan-qr/scan-qr.component";

@Component({
  selector: 'app-select-service',
  imports: [FontAwesomeModule, RouterLink, ScanQrComponent],
  templateUrl: './select-service.component.html',
  styleUrl: './select-service.component.css'
})
export class SelectServiceComponent {
 @Output() sendNextStep = new EventEmitter<void>();
 showScanQr = false;
 noCameraError = false; 

  alertNextStep(){
    console.log("Neext!")
    this.sendNextStep.emit()
  }

  async toggleScanQr() {
    const hasCamera = await this.checkForCameras();
    if (hasCamera) {
      this.noCameraError = false;
      this.showScanQr = !this.showScanQr; // Alterna la visibilidad
    } else {
      this.noCameraError = true; // Muestra el error si no hay cámaras
    }
  }

  async checkForCameras(): Promise<boolean> {
    try {
      const devices = await navigator.mediaDevices.enumerateDevices();
      const videoDevices = devices.filter(device => device.kind === 'videoinput');
      return videoDevices.length > 0; // Devuelve true si hay cámaras disponibles
    } catch (error) {
      console.error('Error al verificar las cámaras:', error);
      return false;
    }
  }

  faBusSimple = faBusSimple;
  faAppleWhole = faAppleWhole;
  faBox = faBox;
  faAngleLeft = faAngleLeft;
  faQrcode = faQrcode;
}
