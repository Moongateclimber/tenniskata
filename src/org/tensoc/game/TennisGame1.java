package org.tensoc.game;

class Player {
	private int pointsWon;
	private String name;

	public Player(String name) {
		this.name = name;
	}

	public int getPointsWon() {
		return pointsWon;
	}

	public String getName() {
		return name;
	}

	public void wonPoint() {
		pointsWon++;
	}
}

class TennisTerms {
	public static final String FORTY = "Forty";
	public static final String WIN_FOR = "Win for";
	public static final String ADVANTAGE = "Advantage";
	public static final String DEUCE = "Deuce";
	public static final String THIRTY = "Thirty";
	public static final String FIFTEEN = "Fifteen";
	public static final String ALL = "All";
	public static final String LOVE = "Love";

	public static String getNamesForBasicScore(int score) {
		switch (score) {
		case 0:
			return TennisTerms.LOVE;
		case 1:
			return TennisTerms.FIFTEEN;
		case 2:
			return TennisTerms.THIRTY;
		case 3:
			return TennisTerms.FORTY;
		default:
			return "Unnamed score";
		}
	}
}

public class TennisGame1 implements TennisGame {
	public static final int LAST_POINT_BEFORE_ADVANTAGE_SCORING = 3;

	Player players[] = new Player[2];

	public TennisGame1(String player1Name, String player2Name) {
		players[0] = new Player(player1Name);
		players[1] = new Player(player2Name);
	}

	public void wonPoint(String playerName) {
		getPlayerByName(playerName).wonPoint();
	}

	private Player getPlayerByName(String playerName) {
		for (int i = 0; i < 2; i++)
			if (players[i].getName().equals(playerName))
				return players[i];
		return null;
	}

	public String getScore() {
		if (isDeuce())
			return getDeuceScore();

		if (isAdvantage())
			return getAdvantageScore();

		return getBasicScore();
	}

	private boolean isAdvantage() {
		return players[0].getPointsWon() > LAST_POINT_BEFORE_ADVANTAGE_SCORING
				|| players[1].getPointsWon() > LAST_POINT_BEFORE_ADVANTAGE_SCORING;
	}

	private boolean isDeuce() {
		return players[0].getPointsWon() == players[1].getPointsWon();
	}

	private String getDeuceScore() {
		if (players[0].getPointsWon() < LAST_POINT_BEFORE_ADVANTAGE_SCORING)
			return TennisTerms.getNamesForBasicScore(players[0].getPointsWon())
					+ "-" + TennisTerms.ALL;
		else
			return TennisTerms.DEUCE;
	}

	private String getAdvantageScore() {
		Player leadingPlayer = getLeadingPlayer();

		if (onePointAdvantage(leadingPlayer))
			return TennisTerms.ADVANTAGE + " " + leadingPlayer.getName();
		else
			return TennisTerms.WIN_FOR + " " + leadingPlayer.getName();
	}

	private Player getLeadingPlayer() {
		return players[0].getPointsWon() > players[1].getPointsWon() ? players[0]
				: players[1];
	}

	private String getBasicScore() {
		return TennisTerms.getNamesForBasicScore(players[0].getPointsWon())
				+ "-"
				+ TennisTerms.getNamesForBasicScore(players[1].getPointsWon());
	}

	private boolean onePointAdvantage(Player player) {
		return player.getPointsWon() == opponent(player).getPointsWon() + 1;
	}

	private Player opponent(Player player) {
		return (players[0] == player ? players[1] : players[0]);
	}

}
