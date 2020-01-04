import {Component} from '@angular/core';
import {HttpService} from '../services/http.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';

  public data = [];

  constructor(private http: HttpService) {
    this.getData();
  }

  public addStockItem() {
    this.http.post('/stock-service/stock', {name: Math.random().toString()}).subscribe();
  }

  public getData() {
    this.http.get('/stock-service/stock').subscribe(data => {
      this.data = data;
    });
  }
}
