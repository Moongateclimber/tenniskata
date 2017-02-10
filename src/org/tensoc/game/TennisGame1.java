package org.tensoc.game;

public class TennisGame1 implements TennisGame {
	private int pointsWonByPlayer1 = 0;
	private int pointsWonByPlayer2 = 0;
	private String player1Name;
	private String player2Name;

	public TennisGame1(String player1Name, String player2Name) {
		this.player1Name = player1Name;
		this.player2Name = player2Name;
	}

	public void wonPoint(String playerName) {
		if (playerName == player1Name)
			pointsWonByPlayer1 += 1;
		else if(playerName == player2Name)
			pointsWonByPlayer2 += 1;
	}

	public String getScore() {
		String score = "";
		int tempScore = 0;
		if (pointsWonByPlayer1 == pointsWonByPlayer2) {
			switch (pointsWonByPlayer1) {
			case 0:
				score = "Love-All";
				break;
			case 1:
				score = "Fifteen-All";
				break;
			case 2:
				score = "Thirty-All";
				break;
			default:
				score = "Deuce";
				break;

			}
		} else if (pointsWonByPlayer1 >= 4 || pointsWonByPlayer2 >= 4) {
			int minusResult = pointsWonByPlayer1 - pointsWonByPlayer2;
			if (minusResult == 1)
				score = "Advantage player1";
			else if (minusResult == -1)
				score = "Advantage player2";
			else if (minusResult >= 2)
				score = "Win for player1";
			else
				score = "Win for player2";
		} else {
			for (int i = 1; i < 3; i++) {
				if (i == 1)
					tempScore = pointsWonByPlayer1;
				else {
					score += "-";
					tempScore = pointsWonByPlayer2;
				}
				switch (tempScore) {
				case 0:
					score += "Love";
					break;
				case 1:
					score += "Fifteen";
					break;
				case 2:
					score += "Thirty";
					break;
				case 3:
					score += "Forty";
					break;
				}
			}
		}
		return score;
	}
}
