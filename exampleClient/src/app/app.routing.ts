import { RouterModule, Routes } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';
import { SwaggerComponent } from 'src/app/swagger/swagger.component';
import { ErrorPageComponent } from './error-page/error-page.component';

const routes: Routes = [
  {
    path: '',
    loadChildren: './extended/core/core.module#CoreExtendedModule',
  },
  { path: 'swagger-ui', component: SwaggerComponent },
  {
    path: 't1',
    loadChildren: './extended/entities/t-1/t-1.module#T1ExtendedModule',
  },
  { path: '**', component: ErrorPageComponent },
];

export const routingModule: ModuleWithProviders = RouterModule.forRoot(routes);
