import { Component, OnInit } from '@angular/core';
import { Tournament } from 'src/app/models/tournament';
import { TournamentService } from 'src/app/services/tournament.service';
import { HomeComponent } from '../home/home.component';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  keyword: string = "";
  tournaments: Tournament[] =[];

  constructor(
    public homeComp: HomeComponent,
  ) { }

  ngOnInit(): void {
  }



}
