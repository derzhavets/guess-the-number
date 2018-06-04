let game = {};

function startGame() {
  game = {};
  game.playerName = element("player-name").value;
  showGameBoard();
  requestNewGame();
}

function showGameBoard() {
  element("intro-block").hidden = true;
  element("game-block").hidden = false;
}

function requestNewGame(playerName) {
  let req = new XMLHttpRequest();
  req.open("GET", "http://localhost:8080/gtn-web-1/api/game/new/" + game.playerName);
  req.send();
  req.onreadystatechange = function() {
    if (req.status === 200 && req.readyState === 4) {
      game.id = req.responseText;
      console.log("Started new game with id: " + game.id);
    }
  }
}

function makeGuess() {
  let guess = {};
  guess.guessedNumber = element("player-guess").value;
  element("player-guess").value = null;
  guess.gameId = game.id;
  postGuess(guess);
}

function postGuess(guess) {
  let req = new XMLHttpRequest();
  req.open("POST", "http://localhost:8080/gtn-web-1/api/game/makeGuess");
  req.setRequestHeader("Content-Type", "application/json");
  req.send(JSON.stringify(guess));
  req.onreadystatechange = function() {
    if (req.status === 200 && req.readyState === 4) {
      let status = req.getResponseHeader("Game-Status");
      if (status == "CONTINUES") {
        getAllGuesses();
      } else if (status == "WON_AND_SAVED") {
        getAllGuesses();
        showScoreTable();
      }
    }
  }
}

function getAllGuesses() {
  let req = new XMLHttpRequest();
  req.open("GET", "http://localhost:8080/gtn-web-1/api/game/getAllGuesses/" + game.id);
  req.setRequestHeader("Content-Type", "application/json");
  req.send();
  req.onreadystatechange = function() {
    if (req.status === 200 && req.readyState === 4) {
      console.log("Receved quesses: " + req.responseText);
      printGuesses(JSON.parse(req.responseText));
    }
  }
}

function printGuesses(guesses) {
  element("guess-table").innerHTML = "";
  for (var i = 0; i < guesses.length; i++) {
    let guess = guesses[i];
    element("guess-table").innerHTML += "<tr>" +
      "<td>" + guess.guessNumber + "</td>" +
      "<td>" + guess.guessedNumber + "</td>" +
      "<td><span class='label orange'>" + guess.correctNumbers + "</span>" +
      "<span class='label green'>" + guess.correctPositions + "</span></td></tr>";
  }
}

function showScoreTable() {
  element("game-header").innerHTML = "You are the champion, " + game.playerName;
  element("scores-block").hidden = false;
  requestScores();
  toggleButtons();
}

function requestScores() {
  let req = new XMLHttpRequest();
  req.open("GET", "http://localhost:8080/gtn-web-1/api/scores/getBest");
  req.setRequestHeader("Content-Type", "application/json");
  req.send();
  req.onreadystatechange = function() {
    if (req.status === 200 && req.readyState === 4) {
      console.log(req.responseText);

      let scores = JSON.parse(req.responseText);
      printScores(scores);
    }
  }
}

function printScores(scores) {
  element("scores-table").innerHTML = "";
  let place = 1;
  for (var i = 0; i < scores.length; i++) {
    let score = scores[i];
    element("scores-table").innerHTML += "<tr>" +
      "<td>" + place + "</td>" +
      "<td>" + score.player_name + "</td>" +
      "<td>" + score.player_score + "</td></tr>";
    place++;
  }
}

function restartGame() {
  element("game-block").hidden = true;
  element("intro-block").hidden = false;
  element("scores-block").hidden = true;
  element("start-button").hidden = true;
  element("guess-table").innerHTML = null;
  element("game-header").innerHTML = "Enter your guess"
  element("guess-table").innerHTML = "";
  toggleButtons();
}

function toggleButtons() {
  let input = element("enter-number");
  input.hidden = input.hidden ? false : true;
  let button = element("start-button");
  button.hidden = input.hidden ? false : true;
}

function element(id) {
  return document.getElementById(id);
}
