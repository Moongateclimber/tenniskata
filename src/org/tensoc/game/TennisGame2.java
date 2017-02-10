package org.tensoc.game;

public class TennisGame2 implements TennisGame {
	public static final String FORTY = "Forty";
	public static final String DEUCE = "Deuce";
	public static final String ALL = "All";
	public static final String THIRTY = "Thirty";
	public static final String FIFTEEN = "Fifteen";
	public static final String LOVE = "Love";
	public static final String WIN_FOR = "Win for";
	public static final String ADVANTAGE = "Advantage";

	private int player1WonPoints;
	private int player2WonPoints;

	private String player1Name;
	private String player2Name;

	public TennisGame2(String player1Name, String player2Name) {
		this.player1Name = player1Name;
		this.player2Name = player2Name;
	}

	private static String getNameForPointsWon(int pointsWon) {
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

	private boolean advantagePlayer1() {
		return advantage(player1WonPoints, player2WonPoints);
	}

	private boolean advantagePlayer2() {
		return advantage(player2WonPoints, player1WonPoints);
	}

	private static boolean advantage(int firstPlayerPoints,
			int secondPlayerPoints) {
		return firstPlayerPoints == secondPlayerPoints + 1
				&& secondPlayerPoints >= 3;
	}

	private boolean winPlayer1() {
		return win(player1WonPoints, player2WonPoints);
	}

	private boolean winPlayer2() {
		return win(player2WonPoints, player1WonPoints);
	}

	private static boolean win(int firstPlayerPoints, int secondPlayerPoints) {
		return firstPlayerPoints >= 4
				&& (firstPlayerPoints - secondPlayerPoints) >= 2;
	}

	public String getScore() {
		if (player1WonPoints == player2WonPoints && player1WonPoints < 3)
			return getNameForPointsWon(player1WonPoints) + "-" + ALL;

		if (player1WonPoints == player2WonPoints && player1WonPoints >= 3)
			return DEUCE;

		if (advantagePlayer1())
			return getAdvantageMessage(player1Name);

		if (advantagePlayer2())
			return getAdvantageMessage(player2Name);

		if (winPlayer1())
			return getWinMessage(player1Name);

		if (winPlayer2())
			return getWinMessage(player2Name);

		return getNameForPointsWon(player1WonPoints) + "-"
				+ getNameForPointsWon(player2WonPoints);
	}

	private static String getAdvantageMessage(String name) {
		return ADVANTAGE + " " + name;
	}

	private static String getWinMessage(String name) {
		return WIN_FOR + " " + name;
	}

	public void wonPoint(String player) {
		if (player == player1Name)
			player1WonPoints++;
		else
			player2WonPoints++;
	}
}