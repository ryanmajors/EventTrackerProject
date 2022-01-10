# EventTrackerProject

## Overview

#### How to Return

### REST API

Go to http://3.131.230.226/:8083/DGTournamentTracker/api/tournaments

### HTML/JavaScript Front End

Go to http://3.131.230.226/:8083/DGTournamentTracker/index.html

### Angular Front End

## REST API Reference
|Return Type           | HTTP Method | URI                                         | Request Body    | Purpose  |
|----------------------|-------------|---------------------------------------------|-----------------|----------|
| List \<Tournaments\> | GET         | /api/tournaments                            |                 | List     |
| Tournament           | GET         | /api/tournaments/{tournamentId}             |                 | Retrieve |
| Tournament           | GET         | /api/tournaments/{tournamentName}           |                 | Retrieve |
| Tournament           | POST        | /api/tournaments                            | Tournament JSON | Create   |
| Tournament           | PUT         | /api/tournaments/{tournamentId}             | Tournament JSON | Update   |
| Tournament           | PUT         | /api/tournaments/{tournamentId}/hide        | Tournament JSON | Update   |
| Void                 | DELETE      | /api/tournaments /{tournamentId}            |                 | Delete   |
| List \<Tournaments\> | GET         | /api/tournaments/search/keyword/{keyword}   |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/search/location/{location} |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/search/tier/{tier}         |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/search/month/{month}       |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/search/year/{year}         |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/search/multiday/{multiDay} |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/search/players/{players}   |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/search/entryfee/{entryFee} |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/search/points/{points}     |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/stats/wins                 |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/stats/podiumfinishes       |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/stats/top5finishes         |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/stats/top10finishes        |                 | List     |


## Technologies Used

## Lessons Learned
