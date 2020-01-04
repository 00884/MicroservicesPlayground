import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {HttpService} from '../services/http.service';
import {StockListComponent} from './stock-list/stock-list.component';
import {RouterModule} from '@angular/router';
import {routes} from './app.routes';
import {AdminPanelComponent} from './admin-panel/admin-panel.component';
import {LoginPageComponent} from './login-page/login-page.component';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    StockListComponent,
    AdminPanelComponent,
    LoginPageComponent
  ],
  imports: [
    BrowserModule,
    CommonModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [HttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
