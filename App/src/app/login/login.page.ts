import { Component, OnInit } from '@angular/core';
// import {HttpClient, HttpHeaders} from '@angular/common/http';
// import { RouterLink } from '@angular/router';
// import { Device } from '@ionic-native/device/ngx';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {

  constructor() { }

  ngOnInit() {
    // console.log('Device UUID is: ' + this.device.uuid);
  }

  login(){


    // let username:any=document.getElementById("username");
    // let password:any=document.getElementById("uuid");

    // const httpOptions={
    //   headers: new HttpHeaders({'Content-Type':'application/json'})
    // };

    // // alert(dusername.value);
    // // JSON.stringify(User)
    // var api="http://localhost:8080/login";
    // this.http.post(api,{username:username.value,password:password.value},httpOptions).subscribe(response =>{
    //   console.log(response);
    
    // });
    
    // this.http.get(api).subscribe((response)=>{console.log(response);});

  }

}
