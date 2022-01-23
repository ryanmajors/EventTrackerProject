import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { HttpClientModule } from '@angular/common/http'
import { TournamentService } from './services/tournament.service';
import { TournamentYearPipe } from './pipes/tournament-year.pipe';
import { TournamentStatPipe } from './pipes/tournament-stat.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    TournamentYearPipe,
    TournamentStatPipe
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
    TournamentStatPipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
