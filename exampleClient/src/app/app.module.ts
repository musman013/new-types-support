import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClient, HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { SwaggerComponent } from './swagger/swagger.component';
import { ErrorPageComponent } from './error-page/error-page.component';
import { JwtInterceptor } from './core/jwt-interceptor';
import { routingModule } from './app.routing';
import { SharedModule } from 'src/app/common/shared';
// import { CoreModule } from './core/core.module';
import { CoreExtendedModule } from './extended/core/core.module';
import { GeneralComponentsExtendedModule } from './common/general-components/extended/general-extended.module';

export function HttpLoaderFactory(httpClient: HttpClient) {
  return new TranslateHttpLoader(httpClient);
}

@NgModule({
  declarations: [ErrorPageComponent, SwaggerComponent, AppComponent],
  imports: [
    BrowserModule,
    routingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    // CoreModule,
    CoreExtendedModule,
    SharedModule,
    GeneralComponentsExtendedModule,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient],
      },
    }),
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true }],
  bootstrap: [AppComponent],
  entryComponents: [],
})
export class AppModule {}
