import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Tournament } from 'src/app/models/tournament';
import { TournamentStatPipe } from 'src/app/pipes/tournament-stat.pipe';
import { TournamentService } from 'src/app/services/tournament.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  title = 'Disc Golf Tournament Tracker';
  selected: Tournament | null = null;
  newTournament: Tournament = new Tournament();
  editTournament: Tournament | null = null;
  tournaments: Tournament[] = [];
  selectedYear: number | string = 'All';
  tournamentCount: number | string = 0;

  years = [
    'All',
    2021,
    2020,
    2019,
    2018
  ]

  constructor(
    private tService: TournamentService,
    private statPipe: TournamentStatPipe
  ) { };

  ngOnInit(): void {
    this.loadTournaments();
  }

  displayNumTournaments() {
    return this.statPipe.transform(this.tournaments, this.selectedYear);
  }

  displayNumPoints() {
    return this.statPipe.getPoints(this.tournaments, this.selectedYear);
  }

  displayNumWins() {
    return this.statPipe.getWins(this.tournaments, this.selectedYear);
  }

  loadTournaments() {
    this.tService.index().subscribe(
      tournament => this.tournaments = tournament,

      err => console.error('observer got an error: ' + err)
    );
  }

}
