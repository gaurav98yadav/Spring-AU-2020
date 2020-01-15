import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';

import { ShowComponent } from './show/show.component';


const appRoutes: Routes = [
  { path: 'home', component: HomeComponent },
 // { path: 'about', component: AboutComponent },
  { path: 'show', component: ShowComponent }

  //{ path: '', redirectTo: 'home', pathMatch: 'full' },
  ];
  
@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
