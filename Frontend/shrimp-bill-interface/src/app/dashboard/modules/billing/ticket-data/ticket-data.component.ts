import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-ticket-data',
  imports: [],
  templateUrl: './ticket-data.component.html',
  styleUrl: './ticket-data.component.css'
})


export class TicketDataComponent {
  constructor(private route: ActivatedRoute, private router: Router) {} 
  qrData: any;
  Router = Router



  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      const token = params['token'];
      const date = params['date'];
      const time = params['time'];
      const service = params['service']

      this.qrData = { token, date, time, service };

      // Guardar temporalmente para otras vistas si se necesita
      sessionStorage.setItem('qrData', JSON.stringify(this.qrData));

      console.log('Datos del QR:', this.qrData);

      this.router.navigate(['/billing']);
    });
  }
}
