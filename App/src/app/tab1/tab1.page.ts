
import { Component, OnInit } from '@angular/core';
// import {HttpClient, HttpHeaders} from '@angular/common/http';
// import { RouterLink } from '@angular/router';

import sd from 'silly-datetime';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page {


  // public nowDate;
  // public nowTime;

  public reportInfo: any = {
    temperature: 37.5,
    description:'xxxxx'
  }


  bolConfirm:boolean = true;

  bolPage:boolean = true

  // constructor(private http: HttpClient) {
    constructor() {
    // var d = new Date();
    // //UTC/GMT
    // var offset = new Date(d.getTime() + d.getTimezoneOffset() * 60000);


    // this.nowDate = sd.format(offset, 'YYYY-MM-DD');
    // this.nowTime = sd.format(offset, 'HH:mm');
    // this.nowDate = sd.format(new Date(), 'YYYY-MM-DD');
    // this.nowTime = sd.format(new Date(), 'HH:mm');
    // this.collectInfo.time = this.nowTime;
    // this.collectInfo.date = this.nowDate;
    

  }
  // ngOnInit() { 
  //   setTimeout(()=>{
  //        document.getElementById("matInputEle").focus();
  //   },1);
//  }

ionViewCanLeave() {
 
  if (this.bolPage) {    
    return true;
  } else if (this.bolConfirm) {    
    return true;
  } else {
    new Promise((resolve, reject) => {
      alert(1);
      

    });
  }

  return false;


}
}
