import { Component, OnInit } from '@angular/core';
import { NavController } from '@ionic/angular';

@Component({
  selector: 'app-description',
  templateUrl: './description.page.html',
  styleUrls: ['./description.page.scss'],
})
export class DescriptionPage implements OnInit {

  constructor(public nav: NavController) { }

  ngOnInit() {
  }
  goback() {
    this.nav.back();
  }

}
