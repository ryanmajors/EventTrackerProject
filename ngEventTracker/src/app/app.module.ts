import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { HttpClientModule } from '@angular/common/http'
import { TournamentService } from './services/tournament.service';
import { TournamentYearPipe } from './pipes/tournament-year.pipe';
import { TournamentCountPipe } from './pipes/tournament-count.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    TournamentYearPipe,
    TournamentCountPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    TournamentService,
    TournamentYearPipe,
    TournamentCountPipe

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
