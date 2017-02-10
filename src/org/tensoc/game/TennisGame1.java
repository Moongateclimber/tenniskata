package org.tensoc.game;

public class TennisGame1 implements TennisGame {
	private static final String FORTY = "Forty";
	private static final String WIN_FOR = "Win for";
	private static final String ADVANTAGE = "Advantage";
	private static final String DEUCE = "Deuce";
	private static final String THIRTY = "Thirty";
	private static final String FIFTEEN = "Fifteen";
	private static final String ALL = "All";
	private static final String LOVE = "Love";
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
				score = LOVE+"-"+ALL;
				break;
			case 1:
				score = FIFTEEN+"-"+ALL;
				break;
			case 2:
				score = THIRTY+"-"+ALL;
				break;
			default:
				score = DEUCE;
				break;

			}
		} else if (pointsWonByPlayer1 >= 4 || pointsWonByPlayer2 >= 4) {
			int minusResult = pointsWonByPlayer1 - pointsWonByPlayer2;
			if (minusResult == 1)
				score = ADVANTAGE+" "+player1Name;
			else if (minusResult == -1)
				score = ADVANTAGE+" "+player2Name;
			else if (minusResult >= 2)
				score = WIN_FOR+" "+player1Name;
			else
				score = WIN_FOR+" "+player2Name;
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
					score += LOVE;
					break;
				case 1:
					score += FIFTEEN;
					break;
				case 2:
					score += THIRTY;
					break;
				case 3:
					score += FORTY;
					break;
				}
			}
		}
		return score;
	}
}
