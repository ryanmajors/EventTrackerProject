console.log("script.js loaded");

window.addEventListener("load", function (e) {
  console.log("document loaded");
  init();
  getAllTournamentData(2021);
});

function init() {
  console.log("In init()");
  // document.tournamentLookupForm.tournamentLookupButton.addEventListener('click', function(e) {
  //   e.preventDefault();
  //   var tournamentId = document.tournamentLookupForm.tournamentId.value;
  //   if(!isNaN(tournamentId) && tournamentId > 0) {
  //     getTournament(tournamentId);
  //   }
  // });

  let allTournamentsButton = document.getElementById("tournamentsButton");
  allTournamentsButton.addEventListener("click", function (e) {
    e.preventDefault();
    getAllTournaments();
  });

  let newTournamentButton = document.getElementById("addTournamentButton");
  newTournamentButton.addEventListener("click", function (e) {
    e.preventDefault();
    displayNewTournamentForm();
  });

  let addNewTournamentButton = document.getElementById('')

  let year2021 = document.getElementById("year2021");
  year2021.addEventListener("click", function (e) {
    e.preventDefault();
    let year = year2021.textContent;
    getAllTournamentData(year);
    let seasonTotalYear = document.getElementById("seasonTotals");
    seasonTotalYear.textContent = year + " Season Totals";
    let tournamentResultsYear = document.getElementById("tournamentResults");
    tournamentResultsYear.textContent = year + " Tournament Results";
  });

  let year2020 = document.getElementById("year2020");
  year2020.addEventListener("click", function (e) {
    e.preventDefault();
    let year = year2020.textContent;
    getAllTournamentData(year);
    let seasonTotalYear = document.getElementById("seasonTotals");
    seasonTotalYear.textContent = year + " Season Totals";
    let tournamentResultsYear = document.getElementById("tournamentResults");
    tournamentResultsYear.textContent = year + " Tournament Results";
  });

  let year2019 = document.getElementById("year2019");
  year2019.addEventListener("click", function (e) {
    e.preventDefault();
    let year = year2019.textContent;
    getAllTournamentData(year);
    let seasonTotalYear = document.getElementById("seasonTotals");
    seasonTotalYear.textContent = year + " Season Totals";
    let tournamentResultsYear = document.getElementById("tournamentResults");
    tournamentResultsYear.textContent = year + " Tournament Results";
  });

  let year2018 = document.getElementById("year2018");
  year2018.addEventListener("click", function (e) {
    e.preventDefault();
    let year = year2018.textContent;
    getAllTournamentData(year);
    let seasonTotalYear = document.getElementById("seasonTotals");
    seasonTotalYear.textContent = year + " Season Totals";
    let tournamentResultsYear = document.getElementById("tournamentResults");
    tournamentResultsYear.textContent = year + " Tournament Results";
  });
}

function getTournament(tournamentId) {
  let xhr = new XMLHttpRequest();
  xhr.open("GET", "api/tournaments/" + tournamentId);
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      // convert responseText to JSON
      if (xhr.status === 200) {
        //DO STUFF HERE WITH SERVER DATA
        let tournament = JSON.parse(xhr.responseText);
        displayTournamentPage(tournament);
      } else if (xhr.status === 404) {
        console.error("ERROR!!!!");
        displayError("Tournament " + tournamentId + " not found");
      } else {
        displayError("Error retrieving tournamnent: " + xhr.status);
      }
    }
  };
  xhr.send();
}

function getAllTournaments() {
  let xhr = new XMLHttpRequest();
  xhr.open("GET", "api/tournaments");
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      if (xhr.status === 200) {
        let tournaments = JSON.parse(xhr.responseText);
        displayTournamentsTable(tournaments);
      } else if (xhr.status === 404) {
        console.error("Failed to GET all tournaments");
      } else {
        displayError("Error retrieving tournaments: " + xhr.status);
      }
    }
  };
  xhr.send();
}

function getAllTournamentData(year) {
  let xhr = new XMLHttpRequest();
  xhr.open("GET", "api/tournaments/filter/year/" + year);
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      if (xhr.status === 200) {
        let tournaments = JSON.parse(xhr.responseText);
        displayTournamentsTable(tournaments);
        displayBasicStatsTable(tournaments);
      } else if (xhr.status === 404) {
        console.error("Failed to GET all tournaments");
      } else {
        displayError("Error retrieving tournaments: " + xhr.status);
      }
    }
  };
  xhr.send();
}

function createTournament(newTournament) {
  let xhr = new XMLHttpRequest();
  xhr.open("POST", "api/tournaments");
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4) {
      if (xhr.status === 200 || xhr.status === 201) {
        let tournament = JSON.parse(xhr.responseText);
        console.log(tournament)
        getAllTournamentData(2021);
      } else {
        console.error("tournament create failed with status: " + xhr.status);
      }
    }
  };
  xhr.setRequestHeader('content-type', 'application/json');
  xhr.send(JSON.stringify(newTournament))
}

function displayNewTournamentForm() {
  let addNewTournamentTitle = document.getElementById("tournamentResults");
  addNewTournamentTitle.textContent = "Add New Tournament Form";

  let tournamentFormData = document.getElementById("tournamentData");
  tournamentFormData.textContent = "";

  let tournamentForm = document.createElement("form");
  tournamentForm.id = "addTournamentForm";
  tournamentForm.name = tournamentForm.id;
  tournamentFormData.appendChild(tournamentForm);

  let nameLabel = document.createElement("label");
  nameLabel.for = "nameField";
  nameLabel.textContent = "Tournament Name";
  tournamentForm.appendChild(nameLabel);

  let nameInput = document.createElement("input");
  nameInput.class = "addTournamentFormInputFields";
  nameInput.type = "text";
  nameInput.name = "nameField";
  tournamentForm.appendChild(nameInput);

  let nameBr = document.createElement("br");
  tournamentForm.appendChild(nameBr);

  let tierLabel = document.createElement("label");
  tierLabel.for = "tierField";
  tierLabel.textContent = "Tier";
  tournamentForm.appendChild(tierLabel);

  let tierInput = document.createElement("input");
  tierInput.class = "addTournamentFormInputFields";
  tierInput.type = "text";
  tierInput.name = "tierField";
  tournamentForm.appendChild(tierInput);

  let tierBr = document.createElement("br");
  tournamentForm.appendChild(tierBr);

  let locationLabel = document.createElement("label");
  locationLabel.for = "locationField";
  locationLabel.textContent = "Location";
  tournamentForm.appendChild(locationLabel);

  let locationInput = document.createElement("input");
  locationInput.class = "addTournamentFormInputFields";
  locationInput.type = "text";
  locationInput.name = "locationField";
  tournamentForm.appendChild(locationInput);

  let locationBr = document.createElement("br");
  tournamentForm.appendChild(locationBr);

  let monthLabel = document.createElement("label");
  monthLabel.for = "monthField";
  monthLabel.textContent = "Month";
  tournamentForm.appendChild(monthLabel);

  let monthInput = document.createElement("input");
  monthInput.class = "addTournamentFormInputFields";
  monthInput.type = "text";
  monthInput.name = "monthField";
  tournamentForm.appendChild(monthInput);

  let monthBr = document.createElement("br");
  tournamentForm.appendChild(monthBr);

  let yearLabel = document.createElement("label");
  yearLabel.for = "yearField";
  yearLabel.textContent = "Year";
  tournamentForm.appendChild(yearLabel);

  let yearInput = document.createElement("input");
  yearInput.class = "addTournamentFormInputFields";
  yearInput.type = "text";
  yearInput.name = "yearField";
  tournamentForm.appendChild(yearInput);

  let yearBr = document.createElement("br");
  tournamentForm.appendChild(yearBr);

  let addTournamentButton = document.createElement("input");
  addTournamentButton.type = "submit";
  addTournamentButton.name = "createTournament";
  addTournamentButton.value = "Submit";
  tournamentForm.appendChild(addTournamentButton);

  addTournamentButton.addEventListener("click", function (e) {
    e.preventDefault();
    let f = tournamentForm;
    let newTournament = {};
    newTournament.name = f.nameField.value;
    newTournament.tier = f.tierField.value;
    newTournament.location = f.locationField.value;
    newTournament.month = f.monthField.value;
    newTournament.year = f.yearField.value;
    createTournament(newTournament);
  });
}

// display season totals for basic stats by year
function displayBasicStatsTable(tournaments) {
  let basicStatData = document.getElementById("statData");
  basicStatData.textContent = "";

  let statTable = document.createElement("table");
  statTable.id = "statTable";
  statTable.name = statTable.id;
  basicStatData.appendChild(statTable);

  let tHead = document.createElement("thead");
  statTable.appendChild(tHead);

  let tRow = document.createElement("tr");
  tHead.appendChild(tRow);

  let tournamentsPlayed = document.createElement("th");
  tournamentsPlayed.textContent = "Tournaments";
  tRow.appendChild(tournamentsPlayed);

  let seasonPoints = document.createElement("th");
  seasonPoints.textContent = "Points";
  tRow.appendChild(seasonPoints);

  let avgPointsPerTournament = document.createElement("th");
  avgPointsPerTournament.textContent = "Avg Points/Tournament";
  tRow.appendChild(avgPointsPerTournament);

  let wins = document.createElement("th");
  wins.textContent = "Wins";
  tRow.appendChild(wins);

  let tBody = document.createElement("tbody");
  statTable.appendChild(tBody);

  let row = document.createElement("tr");
  tBody.appendChild(row);

  let played = document.createElement("td");
  played.textContent = tournaments.length;
  row.appendChild(played);

  let pointsPerSeasonTotal = 0;
  let seasonWins = 0;

  for (const tournament of tournaments) {
    pointsPerSeasonTotal += tournament.points;
    if (tournament.placement === 1) {
      winCounter = 1;
      seasonWins += winCounter;
    }
  }

  let pointsPerSeason = document.createElement("td");
  pointsPerSeason.textContent = pointsPerSeasonTotal;
  row.appendChild(pointsPerSeason);

  let avgPointsPerSeason = document.createElement("td");
  avgPointsPerSeason.textContent =
    Math.round((pointsPerSeasonTotal / tournaments.length) * 100) / 100;
  row.appendChild(avgPointsPerSeason);

  let winsPerSeason = document.createElement("td");
  winsPerSeason.textContent = seasonWins;
  row.appendChild(winsPerSeason);
}

// display all stats and organize by year in table.
function displayAllStats() {}

function displayError(msg) {
  var tournamentDiv = document.getElementById("tournamentData");
  tournamentDiv.textContent = msg;
}

function displayTournamentPage(tournament) {
  let tournamentData = document.getElementById("tournamentData");
  tournamentData.textContent = "";

  let tournamentDetails = document.createElement("ul");
  tournamentData.appendChild(tournamentDetails);

  let tournamentName = document.createElement("h5");
  tournamentName.textContent = tournament.name;
  tournamentData.appendChild(tournamentName);

  let tier = document.createElement("li");
  tier.textContent = "Tier: " + tournament.tier;
  tournamentData.appendChild(tier);

  let location = document.createElement("li");
  location.textContent = "Location: " + tournament.location;
  tournamentData.appendChild(location);

  let date = document.createElement("li");
  date.textContent = "Date: " + tournament.month + "/" + tournament.year;
  tournamentData.appendChild(date);

  let players = document.createElement("li");
  players.textContent = "Players: " + tournament.players;
  tournamentData.appendChild(players);

  let br = document.createElement("br");
  tournamentData.appendChild(br);

  let updateButton = document.createElement("button");
  updateButton.textContent = "UPDATE";
  tournamentData.appendChild(updateButton);

  let deleteButton = document.createElement("button");
  deleteButton.textContent = "DELETE";
  tournamentData.appendChild(deleteButton);
}

function displayTournamentsTable(tournaments) {
  let tournamentData = document.getElementById("tournamentData");
  tournamentData.textContent = "";

  let tournamentTable = document.createElement("table");
  tournamentTable.id = "tournamentTable";
  tournamentTable.name = tournamentTable.id;
  tournamentData.appendChild(tournamentTable);

  let tHead = document.createElement("thead");
  tournamentTable.appendChild(tHead);

  let tRow = document.createElement("tr");
  tHead.appendChild(tRow);

  let place = document.createElement("th");
  place.textContent = "Place";
  tRow.appendChild(place);

  let points = document.createElement("th");
  points.textContent = "Points";
  tRow.appendChild(points);

  let tournamentName = document.createElement("th");
  tournamentName.textContent = "Tournament";
  tRow.appendChild(tournamentName);

  let tier = document.createElement("th");
  tier.textContent = "Tier";
  tRow.appendChild(tier);

  let date = document.createElement("th");
  date.textContent = "Date";
  tRow.appendChild(date);

  let tBody = document.createElement("tbody");
  tournamentTable.appendChild(tBody);

  for (const tournament of tournaments) {
    let row = document.createElement("tr");

    let place = document.createElement("td");
    place.textContent = tournament.placement;
    row.appendChild(place);

    let points = document.createElement("td");
    points.textContent = tournament.points;
    row.appendChild(points);

    let tournamentName = document.createElement("td");
    tournamentName.textContent = tournament.name;
    row.appendChild(tournamentName);

    let tier = document.createElement("td");
    tier.textContent = tournament.tier;
    row.appendChild(tier);

    let date = document.createElement("td");
    date.textContent = tournament.month + "/" + tournament.year;
    row.appendChild(date);
    row.addEventListener("click", function (e) {
      e.preventDefault();
      getTournament(tournament.id);
    });
    tBody.appendChild(row);
  }
}
