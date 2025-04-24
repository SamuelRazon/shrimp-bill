import { Component } from '@angular/core';
import { ZXingScannerModule } from '@zxing/ngx-scanner';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BarcodeFormat } from '@zxing/library';
@Component({
  selector: 'app-scan-qr',
  imports: [ZXingScannerModule],
  
  templateUrl: './scan-qr.component.html',
  styleUrl: './scan-qr.component.css',
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ]
})
export class ScanQrComponent {
  public BarcodeFormat = BarcodeFormat;
  onCodeResult(result: string) {
    console.log('Contenido del QR:', result);
    

    // Ejemplo: extraer valores de una URL tipo
    // https://localhost:4200/ticket-data?token=abc123&date=20%2F04%2F2025&fecha=12%3A30
    const queryString = result.split('?')[1];
    const params = new URLSearchParams(queryString);

    const token = params.get('token');
    const date = params.get('date');
    const time = params.get('fecha');

    console.log({ token, date, time });

    // Aquí puedes guardar temporalmente en sessionStorage
    sessionStorage.setItem('qrData', JSON.stringify({ token, date, time }));
  }
}
