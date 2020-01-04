import {Component, OnInit} from '@angular/core';
import {HttpService} from '../../services/http.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  public login = '';
  public password = '';

  constructor(private http: HttpService) {
  }

  ngOnInit() {
  }

  public signIn() {
    this.http.post('/auth-service/users/create',
      {username: this.login, password: this.password})
      .subscribe();
  }

}
