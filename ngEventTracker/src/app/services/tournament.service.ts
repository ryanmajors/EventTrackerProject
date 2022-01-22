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





}
