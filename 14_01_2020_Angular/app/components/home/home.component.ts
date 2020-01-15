import { Component, OnInit } from '@angular/core';
import { ServiceService } from 'src/app/providers/service.service';
import { Observable } from 'rxjs';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(public serviceService:ServiceService) {
    this.serviceService.print();
    this.serviceService.setBoy("amazing");
   }

  ngOnInit() {
    console.log("Initial")

  }
  profileForm = new FormGroup({
    id: new FormControl(''),
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    // address: new FormGroup({
    //   street: new FormControl(''),
    //   city: new FormControl(''),
    //   state: new FormControl(''),
    //   zip: new FormControl('')
    // })
  });   
onSubmit() {
  // TODO: Use EventEmitter with form value
 // console.log(this.profileForm.value);
  this.serviceService.setMan(this.profileForm.value);

}
  }

