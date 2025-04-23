import { Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { ModalComponent } from './dashboard/modal/modal.component';
import { RecoveryCfdiComponent } from './dashboard/modules/recovery-cfdi/recovery-cfdi.component';

/*Se invocada cada uno de las rutas de los archivos que seran utilizados, por medio de 
* Routes, en donde, sera luego invocado en el app.config.ts
*/
export const routes: Routes = [
    {
       path: 'dashboard',
       component: DashboardComponent
    },
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: 'register',
        component: RegisterComponent
    },
    {
        path: 'modal',
        component: ModalComponent
    },
    {
        path: 'recovery-cfdi',
        component: RecoveryCfdiComponent
    },
    {
        path: '**',
        redirectTo: '/dashboard'
    }
];
