import { bootstrapApplication } from '@angular/platform-browser';
import { provideHttpClient } from '@angular/common/http';
import { AppComponent } from './app/app.component';
import { appConfig } from './app/app.config';

bootstrapApplication(AppComponent, {
  ...appConfig,
  providers: [
    // Primero se toman los providers existentes de appConfig para las rutas
    ...(appConfig.providers ?? []),
    // Despues se agregan los nuevos providers
    provideHttpClient()
  ]
})
.catch(err => console.error(err));
