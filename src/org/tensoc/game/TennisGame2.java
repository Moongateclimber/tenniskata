package org.tensoc.game;

public class TennisGame2 implements TennisGame {
	private static final String FORTY = "Forty";
	private static final String DEUCE = "Deuce";
	private static final String ALL = "All";
	private static final String THIRTY = "Thirty";
	private static final String FIFTEEN = "Fifteen";
	private static final String LOVE = "Love";
	private static final String WIN_FOR = "Win for";
	private static final String ADVANTAGE = "Advantage";

	private int player1WonPoints;
	private int player2WonPoints;

	private String player1Name;
	private String player2Name;

	public TennisGame2(String player1Name, String player2Name) {
		this.player1Name = player1Name;
		this.player2Name = player2Name;
	}

	String getNameForPointsWon(int pointsWon) {
		switch (pointsWon) {
		case 0:
			return LOVE;
		case 1:
			return FIFTEEN;
		case 2:
			return THIRTY;
		case 3:
			return FORTY;
		default:
			return "";
		}
	}

	public String getScore() {
		String P1res = "";
		String P2res = "";

		String score = "";
		if (player1WonPoints == player2WonPoints && player1WonPoints < 3) {
			return getNameForPointsWon(player1WonPoints) + "-" + ALL;
		}
		
		if (player1WonPoints == player2WonPoints && player1WonPoints >= 3)
			return DEUCE;

		if (player1WonPoints > 0 && player2WonPoints == 0) {
			P1res = getNameForPointsWon(player1WonPoints);

			P2res = LOVE;
			score = P1res + "-" + P2res;
		}
		if (player2WonPoints > 0 && player1WonPoints == 0) {
			P2res = getNameForPointsWon(player2WonPoints);

			P1res = LOVE;
			score = P1res + "-" + P2res;
		}

		if (player1WonPoints > player2WonPoints && player1WonPoints < 4) {
			if (player1WonPoints == 2)
				P1res = THIRTY;
			if (player1WonPoints == 3)
				P1res = FORTY;
			if (player2WonPoints == 1)
				P2res = FIFTEEN;
			if (player2WonPoints == 2)
				P2res = THIRTY;
			score = P1res + "-" + P2res;
		}
		if (player2WonPoints > player1WonPoints && player2WonPoints < 4) {
			if (player2WonPoints == 2)
				P2res = THIRTY;
			if (player2WonPoints == 3)
				P2res = FORTY;
			if (player1WonPoints == 1)
				P1res = FIFTEEN;
			if (player1WonPoints == 2)
				P1res = THIRTY;
			score = P1res + "-" + P2res;
		}

		if (player1WonPoints > player2WonPoints && player2WonPoints >= 3) {
			score = ADVANTAGE + " " + player1Name;
		}

		if (player2WonPoints > player1WonPoints && player1WonPoints >= 3) {
			score = ADVANTAGE + " " + player2Name;
		}

		if (player1WonPoints >= 4 && player2WonPoints >= 0
				&& (player1WonPoints - player2WonPoints) >= 2) {
			score = WIN_FOR + " " + player1Name;
		}
		if (player2WonPoints >= 4 && player1WonPoints >= 0
				&& (player2WonPoints - player1WonPoints) >= 2) {
			score = WIN_FOR + " " + player2Name;
		}
		return score;
	}

	private void player1WonPoint() {
		player1WonPoints++;
	}

	private void player2WonPoint() {
		player2WonPoints++;
	}

	public void wonPoint(String player) {
		if (player == player1Name)
			player1WonPoint();
		else
			player2WonPoint();
	}
}