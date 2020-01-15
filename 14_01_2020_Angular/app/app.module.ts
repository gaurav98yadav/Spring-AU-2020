import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FirstCompComponent } from './components/first-comp/first-comp.component';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { PageNotFoundComponentComponent } from './components/page-not-found-component/page-not-found-component.component'
import { ReactiveFormsModule } from '@angular/forms';
import { ShowComponent } from './show/show.component';
import { ServiceService } from './providers/service.service';


@NgModule({
  declarations: [
    AppComponent,
    FirstCompComponent,
    HomeComponent,
    AboutComponent,
    PageNotFoundComponentComponent,
    ShowComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [ServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
