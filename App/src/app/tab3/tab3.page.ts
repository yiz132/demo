import { Component } from '@angular/core';

@Component({
  selector: 'app-tab3',
  templateUrl: 'tab3.page.html',
  styleUrls: ['tab3.page.scss']
})
export class Tab3Page {



  public userInfo:any={
    username:'Cyan',
    email:'xxxx@xxx',
    birthday:'1995-10-24'
  }

  constructor() {}

}
