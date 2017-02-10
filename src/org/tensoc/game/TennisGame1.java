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

public class TennisGame1 implements TennisGame {
	public static final String FORTY = "Forty";
	public static final String WIN_FOR = "Win for";
	public static final String ADVANTAGE = "Advantage";
	public static final String DEUCE = "Deuce";
	public static final String THIRTY = "Thirty";
	public static final String FIFTEEN = "Fifteen";
	public static final String ALL = "All";
	public static final String LOVE = "Love";

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
			if (lessThanForty(players[0].getPointsWon()))
				return getNamesForBasicScore(players[0].getPointsWon()) + "-"
						+ ALL;
			else
				return DEUCE;

		if (moreThanForty(players[0].getPointsWon())
				|| moreThanForty(players[1].getPointsWon()))
			for (int i = 0; i < 2; i++) {
				if (onePointAdvantage(players[i]))
					return ADVANTAGE + " " + players[i].getName();
				if (moreThanOnePointAdvantage(players[i]))
					return WIN_FOR + " " + players[i].getName();
			}

		return getNamesForBasicScore(players[0].getPointsWon()) + "-"
				+ getNamesForBasicScore(players[1].getPointsWon());
	}

	protected boolean moreThanOnePointAdvantage(Player player) {
		return player.getPointsWon() > opponent(player)
				.getPointsWon() + 1;
	}

	protected boolean onePointAdvantage(Player player) {
		return player.getPointsWon() == opponent(player).getPointsWon() + 1;
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
		return players[0].getPointsWon() == players[1].getPointsWon();
	}

	private boolean lessThanForty(int pointsWon) {
		return pointsWon < 3;
	}

	private boolean moreThanForty(int pointsWon) {
		return pointsWon >= 4;
	}

	private Player opponent(Player player) {
		for(int i=0; i<2; i++)
			if(players[i]!=player)
				return players[i];
		return null;
	}

}
