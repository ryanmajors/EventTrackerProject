import { Pipe, PipeTransform } from '@angular/core';
import { Tournament } from '../models/tournament';

@Pipe({
  name: 'tournamentCount'
})
export class TournamentStatPipe implements PipeTransform {

  transform(tournaments: Tournament[], tournamentYear: number | string): number {
    let tournamentCount = 0;
    tournaments.forEach(tournament => {
      if(tournamentYear === tournament.year) {
          tournamentCount +=1;
      } else if (tournamentYear === 'All'){
          tournamentCount +=1;
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

  getPointsPerTournament(tournaments: Tournament[], tournamentYear: number | string): number {
    let totalTournaments = this.transform(tournaments, tournamentYear);
    let totalPoints = this.getPoints(tournaments, tournamentYear);
    return Math.round((totalPoints/totalTournaments)*100)/100;
  }

  getNumWins(tournaments: Tournament[], tournamentYear: number | string): number {
    let tournamentWinCount: number = 0;

    tournaments.forEach(tournament => {
      if(tournamentYear === tournament.year) {
        if(tournament.placement === 1) {
          tournamentWinCount +=1;
        }
      } else if (tournamentYear === 'All'){
        if(tournament.placement === 1 ) {
          tournamentWinCount +=1;
        }
      }
    });

    return tournamentWinCount;
  }

  getWinPercentage(tournaments: Tournament[], tournamentYear: number | string): number {
    let totalTournaments = this.transform(tournaments, tournamentYear);
    let numWins = this.getNumWins(tournaments, tournamentYear);
    return Math.round((numWins/totalTournaments)*100)/100;
  }

  getNumPodiumFinishes(tournaments: Tournament[], tournamentYear: number | string): number {
    let podiumCount: number = 0;

    tournaments.forEach(tournament => {
      if(tournamentYear === tournament.year) {
        if(tournament.placement <= 3) {
          podiumCount +=1;
        }
      } else if (tournamentYear === 'All'){
        if(tournament.placement <= 3 ) {
          podiumCount +=1;
        }
      }
    });

    return podiumCount;
  }

  getPodiumPercentage(tournaments: Tournament[], tournamentYear: number | string): number {
    let totalTournaments = this.transform(tournaments, tournamentYear);
    let totalPodiumFinishes = this.getNumPodiumFinishes(tournaments, tournamentYear);
    return Math.round((totalPodiumFinishes/totalTournaments)*100)/100;
  }

  getNumTop5Finishes(tournaments: Tournament[], tournamentYear: number | string): number {
    let top5Count: number = 0;

    tournaments.forEach(tournament => {
      if(tournamentYear === tournament.year) {
        if(tournament.placement <= 5) {
          top5Count +=1;
        }
      } else if (tournamentYear === 'All'){
        if(tournament.placement <= 5 ) {
          top5Count +=1;
        }
      }
    });

    return top5Count;

  }

  getTop5Percentage(tournaments: Tournament[], tournamentYear: number | string): number {
    let totalTournaments = this.transform(tournaments, tournamentYear);
    let totalTop5Finishes = this.getNumTop5Finishes(tournaments, tournamentYear);
    return Math.round((totalTop5Finishes/totalTournaments)*100)/100;
  }

  getNumTop10Finishes(tournaments: Tournament[], tournamentYear: number | string): number {
    let top10Count: number = 0;

    tournaments.forEach(tournament => {
      if(tournamentYear === tournament.year) {
        if(tournament.placement <= 10) {
          top10Count +=1;
        }
      } else if (tournamentYear === 'All'){
        if(tournament.placement <= 10 ) {
          top10Count +=1;
        }
      }
    });

    return top10Count;
  }

  getTop10Percentage(tournaments: Tournament[], tournamentYear: number | string): number {
    let totalTournaments = this.transform(tournaments, tournamentYear);
    let totalTop10Finishes = this.getNumTop10Finishes(tournaments, tournamentYear);
    return Math.round((totalTop10Finishes/totalTournaments)*100)/100;
  }
}
