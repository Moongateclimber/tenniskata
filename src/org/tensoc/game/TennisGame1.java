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

	private int pointsWonByPlayers[] = new int[2];
	private String playerNames[] = new String[2];

	public TennisGame1(String player1Name, String player2Name) {
		this.playerNames[0] = player1Name;
		this.playerNames[1] = player2Name;
	}

	public void wonPoint(String playerName) {
		if (playerName == playerNames[0])
			pointsWonByPlayers[0] += 1;
		else if (playerName == playerNames[1])
			pointsWonByPlayers[1] += 1;
	}

	public String getScore() {
		if (isDeuce())
			if (lessThanForty(pointsWonByPlayers[0]))
				return getNamesForBasicScore(pointsWonByPlayers[0]) + "-" + ALL;
			else
				return DEUCE;

		if (moreThanForty(pointsWonByPlayers[0])
				|| moreThanForty(pointsWonByPlayers[1]))
			for (int i = 0; i < 2; i++) {
				if (pointsWonByPlayers[i] == pointsWonByPlayers[otherPlayerIndex(i)] + 1)
					return ADVANTAGE + " " + playerNames[i];
				if (pointsWonByPlayers[i] > pointsWonByPlayers[otherPlayerIndex(i)] + 1)
					return WIN_FOR + " " + playerNames[i];
			}

		return getNamesForBasicScore(pointsWonByPlayers[0]) + "-"
				+ getNamesForBasicScore(pointsWonByPlayers[1]);
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
		return pointsWonByPlayers[0] == pointsWonByPlayers[1];
	}

	private boolean lessThanForty(int score) {
		return score < 3;
	}

	private boolean moreThanForty(int score) {
		return score >= 4;
	}

	private int otherPlayerIndex(int playerIndex) {
		return (playerIndex + 1) % 2;
	}

}
