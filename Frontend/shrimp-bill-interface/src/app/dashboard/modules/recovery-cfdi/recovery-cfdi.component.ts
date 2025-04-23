import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faAngleLeft} from '@fortawesome/free-solid-svg-icons';


interface Food {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-recovery-cfdi',
  imports: [FontAwesomeModule, RouterLink],
  templateUrl: './recovery-cfdi.component.html',
  styleUrl: './recovery-cfdi.component.css'
})
export class RecoveryCfdiComponent {
  faAngleLeft = faAngleLeft;
}
