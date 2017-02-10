package org.tensoc.game;

public class TennisGame1 implements TennisGame {
	public static final String FORTY = "Forty";
	public static final String WIN_FOR = "Win for";
	public static final String ADVANTAGE = "Advantage";
	public static final String DEUCE = "Deuce";
	public static final String THIRTY = "Thirty";
	public static final String FIFTEEN = "Fifteen";
	public static final String ALL = "All";
	public static final String LOVE = "Love";

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
		else if (playerName == player2Name)
			pointsWonByPlayer2 += 1;
	}

	private String getNamesForBasicScore(int score) {
		switch (score) {
		case 0:
			return LOVE;
		case 1:
			return FIFTEEN;
		case 2:
			return THIRTY;
		case 3:
			return FORTY;
		default:
			return "Unnamed score";
		}
	}

	public String getScore() {
		String score = "";
		if (pointsWonByPlayer1 == pointsWonByPlayer2) {
			if(pointsWonByPlayer1<3)
				score = getNamesForBasicScore(pointsWonByPlayer1)+"-"+ALL;
			else	
				score = DEUCE;
		} else if (pointsWonByPlayer1 >= 4 || pointsWonByPlayer2 >= 4) {
			int minusResult = pointsWonByPlayer1 - pointsWonByPlayer2;
			if (minusResult == 1)
				score = ADVANTAGE + " " + player1Name;
			else if (minusResult == -1)
				score = ADVANTAGE + " " + player2Name;
			else if (minusResult >= 2)
				score = WIN_FOR + " " + player1Name;
			else
				score = WIN_FOR + " " + player2Name;
		} else {
			int tempScore = 0;
			for (int i = 1; i < 3; i++) {
				if (i == 1)
					tempScore = pointsWonByPlayer1;
				else {
					score += "-";
					tempScore = pointsWonByPlayer2;
				}
				score += getNamesForBasicScore(tempScore);
			}
		}
		return score;
	}
}
