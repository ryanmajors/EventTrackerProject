# EventTrackerProject

## Overview
Disc golf is a big passion of mine. I play at a competitive level and love looking at how I finished each tournament. However, when I look at my professional player profile online, I am very limited in the information I can see regarding the tournaments that I've played. So much so, that the only stats I can view are the total amounts of tournaments I've played, the amount of points I've earned, and the total number of wins I have over my career. I wanted to take this a step further and see what I could do with limited time.

The basic idea of this project is a Disc Golf Tournament Tracker where you can enter in specific information about a tournament and be able to get all the statistics that everyone wants: Win percentages, average placement, counts of specific finishes(podium, top5, top10) etc. With this program, you can now do that.

At this point, the back end has been fully built out and test with JUnit and Postman.

More to come once the front end is built out.

#### How to Return

### REST API

Go to http://3.131.230.226/:8083/DGTournamentTracker/api/tournaments

### HTML/JavaScript Front End

Go to http://3.131.230.226/:8083/DGTournamentTracker/index.html

### Angular Front End

## REST API Reference
<!-- |Return Type           | HTTP Method | URI                                         | Request Body    | Purpose  |
|----------------------|-------------|---------------------------------------------|-----------------|----------|
| List \<Tournaments\> | GET         | /api/tournaments                            |                 | List     |
| Tournament           | GET         | /api/tournaments/{tournamentId}             |                 | Retrieve |
| Tournament           | GET         | /api/tournaments/{tournamentName}           |                 | Retrieve |
| Tournament           | POST        | /api/tournaments                            | Tournament JSON | Create   |
| Tournament           | PUT         | /api/tournaments/{tournamentId}             | Tournament JSON | Update   |
| Tournament           | PUT         | /api/tournaments/{tournamentId}/hide        | Tournament JSON | Update   |
| Void                 | DELETE      | /api/tournaments /{tournamentId}            |                 | Delete   |
| List \<Tournaments\> | GET         | /api/tournaments/search/keyword/{keyword}   |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/filter/location/{location} |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/filter/tier/{tier}         |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/filter/month/{month}       |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/filter/year/{year}         |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/filter/multiday/{multiDay} |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/filter/players/{players}   |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/filter/entryfee/{entryFee} |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/filter/points/{points}     |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/stats/wins                 |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/stats/podiumfinishes       |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/stats/top5finishes         |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/stats/top10finishes        |                 | List     | -->

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
| List \<Tournaments\> | GET         | /api/tournaments/filter/location/{location} |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/filter/tier/{tier}         |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/filter/month/{month}       |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/filter/year/{year}         |                 | List     |
<!-- | List \<Tournaments\> | GET         | /api/tournaments/filter/multiday/{multiDay} |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/filter/players/{players}   |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/filter/entryfee/{entryFee} |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/filter/points/{points}     |                 | List     | -->
| List \<Tournaments\> | GET         | /api/tournaments/stats/wins                 |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/stats/podiumfinishes       |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/stats/top5finishes         |                 | List     |
| List \<Tournaments\> | GET         | /api/tournaments/stats/top10finishes        |                 | List     |

## Technologies Used
+ mySQL workbench
+ mySQL
+ JPA / Hibernate / JPQL
+ Java
+ Spring MVC Boot
+ Github
+ Gradle

## Lessons Learned
One of the biggest lessons I learned by programming the backend was how much you can do with a single table. When I reached MVP with basic crud functionality, the fun really began. My mind started racing on what else I wanted to do with the application. I started with some basic stat manipulation. Then moved to listing out different tournaments by stats. Finally I wrote several more queries for my repository. Through all this, I realized how easy it is to write service methods once you have a foundation to work with.
Overall, I learned that it is very beneficial to be forward thinking when programming the service layer. Without programming the front end, I already know what I want to do with it, due to the importance of planning ahead while programming the back end.
