import { Pipe, PipeTransform } from '@angular/core';
import { Tournament } from '../models/tournament';

@Pipe({
  name: 'tournamentYear'
})
export class TournamentYearPipe implements PipeTransform {

  transform(tournaments: Tournament[], tournamentYear: number | string): Tournament[] {
    let results: Tournament[] = [];
    if(tournamentYear === "All") {
      return tournaments;
    }
    tournaments.forEach(tournament => {
      if(tournament.year === tournamentYear) {
        results.push(tournament);
      }
    })
    return results;
  }

}
