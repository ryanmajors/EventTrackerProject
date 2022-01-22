import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Tournament } from 'src/app/models/tournament';
import { TournamentCountPipe } from 'src/app/pipes/tournament-count.pipe';
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
    private countPipe: TournamentCountPipe
  ) { };

  ngOnInit(): void {
    this.loadTournaments();
  }

  displayNumTournaments() {
    return this.countPipe.transform(this.tournaments, this.selectedYear);
  }

  loadTournaments() {
    this.tService.index().subscribe(
      tournament => this.tournaments = tournament,

      err => console.error('observer got an error: ' + err)
    );
  }

}
