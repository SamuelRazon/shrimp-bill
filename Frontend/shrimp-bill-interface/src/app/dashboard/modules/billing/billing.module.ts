import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ZXingScannerModule } from '@zxing/ngx-scanner';


@NgModule({
  declarations: [],
  imports: [
    ZXingScannerModule,
    CommonModule
  ]
})
export class BillingModule { }
