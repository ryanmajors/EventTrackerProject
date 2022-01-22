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
  formSelected: boolean = false;
  updateFormSelected: boolean = true;


  years = [
    'All',
    2021,
    2020,
    2019,
    2018
  ]

  constructor(
    private tService: TournamentService,
    private statPipe: TournamentStatPipe,
    private route: ActivatedRoute,
    private router: Router
  ) { };

  ngOnInit(): void {
    let tournamentIdStr = this.route.snapshot.paramMap.get('id');
    if (!this.selected && tournamentIdStr) {
      let tournamentId = Number.parseInt(tournamentIdStr);
      if ( !isNaN(tournamentId)) {
        this.tService.show(tournamentId).subscribe({
          next: (tournament: Tournament | null) => {
            this.selected = tournament;
          },
          error: (fail: string) => {
            console.error('TodoListComponent.ngOnInit(): invalid tournamentId' + fail);
            this.router.navigateByUrl("tournamentnotfound")
          }
        });
      } else {
        this.router.navigateByUrl('invalidTodoId');
      }
    }
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

  setEditTournament(){
    this.editTournament = Object.assign({}, this.selected);
  }

  addTournament(tournament: Tournament) {
      this.tService.create(tournament).subscribe(
        tournament => {
          this.newTournament = new Tournament();
          this.loadTournaments();
        },
        fail => {
          console.error('Error creating tournament');
          console.error(fail);

        }
      );
  }

  updateTournament(tournament: Tournament, goToDetails = true): void {
    this.tService.update(tournament).subscribe({
      next: (t) => {
        this.editTournament = null;
        if(goToDetails) {
          this.selected = t;
        }
        this.loadTournaments();
      },
      error: (fail) => {
        console.error('TournamentComponent.updateTournament(): error on update');
        console.error(fail);
      }
    })
  }
}
