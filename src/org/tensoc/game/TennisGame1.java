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

	private int pointsWonByPlayer[] = new int[2];
	private String playerNames[] = new String[2];

	public TennisGame1(String player1Name, String player2Name) {
		this.playerNames[0] = player1Name;
		this.playerNames[1] = player2Name;
	}

	public void wonPoint(String playerName) {
		if (playerName == playerNames[0])
			pointsWonByPlayer[0] += 1;
		else if (playerName == playerNames[1])
			pointsWonByPlayer[1] += 1;
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
	
	private boolean isDeuce() {
		return pointsWonByPlayer[0] == pointsWonByPlayer[1];
	}
	
	private boolean lessThanForty(int score) {
		return score<3;
	}

	public String getScore() {
		if (isDeuce())
			if(lessThanForty(pointsWonByPlayer[0])) 
				return getNamesForBasicScore(pointsWonByPlayer[0])+"-"+ALL;
			else
				return DEUCE;

		if (pointsWonByPlayer[0] >= 4 || pointsWonByPlayer[1] >= 4) {
			int minusResult = pointsWonByPlayer[0] - pointsWonByPlayer[1];
			if (minusResult == 1)
				return ADVANTAGE + " " + playerNames[0];
			else if (minusResult == -1)
				return ADVANTAGE + " " + playerNames[1];
			else if (minusResult >= 2)
				return WIN_FOR + " " + playerNames[0];
			else
				return WIN_FOR + " " + playerNames[1];
		} else {
			String score = "";
			int tempScore = 0;
			for (int i = 1; i < 3; i++) {
				if (i == 1)
					tempScore = pointsWonByPlayer[0];
				else {
					score += "-";
					tempScore = pointsWonByPlayer[1];
				}
				score += getNamesForBasicScore(tempScore);
			}
			return score;
		}
	}
}
