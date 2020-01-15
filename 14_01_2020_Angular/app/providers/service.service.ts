import { Injectable } from '@angular/core';

@Injectable()
export class ServiceService {
gmy:string="ssup";
data=[];
testObject = {};
retrievedObject;

// Put the object into storage

// Retrieve the object from storage

  constructor() { 
  }
  print(){
    console.log("Service Called")
  }
  setBoy(gmy)
  {
    this.gmy=gmy;
  }
  getBoy()
  {
    console.log(this.gmy);
  }
  setMan(values)
  {
    this.data.push(values)
    localStorage.setItem('testObject', JSON.stringify(values));

   this.retrievedObject = localStorage.getItem('testObject');
   console.log('retrievedObject: ', JSON.parse(this.retrievedObject)); 
    console.log(this.data);
  }

  deleteMan(index) {
    this.data.splice(index,1);
  }
  getMan()
  {
    return this.data;
  }


  
}
