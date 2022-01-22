import { Pipe, PipeTransform } from '@angular/core';
import { Tournament } from '../models/tournament';

@Pipe({
  name: 'tournamentCount'
})
export class TournamentStatPipe implements PipeTransform {

  transform(tournaments: Tournament[], tournamentYear: number | string): number {
    let tournamentCount = tournaments.length;
    let filteredTournaments: Tournament[] = [];
    if(tournamentYear === 'All') {
      return tournamentCount;
    };
    tournaments.forEach(tournament => {
      if(tournament.year === tournamentYear) {
        filteredTournaments.push(tournament);
        tournamentCount += filteredTournaments.length;
      }
    });

    return tournamentCount;
  }

  getPoints(tournaments: Tournament[], tournamentYear: number | string): number {
    let tournamentPointCount: number = 0;

    if(tournamentYear === 'All') {
      tournaments.forEach(tournament => {
        tournamentPointCount += tournament.points;
      });
      return tournamentPointCount
    } else {
      tournaments.forEach(tournament => {
        if (tournament.year === tournamentYear) {
          tournamentPointCount += tournament.points;
        }
      })
      return tournamentPointCount;
    }
  }

  getWins(tournaments: Tournament[], tournamentYear: number | string): number {
    let tournamentWinCount: number = 0;

    tournaments.forEach(tournament => {
      if(tournamentYear === tournament.year) {
        if(tournament.placement === 1) {
          tournamentWinCount +=1;
        }
      } else if (tournamentYear === 'All') {
        if(tournament.placement === 1 ) {
          tournamentWinCount +=1;
        }
      }
    });

    return tournamentWinCount;
  }
}
