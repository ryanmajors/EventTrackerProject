import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { catchError, Observable, throwError } from 'rxjs';
import { Tournament } from '../models/tournament';

@Injectable({
  providedIn: 'root'
})
export class TournamentService {

  private baseUrl = 'http://localhost:8083/';
  private url = this.baseUrl + 'api/tournaments';

  constructor(
    private http: HttpClient
  ){};



  index(): Observable<Tournament[]> {
    return this.http.get<Tournament[]>(this.url).pipe(
      catchError( (error: any) => {
        console.error("TournamentService.show(): error finding tournaments");
        console.error(error);
        return throwError(
          () => new Error(
            "TournamentService.show(): error finding todo: " + error
          )
        )
      })
    );
  }

  show(tournamentId: number): Observable<Tournament> {
    return this.http.get<Tournament>(this.url + "/" + tournamentId,).pipe(
      catchError( (error: any) => {
        console.error("TournamentService.show(): error finding tournament:");
        console.error(error);
        return throwError(
          () => new Error(
            "TournamentService.show(): error finding tournament: " + error
          )
        )
      })
    );
  }

  searchKeyword(keyword: string): Observable<Tournament[]> {
    return this.http.get<Tournament[]>(this.url + "/search/keyword/" + keyword).pipe(
      catchError( (error: any) => {
        console.error("TournamentService.show(): error finding tournaments by keyword:");
        console.error(error);
        return throwError(
          () => new Error(
            "TournamentService.show(): error finding tournaments by keyword: " + error
          )
        )
      })
    );
  }

  create(tournament: Tournament): Observable<Tournament> {
    tournament.hidden = false;
    return this.http.post<Tournament>(this.url, tournament).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error(
            "TournamentService.create(): error creating Tournament"
          )
        );
      })
    )
  }

  update(tournament: Tournament): Observable<Tournament> {
    return this.http.put<Tournament>(this.url + "/" + tournament.id, tournament).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error(
            'TournamentService.update(); error updating tournament'
          )
        );
      })
    )
  }

  delete(tournamentId: number): Observable<void> {
    return this.http.delete<void>(this.url + "/" + tournamentId).pipe(
      catchError( (problem: any) => {
        console.error('TodoService.delete(): error deleting tournament: ');
        console.error(problem);
          return throwError(
          () => new Error(
            'TournamentService.delete(): error deleting tournament'
          )
        );
      })
    )
  }



}
