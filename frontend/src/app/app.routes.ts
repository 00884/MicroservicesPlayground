import {Route} from '@angular/router';
import {StockListComponent} from './stock-list/stock-list.component';
import {AdminPanelComponent} from './admin-panel/admin-panel.component';
import {LoginPageComponent} from './login-page/login-page.component';

export const routes: Route[] = [
  {path: '', component: StockListComponent},
  {path: 'admin', component: AdminPanelComponent},
  {path: 'login', component: LoginPageComponent}
];
