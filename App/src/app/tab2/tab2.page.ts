import { Component, ViewChild } from '@angular/core';
import { Chart } from 'chart.js';

@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss']
})
export class Tab2Page {

//   @ViewChild('barChart',{static: false}) barChart;

//   bars: any;
//   colorArray: any;

//   public dataInfo:object[]=[
//     {
    
//     time:'11:00',
//     date:'2020-01-01',
//     location:true
//   },
//   {
    
//     time:'12:00',
//     date:'2020-02-01',
//     location:false
//   }
// ]


  constructor() {
    
  }
  // ionViewDidEnter() {
  //   this.createBarChart();
  // }

//   createBarChart() {
//     this.bars = new Chart(this.barChart.nativeElement, {
//       type: 'bar',
//       data: {
//         labels: ['S1', 'S2', 'S3', 'S4', 'S5', 'S6', 'S7'],
//         datasets: [{
//           label: 'attack times of past seven days',
//           data: [2.5, 3.8, 5, 6.9, 6.9, 7.5, 10],
//           backgroundColor: 'lightpink',
//           borderColor: 'lightpink',
//           borderWidth: 1
//         }]
//       },
//       options: {
//         scales: {
//           yAxes: [{
//             ticks: {
//               beginAtZero: true
//             }
//           }]
//         }
//       }
//     });
//   }

}
