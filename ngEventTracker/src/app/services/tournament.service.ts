import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TournamentService {

  private baseUrl = 'http://localhost:8083/';
  private url = 'api/tournaments'

  constructor(
    private http: HttpClient
  ) { }

}
