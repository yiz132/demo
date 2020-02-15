import { Component, OnInit } from '@angular/core';
import {UsersService} from '../../services/users.service';
import {Cookie} from 'ng2-cookies/ng2-cookies';
import {User} from '../models/User';
// import {HttpClient, HttpHeaders} from '@angular/common/http';
// import { RouterLink } from '@angular/router';
// import { Device } from '@ionic-native/device/ngx';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {
  user: User;
  constructor(public userService: UsersService) {
    this.user = JSON.parse(Cookie.get('user'));
    if (this.user == null) {
      this.user = new User();
    } else {
      console.log('login');
      // this.navCtrl.setRoot(ReportsPage);
    }
  }

  ngOnInit() {
    // console.log('Device UUID is: ' + this.device.uuid);
  }

  login() {
    this.userService.login(this.user).subscribe(result => {
      this.user = result;
      if (this.user.error.startsWith('Success')) {
        //set the user in the cookie so you don't get to log in again
        Cookie.set('user', JSON.stringify(this.user));
        //forward to the default page
        console.log('login');
        // this.navCtrl.setRoot(ReportsPage);
      } else {
        // nothing to do. Error message will be displayed.
      }
    });

  }

}
