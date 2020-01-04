import {Component, OnInit} from '@angular/core';
import {HttpService} from '../../services/http.service';

@Component({
  selector: 'app-stock-list',
  templateUrl: './stock-list.component.html',
  styleUrls: ['./stock-list.component.css']
})
export class StockListComponent implements OnInit {
  public data = [];

  constructor(private http: HttpService) {
  }
  ngOnInit() {
    this.updateData();
  }

  private updateData() {
    this.http.get('/stock-service/stock').subscribe(data => {
      this.data = data;
    });
  }
}
