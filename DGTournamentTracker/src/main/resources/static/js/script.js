console.log("script.js loaded");

window.addEventListener("load", function (e) {
  console.log("document loaded");
  init();
});

function init() {
  console.log("In init()");
  document.tournamentLookupForm.tournamentLookupButton.addEventListener('click', function(e) {
    e.preventDefault();
    var tournamentId = document.tournamentLookupForm.tournamentId.value;
    if(!isNaN(tournamentId) && tournamentId > 0) {
      getTournament(tournamentId);
    }
  });
  // TODO - setup event listeners for forms, etc.
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
        displayTournamentPreview(tournament);
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

function displayError(msg) {
	var tournamentDiv = document.getElementById('tournamentData');
	tournamentDiv.textContent = msg;
}

function displayTournamentPreview(tournament) {
  let tournamentData = document.getElementById('tournamentData');
  tournamentData.textContent = '';

  let tournamentDetails = document.createElement('ul')
  tournamentData.appendChild(tournamentDetails);

  let tournamentName = document.createElement('h5');
  tournamentName.textContent = tournament.name;
  tournamentData.appendChild(tournamentName);

  let tier = document.createElement('li');
  tier.textContent = 'Tier: ' + tournament.tier;
  tournamentData.appendChild(tier);

  let location = document.createElement('li');
  location.textContent = 'Location: ' + tournament.location;
  tournamentData.appendChild(location);

  let date = document.createElement('li');
  date.textContent = 'Date: ' + tournament.month + '/' + tournament.year;
  tournamentData.appendChild(date);

  // let players = document.createElement('li');
  // players.textContent = 'Players: ' + tournament.players;
  // tournamentData.appendChild(players);
}

function displayTournamentsAllPreview() {
  
}
