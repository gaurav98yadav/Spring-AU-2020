import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../providers/service.service';

@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css'],
})
export class ShowComponent implements OnInit {
  data=[];
  constructor(public serviceService:ServiceService) {
    this.data=this.serviceService.getMan();
    console.log(this.data);
   }
   delete(i){
     this.serviceService.deleteMan(i);
     this.data = this.serviceService.getMan();
   }
  ngOnInit() {
  }

}
