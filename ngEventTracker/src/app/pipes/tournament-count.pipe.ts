import { Pipe, PipeTransform } from '@angular/core';
import { Tournament } from '../models/tournament';

@Pipe({
  name: 'tournamentCount'
})
export class TournamentCountPipe implements PipeTransform {

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

}
